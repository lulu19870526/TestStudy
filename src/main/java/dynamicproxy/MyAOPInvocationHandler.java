package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zengqx on 2018/1/3.
 */
public class MyAOPInvocationHandler implements InvocationHandler {
    private Object service;
    private AOPMethod aopMethod;

    public MyAOPInvocationHandler(Object service,AOPMethod aopMethod) {
        this.service = service;
        this.aopMethod = aopMethod;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.aopMethod.before(proxy, method,args);//执行前切入
        Object result = method.invoke(service, args);
        this.aopMethod.after(proxy, method,args);//执行后切入
        System.out.println("");
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                service.getClass().getInterfaces(), this);
    }
}