package leetcode;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args){
        String str = removeDuplicateLetters("bcdabcd");
        System.out.println("str ="+str);
    }

    public static String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0)
            return null;
        String result = "0";
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length();i++){
            char temp = s.charAt(i);
            if(map.containsKey(temp))
                map.put(temp,map.get(temp)+1);
            else
                map.put(temp,1);
        }

        boolean[] visit = new boolean[256];
        for(int i = 0;i < s.length();i++){
            char key = s.charAt(i);
            map.put(key,map.get(key)-1);

            if(!visit[key]){
                for(int j = result.length()-1;j >= 1;j--){
                    char c = result.charAt(j);
                    if(key < c && map.get(c) > 0){
                        visit[c] = false;
                        result = result.substring(0,result.length()-1);
                    }else if(key > c){
                        break;
                    }else if(key < c && map.get(c) == 0){
                        break;
                    }
                }
                visit[key] = true;
                result = result + key;
            }

        }
        return result.substring(1);

    }
}
