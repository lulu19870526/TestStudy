package algorithm;

import java.util.ArrayList;
import java.util.List;

public class BitMap {

    private static final int N = 10000000;

    private int[] a = new int[N/32 + 1];

    /**
     * 设置所在的bit位为1
     * @param n
     */
    public void addValue(int n){
        //row = n / 32 求十进制数在数组a中的下标
        int row = n >> 5;
        //相当于 n % 32 求十进制数在数组a[i]中的下标,其中n%32和n &(32-1)即 n& 0001 1111是等价的
        /**
         * <<      :     左移运算符，num << 1,相当于num乘以2
         *
         * >>      :     右移运算符，num >> 1,相当于num除以2
         *
         * >>>    :     无符号右移，忽略符号位，空位都以0补齐
         */
        a[row] |= 1 << (n & 0x1F);
    }

    // 判断所在的bit为是否为1
    public boolean exits(int n){
        int row = n >> 5;
        int temp = a[row] & ( 1 << (n & 0x1F));
        System.out.println("temp="+temp);
        //判断对应位上值是否为1，如果为1则存在，反之不存在
        return (a[row] & ( 1 << (n & 0x1F))) != 0;
    }

    public void display(int row){
        System.out.println("BitMap位图展示");
        for(int i=0;i<row;i++){
            List<Integer> list = new ArrayList<Integer>();
            int temp = a[i];
            for(int j=0;j<32;j++){
                list.add(temp & 1);
                temp >>= 1;
            }
            System.out.println("a["+i+"]" + list);
        }
    }


    public static void main(String[] args){

        int num[] = {1,5,30,32,64,56,159,120,21,17,35,45};
        BitMap map = new BitMap();
        for(int i=0;i<num.length;i++){
            map.addValue(num[i]);
        }

        int temp = 120;
        if(map.exits(temp)){
            System.out.println("temp:" + temp + "has already exists");
        }

        int temp1 = 2;
        if(map.exits(temp1)){
            System.out.println("temp1:" + temp1 + "has already exists");
        }else{
            System.out.println("temp1:" + temp1 + "is not exists");
        }
        map.display(5);

    }
}
