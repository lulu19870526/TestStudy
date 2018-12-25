package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Chushushang166 {

    public static void main(String[] args){
        String result = fractionToDecimal(1,2);
        System.out.println("result="+result);
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0)
            return "";

        long num = numerator;
        long denum = denominator;
        StringBuilder strBuild = new StringBuilder();
        if((num > 0 && denum < 0) || (num < 0 && denum > 0))
            strBuild.append("-");

        num = Math.abs(num);
        denum = Math.abs(denum);
        strBuild.append(num/denum);
        num = (num % denum)*10;

        List<Long> list = new ArrayList<Long>();
        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
        int index = 0;
        int beginIndex = -1;
        while(num > 0){
            if(map.containsKey(num)){
                beginIndex = map.get(num);
                break;
            }else{
                map.put(num,index++);
                list.add(num/denum);
                num =  (num % denum)*10;
            }
        }

        for(int i = 0;i<index;i++){
            if(i == 0)
                strBuild.append(".");
            if(i == beginIndex)
                strBuild.append("(");
            strBuild.append(list.get(i));
        }

        if(beginIndex != -1)
            strBuild.append(")");

        return strBuild.toString();
    }
}
