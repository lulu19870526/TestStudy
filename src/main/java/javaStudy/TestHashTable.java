package javaStudy;

import java.util.Hashtable;


/**
 * Hashtable是线程安全的,它的key、value都不可以为null
 */
public class TestHashTable {

    public static void main(String[] args){
        Hashtable<String ,String> hashtable = new Hashtable<>();
        //hashtable.put(null,null);

        //hashtable.put(null,"hello");
        hashtable.put("1","hello");

    }
}
