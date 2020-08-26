package algorithm.test.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/26 10:49
 */
public class TrianglePathMaxSum {

    public static void main(String[] args) {
        maxSum();
    }

    /*
    7
    3 8
    8 1 0
    2 7 4 4
    4 5 2 6 5
     */

    public static void maxSum() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    arr[i][j] = cin.nextInt();
                }
            }

            for(int[] sub_arr : arr)
                System.out.println(Arrays.toString(sub_arr));

            int[][] dp = new int[n][n];
            dp[0][0] = arr[0][0];

            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i-1][0] + arr[i][0];
                dp[i][i] = dp[i-1][i-1] + arr[i][i];
                for (int j = 1; j < i; j++) {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
                }
            }

            System.out.println(Arrays.stream(dp[n-1]).max());
        }
    }
}
