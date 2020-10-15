package exam.formular4th;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/30 21:15
 */
public class CountDiffNums {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int q= cin.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();
            }
            int[][] qs = new int[q][2];
            for (int i = 0; i < q; i++) {
                qs[i][0] = cin.nextInt();
                qs[i][1] = cin.nextInt();
            }
            for (int i = 0; i < q; i++) {
                System.out.println(countDiffNums(nums, qs[i][0], qs[i][1]));
            }
        }
    }

    public static int countDiffNums(int[] nums, int start, int end) {
        boolean[] existed = new boolean[100];
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (!existed[nums[i]]){
                existed[nums[i]] = true;
                count++;
            }
        }
        return count;
    }
}
