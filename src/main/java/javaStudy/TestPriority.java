package javaStudy;

/**
 * Created by zengqx on 2018/11/1.
 */
public class TestPriority {

    public static void main(String[] args){
        String table = "1111111";
        //优先级从右向左
        int a =  (table != null) ? table.length(): (12 > 0) ? 12 :16;
        System.out.println("a="+a);
    }

}
