package leetcode.niuke.suanfa;

/**
 * @Author: zengqx
 * @Date: 2023/2/7 23:32
 */
public class NC243 {

    public static void main(String[] args){
        int result = findTargetSumWays(new int[]{1},1);
        System.out.println(result);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public static int findTargetSumWays (int[] nums, int target) {
        // write code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
        }
        int tempSum = (sum + target) /2;
        if((sum + target) % 2 == 1){
            return 0;
        }
        int[] dp = new int[tempSum + 1];
        dp[0] = 1;
        for(int i = 0;i < nums.length;i++){
            for(int j = tempSum;j >= nums[i];j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[tempSum];
    }
}
