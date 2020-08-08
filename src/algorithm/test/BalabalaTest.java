package algorithm.test;

/**
 * @author wangzk
 * @date 2018-10-07 21:03
 */
public class BalabalaTest {
    int[][] maze = {
            {0,1,0,0,0},
            {0,1,0,1,0},
            {0,0,0,0,0},
            {0,1,1,1,0},
            {0,0,0,1,0}
    };

    public void printArray(int[][] maze){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(j == 5-1) {
                    System.out.println(maze[i][j]);
                }else{
                    System.out.print(maze[i][j]+", ");
                }
            }
        }
    }

    public static void main(String[] args) {
        BalabalaTest balabalaTest = new BalabalaTest();
        int[][] maze_copy = balabalaTest.maze.clone();
        maze_copy[0][0] = 3;
        maze_copy = balabalaTest.maze.clone();
        maze_copy[1][0] = 3;
        balabalaTest.printArray(maze_copy);
        System.out.println();
        balabalaTest.printArray(balabalaTest.maze);
    }
}
