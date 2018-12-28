package base.observe.Yingyong;

/**
 * 图形进度条, 这是其中一种观察者的实现, 也就是一种具体的进度条.
 * 将进度条以进度栏形式展现出来
 */
public class GraphObserver implements Observer {
    /**
     * Observer(观察者)会被数值生成器通知, 来更新自己的状态
     */
    @Override
    public void update(ProgressBar generator) {
        System.out.print("图形版进度条:");

        int count = generator.getNumber();

        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }

        System.out.println("");
    }
}
