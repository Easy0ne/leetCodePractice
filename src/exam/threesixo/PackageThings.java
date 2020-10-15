package exam.threesixo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/26 20:34
 */
public class PackageThings {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            int k = cin.nextInt();
            int v = cin.nextInt();
            System.out.println(pack1(a, b, k, v));
        }
    }

    public static int pack(int a, int b, int k, int v) {
        int n = 2000, m = 0;
        int[][] dp = new int[n+1][b+1];
        for (int j = 0; j <= b; j++) {
            if (j+1 <= k) {
                dp[1][j] = (j+1) * v;
            } else {
                dp[1][j] = k*v;
            }
        }
        if (dp[1][b] >= a) {
            return 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= b; j++) {
                if (j - (i-1)*(k-1) <= 0) {
                    dp[i][j] = dp[i-1][j] + v;
                } else if (j - (i-1)*(k-1) + 1 <= k) {
                    dp[i][j] = dp[i-1][j] + (j - (i-1)*(k-1) + 1) * v;
                } else {
                    dp[i][j] = dp[i-1][j] + k * v;
                }

                if (dp[i][j] >= a) {
                    return i;
                }
            }
        }
        return n;
    }

    public static int pack1(int a, int b, int k, int v) {
        int n = 2000;
        List<List<Integer>> dp = new ArrayList<>();
        List<Integer> dp0 = new ArrayList<>();
        List<Integer> dp1 = new ArrayList<>();
        dp.add(dp0);
        dp.add(dp1);
        for (int j = 0; j <= b; j++) {
            if (j+1 <= k) {
                dp.get(1).add(j, (j+1) * v);
            } else {
                dp.get(1).add(j, k*v);
            }
        }
        if (dp.get(1).get(b) >= a) {
            return 1;
        }

        for (int i = 2; i <= n; i++) {
            List<Integer> newedDp = new ArrayList<>();
            dp.add(newedDp);
            for (int j = 0; j <= b; j++) {
                if (j - (i-1)*(k-1) <= 0) {
                    dp.get(i).add(j, dp.get(i-1).get(j)+v);
                } else if (j - (i-1)*(k-1) + 1 <= k) {
                    dp.get(i).add(j, dp.get(i-1).get(j) + (j - (i-1)*(k-1) + 1) * v);
                } else {
                    dp.get(i).add(j, dp.get(i-1).get(j)+  k*v);
                }

                if (dp.get(i).get(j) >= a) {
                    return i;
                }
            }
        }
        return n;
    }
}
