package base.factory.simpleFactory;

import base.factory.HighEndMask;
import base.factory.IMask;
import base.factory.LowEndMask;

/**
 * @Author: zengqx
 * @Date: 2023/2/4 11:50
 */
public class MaskFactory {

    /**
     * 像这样通过工厂类创建对象，并根据传入参数决定具体子类对象的做法，就是简单工厂模式
     *
     * 问题：如果新增新的口罩类型，口罩工厂的创建方法中就要增加新的if-else判断，不符合开发封闭原则
     * 所谓面向对象的开放-封闭原则，就是在程序中对“扩展”开放，对“修改”封闭。
     * 如果每次业务改动都要增加新的if-else，就涉及对旧有代码的修改，不但容易出错，可读性也不好
     *
     * 在创建方法中传入参数（这里的参数是type），根据参数来做条件判断，决定创建什么样的口罩
     * @param type
     * @return
     */
    public IMask createMask(String type) {
        IMask mask = null;
        if ("高端口罩".equals(type)) {
            mask = new HighEndMask();
            // .....
            // HighEndMask的100行初始化代码
        } else if ("低端口罩".equals(type)) {
            mask = new LowEndMask();
            // .....
            // LowEndMask的100行初始化代码
        }
        return mask;
    }
}
