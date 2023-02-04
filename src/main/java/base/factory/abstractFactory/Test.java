package base.factory.abstractFactory;

import base.factory.IMask;
import base.factory.IProtectiveSuit;

/**
 * 抽象工厂模式把产品子类进行分组，
 * 同组中的不同产品由同一个工厂子类的不同方法负责创建，从而减少了工厂子类的数量。
 *
 * @Author: zengqx
 * @Date: 2023/2/4 12:27
 */
public class Test {
    public static void main(String[] args) {


        /**
         * 把产品类分组，组内不同产品对应同一工厂类的不同方法的设计模式，就是抽象工厂模式
         */
        IFactory factoryA = new LowEndFactory();
        IFactory factoryB = new HighEndFactory();
        //创建低端口罩
        IMask maskA = factoryA.createMask();
        //创建高端口罩
        IMask maskB = factoryB.createMask();
        //创建低端防护服
        IProtectiveSuit suitA = factoryA.createSuit();
        //创建高端防护服
        IProtectiveSuit suitB = factoryB.createSuit();

        maskA.show();
        maskB.show();
        suitA.showSuit();
        suitB.showSuit();
    }
}
