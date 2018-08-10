import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zengqx on 2017/12/12.
 */
public class TestInvoke {

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("Reflect");
            Method method = clazz.getMethod("run", int.class);
            method.invoke(clazz.newInstance(), -1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("此处接收被调用方法内部未被捕获的异常");
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

 class Reflect {
    public void run(int i) throws ZeroException {
        B b = new B();
        b.run(i);
    }
}

class B {
    public void run(int i) throws ZeroException {
        if (i < 0) {
            throw new ZeroException("参数不能小于零！");
        }
        System.out.println("参数：" + i);

    }
}

class ZeroException extends Exception {
    private static final long serialVersionUID = 1L;

    private String detailMessage;

    public ZeroException(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    public String getMessage() {
        return detailMessage;
    }
}
