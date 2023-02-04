package base.factory.abstractFactory;

import base.factory.HighEndMask;
import base.factory.HighEndProtectiveSuit;
import base.factory.IMask;
import base.factory.IProtectiveSuit;

/**
 * @Author: zengqx
 * @Date: 2023/2/4 12:26
 */
public class HighEndFactory implements IFactory {
    @Override
    public IMask createMask() {
        IMask mask =  new HighEndMask();
        // .....
        // HighEndMask的100行初始化代码
        return mask;
    }

    @Override
    public IProtectiveSuit createSuit() {
        IProtectiveSuit suit =  new HighEndProtectiveSuit();
        // .....
        //  HighEndProtectiveSuit的100行初始化代码
        return suit;
    }
}
