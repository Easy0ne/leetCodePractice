package exam.vivo;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/12 20:52
 */
public class MazeGame {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            minPath = Integer.MAX_VALUE;
            int n = cin.nextInt();
            int[] start = new int[2];
            int[] end = new int[2];
            start[0] = cin.nextInt();
            start[1] = cin.nextInt();
            end[0] = cin.nextInt();
            end[1] = cin.nextInt();
            String none = cin.nextLine();
            char[][] map = new char[n][n];
            for (int i = 0; i < n; i++) {
                String temp = cin.nextLine();
                char[] chars = temp.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    map[i][j] = chars[j];
                }
            }
            boolean[][] visited = new boolean[n+1][n];

            go(start, 0, end, map, visited);

            System.out.println(minPath);

        }
    }

    public static int minPath = Integer.MAX_VALUE;
    public static int[][] directs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void go(int[] pos, int path, int[] end, char[][] map, boolean[][] visited) {
        if (pos[0] == end[0] && pos[1] == end[1]) {
            if (path < minPath)
                minPath = path;
        }

        for (int[] direct: directs) {
            int[] posNew = new int[2];
            posNew[0] = pos[0] + direct[0];
            posNew[1] = pos[1] + direct[1];
            if (check(posNew, map)) {
                if (!visited[posNew[0]][posNew[1]]) {
                    if (path + 1 < minPath) {
                        visited[posNew[0]][posNew[1]] = true;
                        go(posNew, path+1, end, map, visited);
                        visited[posNew[0]][posNew[1]] = false;
                    }
                }
            }

        }
    }

    public static boolean check(int[] pos, char[][] map) {
        if (0 <= pos[0] && pos[0] < map.length && 0 <= pos[1] && pos[1] < map[0].length) {
            char c= map[pos[0]][pos[1]];
            if (c != '#' && c != '@' && c != '0') {
                return true;
            }
        }
        return false;
    }
}
