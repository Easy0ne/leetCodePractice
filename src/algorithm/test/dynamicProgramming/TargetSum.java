package algorithm.test.dynamicProgramming;

import java.util.Arrays;

/**
 * @description: leetCode 494
 * @author: wangzk
 * @date: 2020/8/25 16:26
 */
public class TargetSum {

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        int[] nums = {0,0,1};
        System.out.println(targetSum.findTargetSumWays(nums, 1));
    }

    //恰好装满的-1/1背包问题
    // 需要求的是方法数
    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        if (S > sum || S < -sum) {
            return 0;
        }
        int capacity = 2 * sum + 1;
        int n_types = nums.length;
        int[][] f = new int[n_types][capacity+1];
        for (int i = 0; i < n_types; i++) {
            for (int j = 0; j <= capacity; j++) {
                f[i][j] = 0;    //不能恰好装满的方法数f为0
            }
        }

        for (int j=0; j<= capacity; j++) {
            if (nums[0] == j-sum) {
                f[0][j] += 1; //这里用+=而不是=，是因为0的时候，+或-都满足
            }
            if (-nums[0] == j-sum) {
                f[0][j] += 1;
            }
        }
        for (int i = 1; i < n_types; i++) {
            for (int j = 0; j <= capacity; j++) {
                int add = 0, sub = 0;
                if(j - nums[i] < 0)
                    add = 0;
                else
                    add = f[i-1][j-nums[i]];
                if(j + nums[i] > capacity)
                    sub = 0;
                else
                    sub = f[i-1][j+nums[i]];
                f[i][j] = add + sub;
            }
        }
//        for (int[] sub_f : f)
//            System.out.println(Arrays.toString(sub_f));
        return f[n_types-1][sum+S];
    }
}
