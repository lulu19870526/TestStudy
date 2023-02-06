package leetcode.niuke.suanfa;

/**
 * @Author: zengqx
 * @Date: 2023/2/6 21:54
 */
public class NC242 {

    public static void main(String[] args){
        exist(new String[]{"a"},"ab");
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param board string字符串一维数组
     * @param word string字符串
     * @return bool布尔型
     */
    public static boolean exist (String[] board, String word) {
        // write code here
        int m = board.length;
        int n = board[0].length();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i].charAt(j) == word.charAt(0)) {
                    boolean tempResult = dfs(board,i,j,word,0,visited);
                    if(tempResult){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean dfs(String[] board, int i, int j, String word, int index,
                        boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length()
                || visited[i][j] || board[i].charAt(j) != word.charAt(index)) {
            return false;
        }
        if(index == word.length() - 1){
            return true;
        }
        visited[i][j] = true;
        boolean result = dfs(board,i-1,j,word,index + 1,visited)
                || dfs(board,i+1,j,word,index+1,visited) || dfs(board,i,j-1,word,index+1,visited) || dfs(board,i,j+1,word,index+1,visited);
        visited[i][j] = false;
        return result;
    }
}
