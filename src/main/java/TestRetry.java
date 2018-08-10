/**
 * Created by zengqx on 2018/4/13.
 */
public class TestRetry {
    public static void main(String args[]){
        /*
        retry:
        for (int i = 0; i < 10; i++) {
            while (i == 5) {
                continue retry;
            }
            System.out.print(i + " ");
        }
        */


        for (int i = 0; i < 10; i++) {
            retry:// 2（行4）
            while (i == 5) {
                continue retry;
            }
            System.out.print(i + " ");
        }
    }
}
