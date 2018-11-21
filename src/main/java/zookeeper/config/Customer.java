package zookeeper.config;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.io.IOException;

public class Customer {

    private Watcher wh = new Watcher() {
        /**
         * Watched事件
         */
        public void process(WatchedEvent event) {
            System.out.println("返回事件：" + event.toString());

            if (event.getPath() != null)
                try {
                    System.out
                            .println("监听事件中的值:" + new String(ZkServicce.getZk().getData(event.getPath(), false, null)));
                } catch (KeeperException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

        }
    };

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        Customer customer = new Customer();
        while (true) {
            System.out.println(
                    "获取值：" + new String(ZkServicce.getZk().getData(ZkServicce.ZOOKEEPER_PATH, customer.wh, null)));// 添加Watch
            Thread.sleep(1000);

        }

    }

}
