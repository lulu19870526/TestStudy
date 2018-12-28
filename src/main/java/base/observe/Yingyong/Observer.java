package base.observe.Yingyong;

/**
 * 观察者接口-观察者的统一定义
 */
public interface Observer {
    /**
     * Observer(观察者)会被数值生成器通知, 来更新自己的状态
     */
    void update(ProgressBar generator);
}
