package base.factory.factoryMethod;

import base.factory.HighEndMask;
import base.factory.IMask;

/**
 * @Author: zengqx
 * @Date: 2023/2/4 12:04
 */
public class HighEndFactory implements IMaskFactory {

    @Override
    public IMask createMask() {
        IMask mask = new HighEndMask();
        // .....
        // HighEndMask的100行初始化代码
        return mask;
    }
}
