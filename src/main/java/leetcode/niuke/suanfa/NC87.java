package leetcode.niuke.suanfa;

/**
 * @Author: zengqx
 * @Date: 2023/1/25 14:49
 */
public class NC87 {

    public static void main(String[] args){
        int result = solve(874520,7);
        System.out.println(result);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回最差情况下扔棋子的最小次数
     * @param n int整型 楼层数
     * @param k int整型 棋子数
     * @return int整型
     */
    public static int solve (int n, int k) {
        // write code here
        if(n < 1 || k < 1){
            return 0;
        }
        if(k == 1){
            return n;
        }
        int[][] dp = new int[n+1][k+1];
        for(int i =1;i <= n;i++){
            dp[i][1] = i;
        }
        for(int i = 1;i <= n;i++){
            for(int j = 2;j <= k;j++){
                int tempMin = Integer.MAX_VALUE;
                for(int q = 1;q <=i;q++){
                    tempMin = Math.min(tempMin,Math.max(dp[q-1][j-1],dp[i-q][j]));
                }
                dp[i][j] = tempMin + 1;
            }
        }
        return dp[n][k];
    }
}
