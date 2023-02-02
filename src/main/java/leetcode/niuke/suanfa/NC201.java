package leetcode.niuke.suanfa;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: zengqx
 * @Date: 2023/2/2 18:02
 */
public class NC201 {

    public static void main(String[] args){
       diagonalOrder(new int[][]{{1},{5}});
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param mat int整型二维数组
     * @returnS int整型一维数组
     */
    public static int[] diagonalOrder (int[][] mat) {
        // wriTte code here
        int n = mat.length;
        int m = mat[0].length;
        int[] arr = new int[n*m];
        int i = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int flag = 1;
        int k = 0;
        for(;i < n;i++){
            flag = -flag;
            for(int j = 0;j< m&&j <=i;j++){
                list.add(mat[i-j][j]);
            }
            if(flag == 1){
                Collections.reverse(list);
            }
            for(int u = 0;u < list.size();u++){
                arr[k++] = list.get(u);
            }
            list.clear();
        }
        int tmp = 0;
        for(;i < n+m-1;i++){
            flag = -flag;
            for(int j =++tmp;j< tmp+n && j < m;j++){
                list.add(mat[i-j][j]);
            }
            if(flag == 1){
                Collections.reverse(list);
            }
            for(int u = 0;u < list.size();u++){
                arr[k++] = list.get(u);
            }
            list.clear();
        }
        return arr;
    }
}
