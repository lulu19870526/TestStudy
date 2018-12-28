package base.observe.Yingyong;

public class Main {
    public static void main(String[] args) {
        // 进度值
        ProgressBar progressBar = new ProgressBar();

        // 图形进度条, 和数值进度条 都订阅了这个进度值
        // 在进度值变化时, 这两个观察者就会更新自己的进度
        progressBar.addObserver(new DigitObserver());
        progressBar.addObserver(new GraphObserver());

        // 进度值开始变动
        progressBar.execute();
    }
}
