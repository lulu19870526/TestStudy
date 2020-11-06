package javaStudy.failfastsafe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * 快速失败（fail—fast）
 *
 *      在用迭代器遍历一个集合对象时，如果遍历过程中对集合对象的内容进行了修改（增加、删除、修改），
 *        则会抛出Concurrent Modification Exception。
 *        原理：迭代器在遍历时直接访问集合中的内容，并且在遍历过程中使用一个 modCount 变量。
 *           集合在被遍历期间如果内容发生变化，就会改变modCount的值。每当迭代器使用hashNext()/next()遍历下一个元素之前，
 *           都会检测modCount变量是否为expectedmodCount值，是的话就返回遍历；否则抛出异常，终止遍历。
 *       注意：这里异常的抛出条件是检测到 modCount！=expectedmodCount 这个条件。
 *       如果集合发生变化时修改modCount值刚好又设置为了expectedmodCount值，则异常不会抛出。
 *       因此，不能依赖于这个异常是否抛出而进行并发操作的编程，这个异常只建议用于检测并发修改的bug。
 *
 *       场景：java.util包下的集合类都是快速失败的，不能在多线程下发生并发修改（迭代过程中被修改）。
 */
public class FailFastExample {

    public static void main(String[] args)
    {
        Map<String,String> premiumPhone = new HashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");

        Iterator iterator = premiumPhone.keySet().iterator();

        /**
         * 会抛出ConcurrentModificationException
         */
        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }

    }
}
