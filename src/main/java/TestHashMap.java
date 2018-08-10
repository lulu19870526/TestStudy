import java.util.HashMap;

/**
 * Created by zengqx on 2017/11/29.
 */
public class TestHashMap {

    public static void main(String args[]){

        HashMap<String ,String> map  = new HashMap<String ,String>();
        map.put("1","北京");
        map.put("4","广州 ");

        String city = map.get("4");
        System.out.println("city="+city);
        map.put("4", "深圳");
        String city1 = map.get("4");
        System.out.println("city1=" + city1);

        int a=tableSizeFor(7);
        System.out.println("a=" + a);
    }

  public  static final int tableSizeFor(int cap) {
        int MAXIMUM_CAPACITY = 1 << 30;

        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
