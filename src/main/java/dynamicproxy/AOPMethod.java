package dynamicproxy;

import java.lang.reflect.Method;

/**
 * Created by zengqx on 2018/1/3.
 */
public interface AOPMethod {

    //执行前切入
    public void before(Object proxy, Method method, Object[] args);

    //执行后切入
    public void after(Object proxy, Method method, Object[] args);
}
