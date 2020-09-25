package exam.netease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/13 10:07
 */
public class ChooseSeat {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
//        while (cin.hasNext()) {
//            int num = cin.nextInt();
//            nums.add(num);
//        }
        String str = cin.nextLine();
        String[] numsStr = str.split(" ");
        for (int i = 0; i < numsStr.length; i++) {
            nums.add(Integer.valueOf(numsStr[i]));
        }
        int n = nums.size();
        int[] dp = new int[n];
        int first = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == 0) {
                first = i;
                break;
            }
        }
        dp[first] = 1;
        for (int i = first+1; i < n; i++) {
            if (nums.get(i) == 0) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 0;
            }
        }

        int[] dp2 = new int[n];
        int last = n-1;
        for (int i = n-1; i >= 0; i--) {
            if (nums.get(i) == 0) {
                last = i;
                break;
            }
        }
        dp2[last] = 1;
        for (int i = last-1; i >= 0; i--) {
            if (nums.get(i) == 0) {
                dp2[i] = dp2[i+1] +1;
            } else {
                dp[i] = 0;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(Math.min(dp[i], dp2[i]), max);
        }
        System.out.println(max);
    }
}
