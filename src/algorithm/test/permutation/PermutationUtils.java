package algorithm.test.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/27 16:37
 */
public class PermutationUtils {

    public static void main(String[] args) {
        int n = 4;
        int[][] result = permutationIdxes(n);
        if (result == null) {
            System.out.println("null");
        } else {
            for(int[] sub_resut: result)
                System.out.println(Arrays.toString(sub_resut));
        }

    }

    public static int[][] permutationIdxes(int n) {
        if (n == 0) return null;
        if (n == 1) return new int[][]{{1}};

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        int product = 1, n_count = n;
        while (n_count != 1) product *= n_count--;
        int[][] result = new int[product][n];

        result[0] = Arrays.copyOf(nums, n);
        int counter = 1;
        while (counter < product) {
            int idx1 = n-2;
            while (idx1 >= 0 && nums[idx1] > nums[idx1+1]) idx1--;
            if (idx1 == -1) break;

            int idx2 = n-1;
            while (nums[idx2] < nums[idx1]) idx2--;
            swap(nums, idx1, idx2);
            reverse(nums, idx1+1, n-1);
            result[counter++] = Arrays.copyOf(nums, n);
        }

        return result;
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void reverse(int[] arr, int idx1, int idx2) {
        if (idx2 < idx1) {
            System.out.println("Reverse Wrong");
            return;
        }
        int n = idx2 - idx1 + 1;
        for (int i = 0; i < n/2; i++) {
            swap(arr, idx1+i, idx2-i);
        }
    }
}
