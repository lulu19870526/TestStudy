package base.decorator;

public class Test {

    public static void main(String[] args) {

        Work w = new Drawing();
        Color c = new Color(w);
        c.work();
    }
}
