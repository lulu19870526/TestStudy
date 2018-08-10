package dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * Created by zengqx on 2018/1/3.
 */
public class TestDynamicProxy {

    public static void main(String args[]){
        SingerService singerService = new SingerServiceImpl();
        MyInvocationHandler myInvocationHandler =  new MyInvocationHandler(singerService);
        SingerService proxy = (SingerService)myInvocationHandler.getProxy();

        proxy.sing("日不落");
        proxy.dance("霓裳羽衣舞");

    }
}
