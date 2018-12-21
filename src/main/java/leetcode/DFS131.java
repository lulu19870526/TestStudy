package leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class DFS131 {

    public static void main(String[] args){
        List<ArrayList<String>> list = partition("aab");
        System.out.println("list="+JSON.toJSONString(list));
    }

    public static List<ArrayList<String>> partition(String s) {
        List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(s == null || s.length() == 0)
            return result;
        ArrayList<String> out = new ArrayList<String>();
        partiDFS(s,0,out,result);
        System.out.println("final result="+JSON.toJSONString(result));
        return result;
    }

    public static void partiDFS(String s,int start,ArrayList<String> out,List<ArrayList<String>> result){
        if(s.length() == start){
            result.add(new ArrayList<String>(out));//关键部分，如果result.add(out),最后结果为空
            System.out.println("out="+ JSON.toJSONString(out));
            return;
        }

        for(int i = start;i<s.length();i++){
            if(isPalin(s,start,i)){
                String sub = s.substring(start,i+1);
                System.out.println("sub="+sub);
                out.add(sub);
                // out.add(s.substring(start,i));
                partiDFS(s,i+1,out,result);
                out.remove(out.size()-1);
            }
        }
    }

    public static boolean isPalin(String s,int low,int high){
        while(low < high){
            if(s.charAt(low) == s.charAt(high)){
                low ++;
                high --;
            }else{
                return false;
            }
        }
        return true;
    }
}
