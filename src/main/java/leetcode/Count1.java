package leetcode;

public class Count1 {

    public static void main(String[] args){
        int count = getCount(2);
        System.out.println("count="+count);
    }


    public static int getCount(int n){
        int result = 0;
        int flag = 1;
        for(int i = 0;i<32;i++){
            if((n & flag) != 0)
                result ++;
            flag = flag << 1;
        }
        return result;
    }
}
