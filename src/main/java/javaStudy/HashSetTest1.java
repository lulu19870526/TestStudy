package javaStudy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zengqx on 2018/11/2.
 */
public class HashSetTest1 {
    public static void main(String[] args) {
       Set set = new HashSet();
       KeyMaster k1 = new KeyMaster(1);
        int hashK1 = hashFun(k1);
        KeyMaster k2 = new KeyMaster(2);
        int hashK2 = hashFun(k2);
        System.out.println("hashK1="+hashK1+";hashK2="+hashK2);
      set.add(k1); set.add(k1);
        set.add(k2); set.add(k2);
       System.out.print(set.size() + ":");
        k2.i = 1;
       System.out.print(set.size() + ":");
       set.remove(k1);
        System.out.print(set.size() + ":");
       set.remove(k2);
        System.out.print(set.size());


       }

    public static int hashFun(Object key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}

class KeyMaster {
   public int i;
    public KeyMaster(int i) { this.i = i; }
   public boolean equals(Object o) { return i == ((KeyMaster)o).i; }
   public int hashCode() { return i; }
    }


