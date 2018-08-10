package test;

/**
 * Created by on 2017/12/13.
 */
public class TestHelloWorld {

    private String desc;

    public TestHelloWorld(String desc) {
        this.desc = desc;
    }

    public String toString() {
        return "desc的值为" + desc;
    }

    public static void main(String args[]) {
        TestHelloWorld test = new TestHelloWorld("beijing welcome you!");
        System.out.println(test.toString());
    }
}
