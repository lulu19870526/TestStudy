package dynamicProgramming.beibao;

/**
 * 动态规划问题——完全背包
 * 1、问题描述
 * 已知：有N种物品和一个容量为V 的背包，每种物品都有无限件可用。放入第i种物品的耗费的空间是C[i]，得到的价值是W[i]。
 * 求解：将哪些物品装入背包，可使这些物品的耗费的空间总和不超过背包容量，且价值总和最大？
 * 2、基本思路
 * 这个问题与01背包问题非常类似，不同的是每件物品有无限件。从每件物品的角度来看，它相关的策略并非取或者不取，
 * 而是有取0件、取1件、取2件... 直至取 V/C[i] 等很多种。
 *
 * 如果按照01背包的思路，用二维数组F[i ][ v] 表示前i件物品恰放入一个容量恰为v的背包可以获得的最大价值
 */
public class CompletePack {

    public static int maxWealth(int[] cost, int[] wealth, int N, int V){
        //给dp table加一行和一列避免复杂的初始化问题
        int[][] dp = new int[N+1][V+1];
        //初始化
        for (int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++){
            dp[0][i] = 0;
        }
        for (int i = 1; i < N+1; i++){
            for (int j = 1; j < V+1; j++){
                //假设不选第i件
                dp[i][j] = dp[i-1][j];
                for (int k = 1; k*cost[i-1] <= j; k++){
                    //可以选k件
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - k*cost[i-1]] + k*wealth[i-1]);
                }
            }
        }
        //观察dp table值
        for (int i = 0; i < N+1; i++){
            for (int j = 0; j < V+1; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[N][V];
    }

    public static void main(String[] args) {
        int[] cost = new int[]{2, 3, 4, 7};
        int[] wealth = new int[]{1, 3, 5, 9};
        int N = 4;
        int V = 10;
        int i = maxWealth(cost, wealth, N, V);
        System.out.println(i);
    }

}
