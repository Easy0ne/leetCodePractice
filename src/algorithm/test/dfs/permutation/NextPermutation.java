package algorithm.test.dfs.permutation;

import java.util.Arrays;

/**
 * @description:    leetCode 31. 下一个排列
 * @author: wangzk
 * @date: 2020/8/28 10:52
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1,5,5,1};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int n =nums.length;
        int idx1 = n-2;
        while (idx1 >= 0 && nums[idx1] >= nums[idx1+1]) idx1--;
        if (idx1 == -1) {
            reverse(nums, idx1+1, n-1);
            return;
        }
        int idx2 = n-1;
        while (nums[idx2] <= nums[idx1]) idx2--;
        swap(nums, idx1, idx2);
        reverse(nums, idx1+1, n-1);
    }

    public void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public void reverse(int[] arr, int idx1, int idx2) {
        int n = idx2 - idx1 + 1;
        for (int i = 0; i < n/2; i++) {
            swap(arr, idx1+i, idx2-i);
        }
    }
}
