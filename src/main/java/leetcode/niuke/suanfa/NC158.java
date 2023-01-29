package leetcode.niuke.suanfa;

/**
 * @Author: zengqx
 * @Date: 2023/1/29 13:24
 */
public class NC158 {

    public static void main(String[] args){
        int[][] graph = new int[][]{{1,2,2},{1,4,5},{2,3,3},{3,5,4},{4,5,5}};
        int result = findShortestPath(5,5,graph);
        System.out.println(result);
    }
    private static int INF = 0x3f3f3f3f;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int 顶点数
     * @param m int 边数
     * @param graph int二维数组 一维3个数据，表示顶点到另外一个顶点的边长度是多少​
     * @return int
     */
    public static int findShortestPath (int n, int m, int[][] graph) {
        // write code here
        int[][] weightArr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    weightArr[i][j] = 0;
                } else {
                    weightArr[i][j] = INF;
                }
            }
        }
        for (int[] pathArr : graph) {
            int startNode = pathArr[0];
            int endNode = pathArr[1];
            int weight = pathArr[2];
            weightArr[startNode][endNode] = Math.min(weightArr[startNode][endNode], weight);
        }
        boolean[] visitArr = new boolean[n + 1];
        int[] distArr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distArr[i] = INF;
        }
        distArr[1] = 0;
        for (int p = 1; p <= n; p++) {
            int lastNode = -1;
            for (int i = 1; i <= n; i++) {
                if (!visitArr[i] && (lastNode == -1 || distArr[i] < distArr[lastNode])) {
                    lastNode = i;
                }
            }
            visitArr[lastNode] = true;
            for(int i = 1;i <= n;i++){
                distArr[i] = Math.min(distArr[i],distArr[lastNode]+weightArr[lastNode][i]);
            }
        }
        return distArr[n] >= INF / 2 ? -1:distArr[n];
    }

}
