package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zengqx on 2018/1/3.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object service;

    public MyInvocationHandler(Object service) {
        this.service = service;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("将要执行方法名为" + method.getName() + "的方法");
        Object result = method.invoke(service, args);
        System.out.println("已经执行完方法名为" + method.getName() + "的方法");
        System.out.println(method.getName()+"方法的返回值result="+result);
        System.out.println("");
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                service.getClass().getInterfaces(), this);
    }
}
