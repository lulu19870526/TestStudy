package zookeeper.lock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//获取set集合的第一个元素
public class SetFirst {

    public static void main(String[] args){
        Set set = new HashSet();
        set.add("xixi");
        set.add("haha");
        set.add(123);
        set.add(1.2);
        System.out.println(set);//[1.2, haha, xixi, 123]
        //第一种方法
        if(!set.isEmpty()){
            System.out.println(set.iterator().next());// 1.2
        }
        //第二种方法:将set集合转换成list集合 取第一个
        List list = new ArrayList(set);
        System.out.println(list.get(0));// 1.2
    }
}
