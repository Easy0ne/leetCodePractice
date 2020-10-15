package exam.qunar;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/10/14 20:25
 */
public class LengthOfLCS {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            cin.nextLine();
            String line1 = cin.nextLine();
            String line2 = cin.nextLine();
            String list1 = line1.replaceAll(" ", "");
            String list2 = line2.replaceAll(" ", "");
            System.out.println(longestCommonSubsequence(list1, list2));
        }
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;

        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];

        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int j = 1; j < m; j++) {
            if (text2.charAt(j) == text1.charAt(0))
                dp[0][j] = 1;
            else
                dp[0][j] = dp[0][j-1];
        }
        for (int i = 1; i < n; i++) {
            if (text1.charAt(i) == text2.charAt(0))
                dp[i][0] = 1;
            else
                dp[i][0] = dp[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n-1][m-1];
    }
}
