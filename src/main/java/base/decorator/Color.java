package base.decorator;


//上色，需要先画画再给画上色
public class Color implements Work {

    Work w;//在内部维护一个被装饰的类

    public Color(Work w) {
        this.w = w;
    }

    public void work() {

        w.work();
        System.out.println("给画上色");
    }
}
