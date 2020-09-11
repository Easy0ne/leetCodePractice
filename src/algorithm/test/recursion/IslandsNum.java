package algorithm.test.recursion;

/**
 * @description: leetCode
 * @author: wangzk
 * @date: 2020/9/3 9:22
 */
public class IslandsNum {

    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        char[][] grid2 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'},
        };
        IslandsNum islandsNum = new IslandsNum();
        System.out.println(islandsNum.numIslands(grid2));
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visitLink(grid, i, j, visited);
                    counter++;
                }
            }
        }
        return counter;
    }

    // https://leetcode-cn.com/problems/number-of-islands/comments/42148
    // 直接在grid上将1修改为2，称为“感染函数”，更形象易懂，且空间开销进一步降低

    public void visitLink(char[][] grid, int i, int j, boolean[][] visited) {
        if (i >= grid.length || j >= grid[0].length
                || i< 0 || j <0 || grid[i][j]=='0' || visited[i][j]){
            return;

        }
        visited[i][j] = true;
        visitLink(grid, i+1, j, visited);
        visitLink(grid, i, j+1, visited);
        //回型的还要上去
        visitLink(grid, i-1, j, visited);
        visitLink(grid, i, j-1, visited);
    }
}
