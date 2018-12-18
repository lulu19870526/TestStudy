package redis;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class MyRedistest {

    public static void main(String[] args) {
        final String watchkeys = "watchkeys";
        ExecutorService executor = Executors.newFixedThreadPool(20);  //20个线程池并发数

        final Jedis jedis = new Jedis("192.168.56.101", 6379);
        jedis.set(watchkeys, "100");//设置起始的抢购数
        // jedis.del("setsucc", "setfail");
        jedis.close();

        for (int i = 0; i < 1000; i++) {//设置1000个人来发起抢购
            executor.execute(new MyRunnable("user"+getRandomString(6)));
        }
        executor.shutdown();
    }


    public static String getRandomString(int length) { //length是随机字符串长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}

class MyRunnable implements Runnable {

    String watchkeys = "watchkeys";// 监视keys
    Jedis jedis = new Jedis("192.168.56.101", 6379);
    String userinfo;
    public MyRunnable() {
    }
    public MyRunnable(String uinfo) {
        this.userinfo=uinfo;
    }
    @Override
    public void run() {
        try {
            jedis.watch(watchkeys);// watchkeys

            String val = jedis.get(watchkeys);
            int valint = Integer.valueOf(val);

            if (valint <= 100 && valint>=1) {

                Transaction tx = jedis.multi();// 开启事务
                // tx.incr("watchkeys");
                tx.incrBy("watchkeys", -1);

                List<Object> list = tx.exec();// 提交事务，如果此时watchkeys被改动了，则返回null

                if (list == null ||list.size()==0) {

                    String failuserifo = "fail"+userinfo;
                    String failinfo="用户：" + failuserifo + "商品争抢失败，抢购失败";
                    System.out.println(failinfo);
                    /* 抢购失败业务逻辑 */
                    jedis.setnx(failuserifo, failinfo);
                } else {
                    for(Object succ : list){
                        String succuserifo ="succ"+succ.toString() +userinfo ;
                        String succinfo="用户：" + succuserifo + "抢购成功，当前抢购成功人数:"
                                + (1-(valint-100));
                        System.out.println(succinfo);
                        /* 抢购成功业务逻辑 */
                        jedis.setnx(succuserifo, succinfo);
                    }

                }

            } else {
                String failuserifo ="kcfail" +  userinfo;
                String failinfo1="用户：" + failuserifo + "商品被抢购完毕，抢购失败";
                System.out.println(failinfo1);
                jedis.setnx(failuserifo, failinfo1);
                // Thread.sleep(500);
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }

    }

}
