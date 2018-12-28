package base.observe.Yingyong;

import java.util.ArrayList;

/**
 * 由本类来模拟 随时间在涨的进度数值, 进度值变更后, 会通知进度条来更新自己的值.
 * 生成数值的类, 同时会保存观察者们, 当数值生成的时候就会去通知所有观察者们
 */
public class ProgressBar {
    /**
     * 保存Observer们
     */
    private ArrayList<Observer> observers = new ArrayList<>();

    /**
     * 当前数值
     */
    private int number;

    public int getNumber() {
        return number;
    }

    /**
     * 生成数值, 并通知给观察者们
     */
    public void execute() {
        for (int i = 0; i <= 100; i += 10) {
            number = i;
            notifyObservers();
        }
    }

    /**
     * 注册Observer
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * 向Observer发送通知
     */
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
        try {
            System.out.println();
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
