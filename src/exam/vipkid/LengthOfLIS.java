package exam.vipkid;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/30 20:00
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.nextLine();
            String[] numStrs = str.split(" ");
            int n = numStrs.length;
            if (n == 0) {
                System.out.println(0);
                return;
            }
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.valueOf(numStrs[i]);
            }
//            System.out.println(Arrays.toString(nums));
            System.out.println(lengthOfLIS(nums));
        }
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return 1;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], 1+dp[j]);
            }
        }
//        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }
}
