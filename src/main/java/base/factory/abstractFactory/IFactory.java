package base.factory.abstractFactory;

import base.factory.IMask;
import base.factory.IProtectiveSuit;

/**
 * @Author: zengqx
 * @Date: 2023/2/4 12:24
 */
public interface IFactory {

    /**
     * 创建口罩
     *
     * @return
     */
    IMask createMask();

    /**
     * 创建防护服
     *
     * @return
     */
    IProtectiveSuit createSuit();
}
