package set;

import java.util.ArrayList;
import java.util.Iterator;

public class FailFastTest {

    public static void main(String args[]){
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("5");
        list.add("5");
        list.add("8");
        list.add("5");
        list.add("10");


        /**
         *     无论是add()、remove()，还是clear()，只要涉及到修改集合中的元素个数时，
         *  都会改变modCount的值
         *     调用iterator的iterator.remove()方法，该方法的实现中，
         *  会执行expectedModCount = modCount;这个语句，
         *   即expectedModCount赋值为modCount;
         *    这样就保证expectedModCount 等于modCount，
         * 不会抛出ConcurrentModificationException()这个异常
         */
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals("5")){
                iterator.remove();
            }
        }

        for(int i=0 ;i< list.size();i++){
            System.out.print(list.get(i) + "       ");
        }
    }
}
