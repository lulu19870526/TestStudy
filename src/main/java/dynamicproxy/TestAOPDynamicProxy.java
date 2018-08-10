package dynamicproxy;

import java.lang.reflect.Method;

/**
 * Created by zengqx on 2018/1/3.
 */
public class TestAOPDynamicProxy {
    public static void main(String args[]){
        SingerService singerService = new SingerServiceImpl();
        MyAOPInvocationHandler myAOPInvocationHandler =  new MyAOPInvocationHandler(singerService, new AOPMethod() {
            public void before(Object proxy, Method method, Object[] args) {
                System.out.println("将要执行方法名为" + method.getName() + "的方法");
            }

            public void after(Object proxy, Method method, Object[] args) {
                System.out.println("已经执行完方法名为" + method.getName() + "的方法");
            }
        });
        SingerService proxy = (SingerService)myAOPInvocationHandler.getProxy();

        proxy.sing("日不落");
        proxy.dance("霓裳羽衣舞");

    }
}
