package exam.netease;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/13 11:05
 */
public class Encode {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.nextLine();
            if (str == null || str.length() == 0) {
                System.out.println(0);
                continue;
            }
            int n = str.length();
            if (n == 1) {
                System.out.println(1);
                continue;
            }
            if (n == 2) {
                if (str.charAt(0) == '0')
                    System.out.println(1);
                else
                    System.out.println(2);
            }
            int[] dp = new int[n+1];
            int first = 0;
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == '1') {
                    first = i;
                    break;
                }
            }

            dp[n] = 0;
            dp[n-1] = 1;
            dp[n-2] = str.charAt(n-2) == '0' ? 1 : 2;
            String subS = str.substring(n-3);
            if (subS.equals("000") || subS.equals("001")) {
                dp[n-3] = 1;
            } else if (subS.equals("010") || subS.equals("011")) {
                dp[n-3] = 2;
            } else if (subS.equals("100") || subS.equals("101")) {
                dp[n-3] = 3;
            } else {
                dp[n-3] = 4;
            }
            for (int i = n-4; i >= first; i--) {
                if (str.charAt(i) == '0') {
                    dp[i] = dp[i+1];
                } else {
                    String subS2 = str.substring(i, i+3);
                    if (subS.equals("000") || subS.equals("001")) {
                        dp[i] = dp[i+3];
                    } else if (subS.equals("010") || subS.equals("011")) {
                        dp[i] = 2 * dp[i+3];
                    } else if (subS.equals("100") || subS.equals("101")) {
                        dp[i] = 3 * dp[i+3];
                    } else {
                        dp[i] = 4 * dp[i+3];
                    }
                }
            }

            System.out.println(dp[first]);
        }
    }
}
