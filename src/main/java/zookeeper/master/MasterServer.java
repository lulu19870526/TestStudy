package zookeeper.master;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkException;
import org.I0Itec.zkclient.exception.ZkInterruptedException;
import org.I0Itec.zkclient.exception.ZkNoNodeException;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

import java.io.Serializable;
import java.util.concurrent.*;

public class MasterServer {
    private ZkClient zkClient;
    //争抢的一个master节点
    private final String MASTER_NODE = "/master";
    //server链接字符串
    private static final String CONNECTION_STRING = "139.199.182.26:5000,139.199.182.26:5001,139.199.182.26:5002";
    //超时时间
    private static final int SESSION_TIMEOUT = 5000;
    //争抢master节点服务器信息
    private ServerData serverData;
    //争抢到的master节点服务器信息
    private ServerData masterData;
    //服务器是否启动
    private volatile boolean running = false;
    //master节点的监听事件
    IZkDataListener dataListener;

    private ScheduledExecutorService scheService = Executors.newScheduledThreadPool(1);


    public MasterServer(ZkClient zkClient, ServerData serverData) {
        this.zkClient = zkClient;
        this.serverData = serverData;//标识来争抢master节点的服务
        dataListener = new IZkDataListener() {

            public void handleDataChange(String dataPath, Object data) throws Exception {

            }


            public void handleDataDeleted(String dataPath) throws Exception {
                //监听节点删除时间
                scheService.schedule(new Runnable() {

                    public void run() {
                        takeMaster();
                    }
                }, 5, TimeUnit.SECONDS);
            }
        };
    }

    //开始争抢master的方法
    public void start() {
        if (running) {
            throw new RuntimeException("服务已经启动了");

        }
        running = true;
        zkClient.subscribeDataChanges(MASTER_NODE, dataListener);
        takeMaster();
    }

    //停止
    public void stop() {
        if (!running) {
            throw new RuntimeException("服务已经停止了");
        }
        running = false;
        zkClient.subscribeDataChanges(MASTER_NODE, dataListener);
        releaseMaster();
    }

    private void takeMaster() {
        if (!running) {
            return;
        }
        try {
            System.out.println(serverData.getServerName() + "来抢master节点");
            //用到了一个临时节点的特性
            zkClient.createEphemeral(MASTER_NODE, serverData);
            masterData = serverData;
            System.out.println(serverData.getServerName() + "争抢到了master节点");
            scheService.schedule(new Runnable() {

                public void run() {
                    if (checkMaster()) {
                        zkClient.delete(MASTER_NODE);
                    }
                }
            }, 5, TimeUnit.SECONDS);
        } catch (ZkNodeExistsException e) {
            //如果节点创建过程中提示节点已经存在的异常，那这个时候意味着master节点是存在的（特性，节点唯一性）
            //读取当前master节点的服务器信息
            ServerData serverData = zkClient.readData(MASTER_NODE);

            if (serverData == null) {
                //在读取过程中，发现master节点已经被释放
                takeMaster();
            } else {
                masterData = serverData;
            }
        }

    }

    //释放master
    private void releaseMaster() {
        if (checkMaster()) {
            zkClient.delete(MASTER_NODE);
        }
    }

    //校验当前的服务器是不是master
    private boolean checkMaster() {
        try {
            //读取当前master节点的数据，并赋值给masterdata
            ServerData ms = zkClient.readData(MASTER_NODE);
            masterData = ms;
            //这个时候，如果master节点的数据和当前过来争抢master节点的服务器的数据是一样的话，那么意味
            //当前的serverData就是master
            if (masterData.getServerName().equals(serverData.getServerName())) {
                return true;
            }
            return false;
        } catch (ZkNoNodeException e) {
            return false;
        } catch (ZkInterruptedException e) {
            return checkMaster();
        } catch (ZkException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(10);
        for (int i = 0; i < 10; i++) {
            final int idx = i;
            Runnable runnable = new Runnable() {

                public void run() {
                    try {
                        semaphore.acquire();
                        //初始化一个zkclient的连接
                        ZkClient zk = new ZkClient(CONNECTION_STRING,
                                SESSION_TIMEOUT, SESSION_TIMEOUT,
                                new SerializableSerializer());
                        //定义一台争抢master节点的服务器
                        ServerData serverData = new ServerData();
                        serverData.setServerId(idx);
                        serverData.setServerName("#server-" + idx);
                        //初始化一个争抢master节点的服务
                        MasterServer ms = new MasterServer(zk, serverData);
                        ms.start();
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }
        service.shutdown();
    }
}

/**
 * 每台服务器自身属性
 *@author hao.wang
 *@date 2017/1/20 15:37
 */
class ServerData implements Serializable {

    private int serverId;

    private String serverName;

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
}
