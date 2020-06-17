package algorithm.permutationsequence;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args){
        String result = getPermutation(3,3);
        System.out.println("result:"+result);
    }

    public static String getPermutation(int n, int k) {
        k--;

        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1;i <= n;i++)
            list.add(i);

        int factNum = 1;
        for(int i = 2;i < n;i++)
            factNum *= i;

        StringBuilder strBuild = new StringBuilder();
        int times = n-1;
        while(times >= 0){
            int tempIndex = k /factNum;
            strBuild.append(list.get(tempIndex));
            list.remove(tempIndex);
            k = k % factNum;

            if(times != 0)
                factNum = factNum / times;

            times --;
        }
        return strBuild.toString();
    }
}
