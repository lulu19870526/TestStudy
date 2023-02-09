package base.builder;

/**
 * @Author: zengqx
 * @Date: 2023/2/9 14:55
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPartA();
        builder.buildPartB();
    }
}
