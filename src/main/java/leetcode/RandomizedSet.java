package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
    List<Integer> list;
    HashMap<Integer,Integer> map;
    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer,Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;

        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        if(list.size() == 0){
            map.remove(val);
            return false;
        }else{
            int lastNum = list.get(list.size()-1);
            map.put(lastNum,map.get(val));
            list.set(map.get(val),lastNum);
            list.set(list.size()-1,val);
            /**
             * remove()这个方法是一个重载方法，
             * 即remove(int position)和remove(object object)，唯一的区别是参数类型
             */
            list.remove(new Integer(val));
            map.remove(val);
            return true;
        }

    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(list.size() > 0){
            return list.get(random.nextInt(list.size()));
        }
        return 0;
    }

    /**
     * ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
     * [[],[-1],[-2],[-2],[],[-1],[-2],[]]
     * @param args
     */
    public static void main(String[] args){
        RandomizedSet randomizedSet = new RandomizedSet();
        boolean b1 = randomizedSet.insert(-1);
        boolean b2 = randomizedSet.remove(-2);
        boolean b3 = randomizedSet.insert(-2);
        int a1 = randomizedSet.getRandom();
        boolean b4 = randomizedSet.remove(-1);
        boolean b5 = randomizedSet.insert(-2);
        int a2 = randomizedSet.getRandom();
    }
}
