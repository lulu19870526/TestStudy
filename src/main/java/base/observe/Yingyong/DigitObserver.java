package base.observe.Yingyong;

/**
 * 数字进度类. 这是其中一种观察者的实现, 也是一种具体的进度条.
 * 将进度以数字形式展现出来
 */
public class DigitObserver implements Observer {
    /**
     * Observer(观察者)会被数值生成器通知, 来更新自己的状态
     */
    @Override
    public void update(ProgressBar generator) {
        System.out.println("数字版进度条:" + generator.getNumber() + "%");
    }
}