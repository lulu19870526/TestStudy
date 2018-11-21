package zookeeper.config;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

public class Provider {

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        int i = 0;
        // 每秒执行一次
        while (true) {
            i++;
            //不区分版本 version=-1
            ZkServicce.getZk().setData(ZkServicce.ZOOKEEPER_PATH, ("hello word" + i).getBytes(), -1);
            Thread.sleep(1000);
        }

    }
}
