package algorithm.test.dynamicProgramming;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/8 9:48
 */
public class CutRope {

    public static void main(String[] args) {
        CutRope cutRope = new CutRope();
        System.out.println(cutRope.cutRope(8));
    }

    public int cutRope(int target) {
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i-j]);
            }
        }
        return dp[target];
    }
}
