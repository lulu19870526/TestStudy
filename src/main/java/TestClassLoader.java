/**
 * Created by zengqx on 2017/10/25.
 */
public class TestClassLoader {
    public void hello() {
        System.out.println("恩，是的，我是由 " + getClass().getClassLoader().getClass()
                + " 加载进来的");
    }
}
