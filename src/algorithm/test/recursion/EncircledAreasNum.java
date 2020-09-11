package algorithm.test.recursion;

import java.util.Arrays;

/**
 * @description: leetCode
 * @author: wangzk
 * @date: 2020/9/3 10:41
 */
public class EncircledAreasNum {

    public static void main(String[] args) {
        EncircledAreasNum encircledAreasNum = new EncircledAreasNum();
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        encircledAreasNum.solve(board);
        for(char[] line : board) {
            System.out.println(Arrays.toString(line));
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        if (board.length == 1 || board[0].length == 1) return;
        int n = board.length, m = board[0].length;
        boolean[][] infected = new boolean[n][m];
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !infected[0][j]) {
                infection(board, 0, j, infected);
            }
        }
        for (int i = 1; i < n; i++) {
            if (board[i][m-1] == 'O' && !infected[i][m-1]) {
                infection(board, i, m-1, infected);
            }
        }
        for (int j = m-2; j >=0 ; j--) {
            if (board[n-1][j] == 'O' && !infected[n-1][j]) {
                infection(board, n-1, j, infected);
            }
        }
        for (int i = n-2; i > 0; i--) {
            if (board[i][0] == 'O' && !infected[i][0]) {
                infection(board, i, 0, infected);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!infected[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /*
    此处还可节省空间，先将要感染的(边界的O)标记为其他符号(比如'-')，之后遍历的时候把O换为X后、再把-换位O。
     */
    public void infection(char[][] board, int i, int j, boolean[][] infected) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] == 'X' || infected[i][j]) {
            return;
        }
        infected[i][j] = true;
        infection(board, i+1, j, infected);
        infection(board, i, j+1, infected);
        infection(board, i-1, j, infected);
        infection(board, i, j-1, infected);
    }
}
