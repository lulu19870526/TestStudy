package leetcode;

/**
 * 这道题让我们验证一个方阵是否为数独矩阵，判断标准是看各行各列是否有重复数字，
 * 以及每个小的3x3的小方阵里面是否有重复数字，如果都无重复，则当前矩阵是数独矩阵，
 * 但不代表待数独矩阵有解，只是单纯的判断当前未填完的矩阵是否是数独矩阵。
 * 那么根据数独矩阵的定义，我们在遍历每个数字的时候，
 * 就看看包含当前位置的行和列以及3x3小方阵中是否已经出现该数字，
 * 那么我们需要三个标志矩阵，分别记录各行，各列，各小方阵是否出现某个数字，
 * 其中行和列标志下标很好对应，就是小方阵的下标需要稍稍转换一下
 */
public class Shudu36 {

    public static void main(String[] args){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        boolean flag = isValidSudoku(board);
        System.out.println("flag="+flag);
    }

    public static boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return true;


        for(int i=0;i<board.length;i++){
            boolean[] rowNumbers = new boolean[10];
            boolean[] colNumbers = new boolean[10];
            for(int j =0;j< board[0].length;j++)
            {
                if(board[i][j] != '.'){
                    if(rowNumbers[board[i][j] -'0'])
                        return false;
                    rowNumbers[board[i][j] -'0'] = true;
                }

                if(board[j][i] != '.'){
                    if(colNumbers[board[j][i] -'0'])
                        return false;
                    colNumbers[board[j][i] -'0'] = true;
                }
            }
        }

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                boolean[] numbers = new boolean[10];
                for(int row =3*i;row< 3*i+3;row++){

                    for(int col=3*j;col < 3*j+3;col++)
                    {
                        if(board[row][col] !='.'){
                            if(numbers[board[row][col] -'0'])
                                return false;
                            numbers[board[row][col] -'0'] = true;
                        }
                    }
                }

            }

        return true;
    }
}
