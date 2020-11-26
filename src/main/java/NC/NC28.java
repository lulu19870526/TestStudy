package NC;

import java.util.HashMap;

public class NC28 {

    public static void main(String[] args){
        String result = minWindow("a","a");
        System.out.println("result:"+result);
    }

    /**
     *
     * @param S string字符串
     * @param T string字符串
     * @return string字符串
     */
    public static String minWindow (String S, String T) {
        // write code here
        if(S == null ||  T == null || S.length() == 0 || T.length() == 0)
            return "";
        int count =0;
        int left =0;
        int minLen = S.length() + 1;
        String result = "";
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0 ;i < T.length();i++){
            Character temp = new Character(T.charAt(i));
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
            }else{
                map.put(temp,1);
            }
        }

        for(int i = 0; i < S.length();i++){
            if(map.containsKey(S.charAt(i))){
                map.put(S.charAt(i),map.get(S.charAt(i)) - 1);
                if(map.get(S.charAt(i)) >= 0)
                    count ++;

                while(count == T.length()){
                    if(minLen > i - left + 1){
                        minLen = i - left + 1;
                        result = S.substring(left,i+1);
                    }
                    if(map.containsKey(S.charAt(left))){
                        map.put(S.charAt(left),map.get(S.charAt(left)) + 1);
                        if(map.get(S.charAt(left)) > 0)
                            count --;
                    }

                    left++;
                }
            }
        }

        return result;
    }
}
