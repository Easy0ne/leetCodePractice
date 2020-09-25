package algorithm.test.array.partition;

import java.util.Arrays;

/**
 * @description:    leetCode 416. 分割等和子集
 * @author: wangzk
 * @date: 2020/9/14 9:36
 */
public class TwoSubsetsSums {

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 3, 5};
        TwoSubsetsSums twoSubsetsSums = new TwoSubsetsSums();
        System.out.println(twoSubsetsSums.canPartition(nums1));
        System.out.println(twoSubsetsSums.canPartition(nums2));
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum(), cap = sum/2;
        if (sum % 2 == 1) return false;
        int n = nums.length;
        int[][] dp = new int[n][cap+1];
        for (int j = 1; j <= cap; j++) {
            dp[0][j] = nums[0] == j ? 1 : Integer.MIN_VALUE;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= cap; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j - nums[i]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n-1][cap] == 1;
    }
}
