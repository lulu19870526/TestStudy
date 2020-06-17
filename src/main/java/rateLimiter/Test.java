package rateLimiter;

import com.google.common.util.concurrent.RateLimiter;



public class Test {

    public static void  main(String[] args){
        RateLimiter limiter = RateLimiter.create(5);
        for(int i = 0; i < 5;i++) {
            //注意，acquire 的返回表示的是等待时间。
            System.out.println(limiter.acquire());
        }

        System.out.println();

        /**
         * limiter.acquire(5) 表示桶的容量为 5 且每秒新增 5 个令牌，令牌桶算法允许一定程度的突发，
         * 所以可以一次性消费 5 个令牌，但接下来的 limiter.acquire(1) 将等待差不多 1 秒桶中才能有令牌，
         * 且接下来的请求也整形为固定速率了
         */
        RateLimiter limiter1 = RateLimiter.create(5);
        System.out.println(limiter1.acquire(5));
        System.out.println(limiter1.acquire(1));
        System.out.println(limiter1.acquire(1));
    }
}
