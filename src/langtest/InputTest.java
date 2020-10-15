package langtest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/29 22:27
 */
public class InputTest {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = cin.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int idxMax = 0;
            for (int j = 1; j < n-i; j++) {
                if (nums[j] > nums[idxMax]) {
                    idxMax = j;
                }
            }
            swap(nums, idxMax, n-1-i);
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
