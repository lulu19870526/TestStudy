package base.builder;

/**
 * 建造者模式：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
 *
 * 主要用于创建一些复杂的对象，这些对象内部构建间的建造顺序通常是稳定的，
 * 但对象内部的构建通常面临着复杂的变化
 *
 * @Author: zengqx
 * @Date: 2023/2/9 14:56
 */
public class Test {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.getResult();
        product.show();
    }
}
