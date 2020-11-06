package javaStudy.failfastsafe;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 安全失败（fail—safe）
 *
 *       采用安全失败机制的集合容器，在遍历时不是直接在集合内容上访问的，而是先复制原有集合内容，在拷贝的集合上进行遍历。
 *       原理：由于迭代时是对原集合的拷贝进行遍历，所以在遍历过程中对原集合所作的修改并不能被迭代器检测到，
 *       所以不会触发Concurrent Modification Exception。
 *       缺点：基于拷贝内容的优点是避免了Concurrent Modification Exception，但同样地，迭代器并不能访问到修改后的内容，
 *       即：迭代器遍历的是开始遍历那一刻拿到的集合拷贝，在遍历期间原集合发生的修改迭代器是不知道的。
 *       场景：java.util.concurrent包下的容器都是安全失败，可以在多线程下并发使用，并发修改。
 */
public class FailSafeExample {

    public static void main(String[] args)
    {
        ConcurrentHashMap<String,String> premiumPhone =
                new ConcurrentHashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");

        Iterator iterator = premiumPhone.keySet().iterator();

        /**
         *

        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }
         */
        for(Map.Entry<String,String> entry : premiumPhone.entrySet()){
            System.out.println(entry.getValue());
            premiumPhone.put("Sony", "Xperia Z");
        }

    }
}
