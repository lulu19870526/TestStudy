package leetcode.niuke.suanfa;

import java.util.ArrayList;

/**
 * @Author: zengqx
 * @Date: 2023/2/8 21:08
 */
public class NC218 {

    public static void main(String[] args){
        int[][] arr = new int[][]{{1,0},{2,1}};
        int[] resultArr = findOrder(arr,3);
    }

    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean valid = true;
    private static int[] visited;
    private static int[] resultArr;
    private static int index;

    public static int[] findOrder (int[][] prerequisites, int n) {
        graph = new ArrayList<ArrayList<Integer>> ();
        visited = new int[n];
        resultArr = new int[n];
        index = n - 1;
        for(int i = 0;i < n;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int[] arr : prerequisites){
            graph.get(arr[1]).add(arr[0]);
        }
        for(int i = 0;i < n && valid;i++){
            if(visited[i] == 0){
                dfs(i);
            }
        }
        return valid == true ? resultArr :new int[0];
    }

    private static void dfs(int i){
        visited[i] = 1;
        for(int j : graph.get(i)){
            if(visited[j] == 0){
                dfs(j);
            }else if(visited[j] == 1){
                valid = false;
                return;
            }
        }
        visited[i] = 2;
        resultArr[index--] = i;
    }

}
