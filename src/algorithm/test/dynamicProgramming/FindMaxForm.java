package algorithm.test.dynamicProgramming;

/**
 * @description:    leetCode 474 一和零
 * @author: wangzk
 * @date: 2020/8/26 9:56
 */
public class FindMaxForm {

    public static void main(String[] args) {
        FindMaxForm findMaxForm = new FindMaxForm();
        String[] strs1 = {"10", "0001", "111001", "1", "0"};
        String[] strs2 = {"10", "0", "1"};
        System.out.println(findMaxForm.findMaxForm(strs1, 5, 3));
        System.out.println(findMaxForm.findMaxForm(strs2, 1, 1));
    }


    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) return 0;
        if (m == 0 && n == 0) return 0;

        int n_problems = strs.length;
        int[][] w = new int[n_problems][2];
        for (int i = 0; i < n_problems; i++) {
            w[i][0] = (int)strs[i].chars().filter(x -> x=='0').count();
            w[i][1] = strs[i].length() - w[i][0];
        }
        int[][][] dp = new int[n_problems][m+1][n+1];
        for (int j1 = 0; j1 <= m; j1++) {
            for (int j2 = 0; j2 <= n; j2++) {
                if (j1 >= w[0][0] && j2 >= w[0][1])
                    dp[0][j1][j2] = 1;
            }
        }

        for (int i = 1; i < n_problems; i++) {
            for (int j1 = 0; j1 <= m; j1++) {
                for (int j2 = 0; j2 <= n; j2++) {
                    if (j1 < w[i][0] || j2 < w[i][1])
                        dp[i][j1][j2] = dp[i-1][j1][j2];
                    else
                        dp[i][j1][j2] = Math.max(1 + dp[i-1][j1-w[i][0]][j2-w[i][1]], dp[i-1][j1][j2]);
                }
            }
        }

        return dp[n_problems-1][m][n];
    }
}
