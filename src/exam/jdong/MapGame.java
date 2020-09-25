package exam.jdong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/17 20:01
 */
public class MapGame {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int nSamples = cin.nextInt();
        for (int k = 0; k < nSamples; k++) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            cin.nextLine();
            if (n < 0 || m < 0) {
                System.out.println("NO");
                continue;
            }
            char[][] map = new char[n][m];
            for (int i = 0; i < n; i++) {
                String temp = cin.nextLine();
                map[i] = temp.toCharArray();
            }

            int[] start = new int[2];
            int[] end = new int[2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] == 'S') {
                        start[0] = i;
                        start[1] = j;
                    } else if (map[i][j] == 'E') {
                        end[0] = i;
                        end[1] = j;
                    }
                }
            }

            boolean[][] visited = new boolean[n][m];
            boolean result = go(start, end, map, visited);
            if(result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    public static int[][] directs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static boolean go(int[] pos, int[] end, char[][] map, boolean[][] visited) {
        if (pos[0] == end[0] && pos[1] == end[1]) {
            return true;
        }

        boolean flag = false;
        for (int[] direct: directs) {
            int[] posNew = new int[2];
            posNew[0] = pos[0] + direct[0];
            posNew[1] = pos[1] + direct[1];
            if (check(posNew, map)) {
                if (!visited[posNew[0]][posNew[1]]) {
                    visited[posNew[0]][posNew[1]] = true;
                    if (go(posNew, end, map, visited)) {
                        return true;
                    }
                    visited[posNew[0]][posNew[1]] = false;
                }
            }

        }
        return false;
    }

    public static boolean check(int[] pos, char[][] map) {
        if (0 <= pos[0] && pos[0] < map.length && 0 <= pos[1] && pos[1] < map[0].length) {
            char c= map[pos[0]][pos[1]];
            return (c == '.' || c == 'E');
        }
        return false;
    }
}

