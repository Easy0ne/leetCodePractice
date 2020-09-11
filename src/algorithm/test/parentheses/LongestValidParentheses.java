package algorithm.test.parentheses;

import java.util.Stack;
import java.util.BitSet;

/**
 * @description: leetCode 32. 最长有效括号
 * @author: wangzk
 * @date: 2020/9/7 10:39
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses("()(()"));
        System.out.println(longestValidParentheses.longestValidParentheses2("()(()"));

        System.out.println(longestValidParentheses.longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses.longestValidParentheses2(")()())"));

        System.out.println(longestValidParentheses.longestValidParentheses(")(()())())"));
        System.out.println(longestValidParentheses.longestValidParentheses2(")(()())())"));

        System.out.println(longestValidParentheses.longestValidParentheses("(()"));
        System.out.println(longestValidParentheses.longestValidParentheses2("(()"));
    }


    // wrong
    /*public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] dp = new int[n+1][2];
        int localMax = 0;

        for (int k = 0; k < n; k++) {
            int i = k+1;
            if (chars[k] == '(') {
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = dp[i-1][1];
            } else if (dp[i-1][0] <= dp[i-1][1]) {
                dp[i][0] = 0;
                dp[i][1] = 0;
            } else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1] + 1;
            }
            localMax = Math.max(Math.min(dp[i][0], dp[i][1]), localMax);
        }
        return localMax * 2;
    }*/

    /*
    如果写不出有效括号对的一般规律，这个dp还是很难想到的
    这种解法的关键在于，认为有效括号对都是满足[(O)]*的表达式的。
    dp[i]记录的是以chars[i]结尾的有效括号对的长度，只有当chars[i]==')'时，dp[i]才不为0
    由(O)(O)(O)……的规律可以看出，
    每次遇到")"才可能是有效括号对，且dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-1-1] ifi-dp[i-1]-1-1存在的话。
    1ms 40MB
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[n];
        int localMax = 0;
        for (int i = 1; i < n; i++) {
            if (chars[i] == ')') {
                int mutualIdx = i - dp[i-1] - 1;
                if (mutualIdx >= 0 && chars[mutualIdx] == '(') {
                    dp[i] = dp[i-1] + 2;
                    if (mutualIdx-1 >= 0) {
                        dp[i] += dp[mutualIdx-1];
                    }
                }
                localMax = Math.max(localMax, dp[i]);
            }
        }
        return localMax;
    }


    /*
    括号匹配的一种通用手法——栈，栈中不要记录'(',而是记录该'('对应的下标，可以提供更有效的信息
    这个方法使用辅助数组，将已匹配的括号对标为1，最后只用统计数组中最长连续1的长度//可以只用boolean
    3ms 40MB
     */
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        char[] chars = s.toCharArray();
//        BitSet bitSet = new BitSet(n);
        boolean[] bitSet = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (!stack.empty()) {
                bitSet[stack.pop()] = true;
                bitSet[i] = true;
            }
        }
        int localMax = 0, count = 0;
        // 这里统计要randomAccess，不适合用bitSet
        for (int i = 0; i < n; i++) {
            if (bitSet[i]) {
                count++;
            } else {
                localMax = Math.max(localMax, count);
                count = 0;
            }
        }
        localMax = Math.max(localMax, count);
        return localMax;
    }

}
