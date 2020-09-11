package algorithm.test.recursion;

/**
 * @description: leetCode
 * @author: wangzk
 * @date: 2020/9/3 11:14
 */
public class ClosedIslandsNum {

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
        ClosedIslandsNum closedIslandsNum = new ClosedIslandsNum();
        char[][] grid = grid1;
        int[][] intGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                intGrid[i][j] = 1- (grid[i][j] - '0');
            }
        }
        System.out.println(closedIslandsNum.closedIsland(intGrid));
    }

    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 0) {
                    if(!infectionToEdgeIsland(grid, i, j, visited)) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }


    public boolean infectionToEdgeIsland(int[][] grid, int i, int j, boolean[][] visited) {
        if (i >= grid.length || j >= grid[0].length
                || i< 0 || j <0 || grid[i][j]== 1 || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        boolean downEdgeIsland = infectionToEdgeIsland(grid, i+1, j, visited);
        boolean RightEdgeIsland = infectionToEdgeIsland(grid, i, j+1, visited);
        //回型的还要上去
        boolean upEdgeIsland = infectionToEdgeIsland(grid, i-1, j, visited);
        boolean leftEdgeIsland = infectionToEdgeIsland(grid, i, j-1, visited);
        //因为递归出口已经确定，此ij是island，只用判断是否是边界处的island。
        boolean isEdgeIsland = (i == 0 || i == grid.length-1 || j==0 || j == grid[0].length-1);
        // 递归到任何一点处，判断自己以及上下左右是不是边界island。
        return (isEdgeIsland || downEdgeIsland || RightEdgeIsland || upEdgeIsland || leftEdgeIsland);
    }
}
