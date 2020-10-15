package exam.xiecheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/10/13 11:53
 */
public class ScheduleDriver {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int incomeOfA = cin.nextInt();
            int incomeOfB = cin.nextInt();

            //Start coding -- Input Data
        }

        //Start coding
    }

    public static int schedule(int[][] nums) {
        int n = nums.length;
        Integer[] error = new Integer[n];
        boolean[] is = new boolean[n];
        for (int i = 0; i < n; i++) {
            error[i] = Math.abs(nums[i][0] - nums[i][1]);
            is[i] = nums[i][0] > nums[i][1];
        }
        Arrays.sort(error, (x1, x2) -> Math.abs(x1) - Math.abs(x2));
        int count = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (is[i]) {
                count++;
                left += nums[i][0];
            }
            if (count > n / 2) {
                break;
            }
        }
        return count;
    }
}
