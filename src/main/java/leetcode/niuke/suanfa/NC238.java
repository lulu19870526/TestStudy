package leetcode.niuke.suanfa;

import java.util.ArrayList;

/**
 * @Author: zengqx
 * @Date: 2023/2/6 17:42
 */
public class NC238 {

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> list =
                combinationCount1(8,new int[]{2,3,5});
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param target int整型
     * @param nums int整型一维数组
     * @return int整型ArrayList<ArrayList<>>
     */
    public static ArrayList<ArrayList<Integer>> combinationCount1 (int target, int[] nums) {
        // write code here
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs1(nums,target,0,list,resultList);
        return resultList;
    }

    public static void dfs1(int[] nums,int target,int start,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> resultList){
        if(target == 0 ){
            resultList.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i < nums.length;i++){
            if(nums[i] <= target){
                list.add(nums[i]);
                dfs1(nums,target - nums[i],i,list,resultList);
                list.remove(list.size()-1);
            }
        }
    }
}
