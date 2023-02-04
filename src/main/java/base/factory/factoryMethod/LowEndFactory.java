package base.factory.factoryMethod;

import base.factory.IMask;
import base.factory.LowEndMask;

/**
 * @Author: zengqx
 * @Date: 2023/2/4 12:05
 */
public class LowEndFactory implements IMaskFactory {

    @Override
    public IMask createMask() {
        IMask mask = new LowEndMask();
        // .....
        //  LowEndMask的100行初始化代码
        return mask;
    }
}