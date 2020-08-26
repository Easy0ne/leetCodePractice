package algorithm.test.dynamicProgramming;

import java.util.Arrays;

/**
 * @description:    leetCode 300 最长上升子序列, 可以对比连续子序列问题
 * @author: wangzk
 * @date: 2020/8/26 14:23
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return 1;

        int[] dp = new int[n];  // dp值为以nums[i]结束的最长上升子序列的长度
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) { // 决策动作是从前面j<i的dp[j]中选择最大的将nums[i]拼接上
                if (nums[j] > nums[i])
                    dp[i] = Math.max(dp[i], 1+dp[j]);
            }
        }

//        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }
}
