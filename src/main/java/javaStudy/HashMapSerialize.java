package javaStudy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by zengqx on 2018/11/1.
 */
public class HashMapSerialize {
    public static void main(String args[]) {
        HashMap<Integer, String> map = new HashMap(16);
        map.put(75, "114");
        map.put(91, "115");
        map.put(7, "70");
        map.put(11, "110");
        map.put(43, "111");
        map.put(59, "112");
        map.put(19, "30");
        map.put(3, "31");
        map.put(35, "32");
        map.put(27, "113");
        map.put(107, "116");
        map.put(123, "117");
        map.put(1, "10");


        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(
                    "E:\\testHashmapSerialize.txt"));
            oos.writeObject(map);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\testHashmapSerialize.txt"));
            HashMap<Integer, String> readMap = (HashMap<Integer, String>)ois.readObject();

            Set keys = readMap.entrySet();
            Iterator<Map.Entry<Integer, String>> ite = keys.iterator();
            while (ite.hasNext()) {
                Map.Entry<Integer, String> entry = ite.next();
                Integer tempKey = entry.getKey();
                String tempValue = entry.getValue();
                int tempHash = hashFun(entry.getKey());
                //int tempIndex = 15 & tempHash;
                int tempIndex = 31 & tempHash;
                System.out.println("key为"+tempKey+";value为"+tempValue  +";hash为"+tempHash+";tempIndex="+tempIndex+" -> ");
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static int hashFun(Object key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
