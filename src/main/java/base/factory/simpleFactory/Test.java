package base.factory.simpleFactory;

import base.factory.IMask;

/**
 * 简单工厂模式有唯一的工厂类，工厂类的创建方法根据传入的参数做if-else条件判断，
 * 决定最终创建什么样的产品对象。
 *
 * @Author: zengqx
 * @Date: 2023/2/4 11:52
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 在客户端，想要创建什么样的口罩对象，只需传入对应的类型名称
         */
        MaskFactory factory = new MaskFactory();
        IMask maskA = factory.createMask("高端口罩");
        IMask maskB = factory.createMask("低端口罩");
        maskA.show();
        maskB.show();
    }
}
