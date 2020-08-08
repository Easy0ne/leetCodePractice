package algorithm.test.dynamicProgramming;

import org.junit.Test;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-07-22 23:03
 */

/*
连续子数组的最大和
 */
public class GreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int n = array.length;
        int maxSum = array[0], localMaxSum = array[0];
        for (int i=1; i<n; i++) {
            localMaxSum = Math.max(array[i], array[i]+localMaxSum);
            maxSum = Math.max(maxSum, localMaxSum);
        }
        return maxSum;
    }

    @Test
    public void test() {
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }
}
