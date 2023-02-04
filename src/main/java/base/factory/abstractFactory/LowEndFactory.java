package base.factory.abstractFactory;

import base.factory.IMask;
import base.factory.IProtectiveSuit;
import base.factory.LowEndMask;
import base.factory.LowEndProtectiveSuit;

/**
 * @Author: zengqx
 * @Date: 2023/2/4 12:25
 */
public class LowEndFactory implements IFactory {
    @Override
    public IMask createMask() {
        IMask mask = new LowEndMask();
        // .....
        //  LowEndMask的100行初始化代码
        return mask;
    }

    @Override
    public IProtectiveSuit createSuit() {
        IProtectiveSuit suit = new LowEndProtectiveSuit();
        // .....
        //  LowEndProtectiveSuit的100行初始化代码
        return suit;
    }
}