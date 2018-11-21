package zookeeper.config;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;


/**
 *  发布/订阅模式是一对多的关系，多个订阅者对象同时监听某一主题对象，
 *  这个主题对象在自身状态发生变化时会通知所有的订阅者对象。使它们能自动的更新自己的状态
 */
public class ZkServicce {

    private static ZooKeeper zk;
    private static final int SESSION_TIMEOUT = 30 * 1000;
    public static String ZOOKEEPER_PATH = "/zookeeper";

    static {

        try {
            //创建zk连接
            createZk();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            //创建path
            createZkPath();
        } catch (KeeperException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void createZk() throws IOException {
        if (zk == null)
            zk = new ZooKeeper("localhost:2181,localhost:2182,localhost:2183", SESSION_TIMEOUT, null);
    }

    public static void createZkPath() throws KeeperException, InterruptedException {
        Stat stat = null;
        stat = zk.exists(ZOOKEEPER_PATH, false);
        if (stat == null)
            zk.create(ZkServicce.ZOOKEEPER_PATH, ("hello word").getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public static ZooKeeper getZk() {
        return zk;
    }

    public static void setZk(ZooKeeper zk) {
        ZkServicce.zk = zk;
    }

}
