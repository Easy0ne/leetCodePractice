package exam.formular4th;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/30 20:42
 */
public class Least4th {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();
            }
            System.out.println(get4thLeast(nums));
        }
    }

    public static int get4thLeast(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < 4; i++) {
            int idxMin = i;
            for (int j = i+1; j < n; j++) {
                if (nums[j] < nums[idxMin]) {
                    idxMin = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[idxMin];
            nums[idxMin] = temp;
        }
        return nums[3];
    }
}
