package base.factory.factoryMethod;

import base.factory.IMask;

/**
 * 工厂方法模式由多个工厂类实现工厂接口，
 * 利用多态来创建不同的产品对象，从而避免了冗长的if-else条件判断。
 *
 * @Author: zengqx
 * @Date: 2023/2/4 12:05
 */
public class Test {

    public static void main(String[] args) {
        /**
         *工厂类变成了抽象的接口，高端口罩工厂和低端口罩工厂这两个子类分别实现了该接口
         *
         * 在客户端，想要创建什么样的口罩对象，只需实例化不同的工厂子类，
         * 调用相同的创建方法，无需再传入参数
         *
         * 问题：如果需要创建的子类越来越多，不止有口罩，还有防护服等，
         * 难道每一个子类都对应一个工厂类吗？
         * 答案：抽象工厂模式（对产品类进行分组，每组中的不同产品，由同一个工厂类的不同方法来创建）
         *
         */
        IMaskFactory factoryA = new LowEndFactory();
        IMaskFactory factoryB = new HighEndFactory();
        IMask maskA = factoryA.createMask();
        IMask maskB = factoryB.createMask();
        maskA.show();
        maskB.show();
    }
}
