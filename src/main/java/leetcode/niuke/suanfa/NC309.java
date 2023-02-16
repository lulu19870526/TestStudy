package leetcode.niuke.suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zengqx
 * @Date: 2023/2/16 12:06
 */
public class NC309 {

    public static void main(String[] args){
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(10);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(1);
        ArrayList<ArrayList<Integer>> nums = new ArrayList<>();
        nums.add(new ArrayList<>(list1));
        nums.add(new ArrayList<>(list2));
        ArrayList<Integer> result = knapsack(6,2,nums);
        for(int num: result){
            System.out.println(num);
        }
    }

    public static ArrayList<Integer> knapsack (int v, int n, ArrayList<ArrayList<Integer>> nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //问题1
        int[] dp = new int[v+1];
        //问题2
        int[] dp1 = new int[v+1];
        for(int i = 1;i <= v;++i){
            int max = Integer.MIN_VALUE;
            int max1 = Integer.MIN_VALUE;
            for(int j = 0;j < n;++j){
                if(i >= nums.get(j).get(0)){
                    // 遍历所有物品，找出能够装入当前背包的最大价值
                    max = Math.max(dp[i - nums.get(j).get(0)] + nums.get(j).get(1),max);
                    // 问题2要求背包正好装满，故无需去计算不装满背包的情况
                    max1 = Math.max(dp1[i - nums.get(j).get(0)] + nums.get(j).get(1),max1);
                }
                // 背包不装满
                max = Math.max(max,dp[i-1]);
            }
            dp[i] = max;
            dp1[i] = max1;
        }
        res.add(dp[v]);
        res.add(dp1[v] < 0 ? 0 : dp1[v]);
        return res;
    }
}
