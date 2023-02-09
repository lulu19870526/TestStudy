package base.builder;

/**
 * @Author: zengqx
 * @Date: 2023/2/9 14:56
 */
public class Test {

    public static void main(String[] args){
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.getResult();
        product.show();
    }
}
