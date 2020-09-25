package exam.fiveight;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/14 20:53
 */
public class YiQing {

   public static void main(String[] args) {
       Scanner cin = new Scanner(System.in);
       while (cin.hasNext()) {
           int m = cin.nextInt();
           int n = cin.nextInt();
           int[][] map = new int[m][n];
           for (int i = 0; i < m; i++) {
               for (int j = 0; j < n; j++) {
                   map[i][j] = cin.nextInt();
               }
           }
           int count = 0;
           for (int i = 0; i < m; i++) {
               for (int j = 0; j < n; j++) {
                   if (map[i][j] == 1) {
                       count ++;
                       infect(i, j, map);
                   }
               }
           }
           System.out.println(count);
       }
   }

   public static void infect(int x, int y, int[][] map) {
       if (x < map.length && x >= 0 && y < map[0].length && y >= 0 && map[x][y] == 1) {
           map[x][y] = 2;
           infect(x+1, y, map);
           infect(x-1, y, map);
           infect(x, y+1, map);
           infect(x, y-1, map);
       }
   }
}
