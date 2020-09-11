package algorithm.test.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/2 15:24
 */
public class Maze {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            int[][] maze = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze[i][j] = cin.nextInt();
                }
            }
            LinkedList<List<Integer>> state_root = new LinkedList<>();
            List<Integer> startPos = new ArrayList<>(2);
            startPos.add(0); startPos.add(0);
            state_root.addLast(startPos);
            Maze maze1 = new Maze();
            maze1.mazePathHelper(state_root, maze, n, m);
            for(List<Integer> pos : maze1.bestSolution) {
                System.out.println(String.format("(%d,%d)", pos.get(0), pos.get(1)));
            }
        }
    }

    private int minPathLength = Integer.MAX_VALUE;
    private List<List<Integer>> bestSolution = null;

    public void mazePathHelper(LinkedList<List<Integer>> state, int[][] maze, int n, int m) {
        if (state.getLast().get(0) == n-1 && state.getLast().get(1) == m-1) {
            int pathLength;
            if((pathLength = state.size()) < minPathLength) {
                bestSolution = new LinkedList<>(state);
                minPathLength = pathLength;
            }
        } else {
            int x = state.getLast().get(0);
            int y = state.getLast().get(1);
            int n_path = state.size();
            if (n_path + 1 > minPathLength){
                return;
            }

            List<Integer> posUp = new ArrayList<>(2);
            posUp.add(0, x-1); posUp.add(1, y);
            if (!state.contains(posUp) && x-1 > 0 && maze[x-1][y] == 0) {
                state.addLast(posUp);
                mazePathHelper(state, maze, n, m);
                state.removeLast();
            }
            posUp = null;

            // 这里是个坑
            // 如果不重新new，会在上面的pos对象的基础上修改，而在叶子节点使用new创建解时，只能深入拷贝一次(List new不能很深地深拷贝).
            List<Integer> posDown = new ArrayList<>(2);
            posDown.add(0, x+1); posDown.add(1, y);
            if (!state.contains(posDown) && x+1 < n && maze[x+1][y] == 0) {
                state.addLast(posDown);
                mazePathHelper(state, maze, n, m);
                state.removeLast();
            }
            posDown = null;

            List<Integer> posLeft = new ArrayList<>(2);
            posLeft.add(0, x); posLeft.add(1, y-1);
            if (!state.contains(posLeft) && y-1 >0 && maze[x][y-1] == 0) {
                state.addLast(posLeft);
                mazePathHelper(state, maze, n, m);
                state.removeLast();
            }
            posLeft = null;

            List<Integer> posRight = new ArrayList<>(2);
            posRight.add(0, x); posRight.add(1, y+1);
            if (!state.contains(posRight) && y+1 < m && maze[x][y+1] == 0) {
                state.addLast(posRight);
                mazePathHelper(state, maze, n, m);
                state.removeLast();
            }
            posRight = null;

        }
    }
}
