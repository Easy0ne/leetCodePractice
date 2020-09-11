package algorithm.test.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:    leetCode 523. 连续的子数组和
 * @author: wangzk
 * @date: 2020/9/11 14:31
 */
public class SubarraySum {

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        int[] nums = {23,2,6,4,7};
        int[] nums1 = {0,0,0,0};
        System.out.println(subarraySum.checkSubarraySum(nums, 13));
        System.out.println(subarraySum.checkSubarraySum(nums, 6));
        System.out.println(subarraySum.checkSubarraySum(nums1, 0));
    }


    public boolean checkSubarraySum1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        k = Math.abs(k);
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        if (k > Arrays.stream(nums).sum()) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + nums[j];
                if (checkSumTimes(dp[i][j], k)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSumTimes(int sum, int k) {
        //这个坑太多了
        if (k == 0) {
            return (sum == 0);
        }
        if (sum == 0) {
            return false;
        } else {
            int times = sum/k;
            return (times * k == sum);
        }
    }

    /*
    i < j
    nums[:i].sum%k == nums[:j].sum%k ? true : false
    nums[i+1:j].sum%k == 0 is true
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        if (k == 0) return false;
        k = Math.abs(k);
        int sum = 0, n = nums.length;
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == 0) continue;
            int yuShu = sum % k;
            if (idxMap.containsKey(yuShu) || yuShu == 0) {
                return true;
            }
            idxMap.put(yuShu, i);
        }
        return false;
    }
}
