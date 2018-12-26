package dynamicProgramming.beibao;

/**
 * 动态规划背包01问题
 * 背包问题具体例子：假设现有容量10kg的背包，另外有3个物品，分别为a1，a2，a3。
 * 物品a1重量为3kg，价值为4；物品a2重量为4kg，
 * 价值为5；物品a3重量为5kg，价值为6。将哪些物品放入背包可使得背包中的总价值最大
 */
public class Pack01 {

    public static void main(String[] args){
        int[] weight = {2,3,4,5};
        int[] value = {3,4,5,6};
        int m = 8;
        int n = 4;
        int[][] result = packFun(m,n,weight,value);
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=m; j++) {
                System.out.print(result[i][j]+"\t");
                if(j==m){
                    System.out.println();
                }
            }
        }

        int[] item = new int[4];
        findWhat(n,m,result,item,weight,value);
        for(int i =0;i<item.length;i++)
            System.out.print(" "+item[i]);
    }

    /**
     *
     * @param m  背包的最大容量
     * @param n   商品个数
     * @param weight  商品重量数组
     * @param value   商品价值数组
     * @return
     */
    public static int[][] packFun(int m,int n,int[] weight,int[] value){
         int[][] result = new int[n+1][m+1];
         for(int i = 0;i<n+1;i++)
             result[i][0] = 0;

         for(int j=0;j<m+1;j++)
             result[0][j] = 0;

         for(int i=1;i<n+1;i++)
             for(int j = 1;j<m+1;j++){
                 if(j < weight[i-1])
                     result[i][j] = result[i-1][j];
                 else{
                     result[i][j] =
                             Math.max(result[i-1][j],result[i-1][j-weight[i-1]]+value[i-1]);
                 }
             }
             return result;
    }

    public static void findWhat(int i,int j,int[][] result,int[] item,int[] weight,int[] value){
        if( i >0){
            if(result[i][j] == result[i-1][j]) {
                item[i - 1] = 0;
                findWhat(i-1,j,result,item,weight,value);
            } else if( j>= weight[i-1]
                    && result[i][j] == result[i-1][j-weight[i-1]]+value[i-1]){
                item[i-1] = 1;
                findWhat(i-1,j-weight[i-1],result,item,weight,value);
            }

        }
    }

}
