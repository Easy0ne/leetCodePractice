package algorithm.test.bfs;

/**
 * @description: leetCode 1293 网格中的最短路径
 * @author: wangzk
 * @date: 2020/9/7 9:34
 */
public class ShortestPathInGridWithBarriers {

    public static void main(String[] args) {
        ShortestPathInGridWithBarriers shortestPathInGridWithBarriers
                = new ShortestPathInGridWithBarriers();
        int[][] grid = {{0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}};
        int[][] grid2 =
                {{0, 1, 1},
                        {1, 1, 1},
                        {1, 0, 0}};
        int[][] grid3 = {
                {0, 1, 1, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0}
        };
        String s = "a";
        System.out.println(shortestPathInGridWithBarriers.shortestPath(grid3, 1));
    }


    // DFS超时了、
    // 这道题应该使用BFS，可以更早将k用完从而剪枝，此时的剪枝可以剪去很大一部分
    public int shortestPath(int[][] grid, int k) {
        boolean[][] bitMap = new boolean[grid.length][grid[0].length];
        findPath(grid, 0, 0, k, 0, bitMap);
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    private int minLength = Integer.MAX_VALUE;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public void findPath(int[][] grid, int i, int j, int k, int pathLength, boolean[][] bitMap) {
        if (i == grid.length-1 && j == grid[0].length-1) {
            if (pathLength < minLength) {
                minLength = pathLength;
                return;
            }
        }
        if ( pathLength > grid.length*grid[0].length || pathLength > minLength) {
            return;
        }
        if (k < 0) {
            return;
        }
        for (int[] direct: directions) {
            int nextI = i+direct[0], nextJ = j+direct[1];
            if (0 <= nextI && nextI < grid.length && 0 <= nextJ && nextJ < grid[0].length && !bitMap[nextI][nextJ]) {
                bitMap[nextI][nextJ] = true;
                if (grid[nextI][nextJ] == 0) {
                    findPath(grid, nextI, nextJ, k, pathLength+1, bitMap);
                } else {
                    findPath(grid, nextI, nextJ, k-1, pathLength+1, bitMap);
                }
                bitMap[nextI][nextJ] = false;
            }
        }

    }



    /*
    BFS
    BFS的visited要注意包含k
    即，boolean[][][] visited = new boolean[k][m][n]
     */
}
