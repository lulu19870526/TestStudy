/**
 * Created by zengqx on 2017/12/13.
 */
public class TestMain {
    public static void main(String[] args){
        if(args != null && args.length > 0){
            for(int i = 0;i<args.length;i++){
                System.out.println(i+":"+args[i]);
            }
        }
    }
}
