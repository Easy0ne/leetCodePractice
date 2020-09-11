package algorithm.test.dynamicProgramming;

/**
 * @description:    leetCode 279. 完全平方数
 * @author: wangzk
 * @date: 2020/9/11 10:58
 */
public class NumSquareSum {

    public static void main(String[] args) {
        NumSquareSum numSquareSum = new NumSquareSum();
        System.out.println(numSquareSum.numSquares(13));
    }

    /*
    用时 1982 ms...
     */
    public int numSquares(int n) {
        int m = (int) Math.sqrt(n);
        int[] w = new int[m+1];
        for (int i = 1; i <= m; i++) {
            w[i] = i * i;
        }

        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int j = 1; j <= n; j++) {
            dp[1][j] = j;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k * w[i] <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-k*w[i]] + k);
                }
            }
        }

        return dp[m][n];
    }


    /*
    这道题用BFS更快些，主要是因为四平方定理，树深不超过4
     */
}
