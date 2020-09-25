package exam.kingsoft;

import algorithm.test.dfs.permutation.CombinationSum;

import java.util.*;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/22 21:32
 */
public class CombSum {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.nextLine();
            String[] numStrs = str.split(" ");
            if (numStrs.length == 0) {
                continue;
            }
            int[] nums = new int[numStrs.length];
            for (int i = 0; i < numStrs.length; i++) {
                nums[i] = Integer.valueOf(numStrs[i]);
            }
            Arrays.sort(nums);
            int[] count = new int[10];
            for (int i = 0; i < nums.length; i++) {
                count[nums[i]]++;
            }
            int n = 0;
            for (int i = 9; i > 0; i--) {
                if(search(count, 9)){
                    n++;
                }
            }
            System.out.println(n);
        }
    }

    public static boolean search(int[] nums, int target) {
        for (int i = target; i > 0; i--) {
            if(nums[target] > 0) {
                nums[target] --;
                return true;
            } else {
                for (int j = i-1; j > 0; j--) {
                    if (nums[j] > 0 && search(nums, target-j)) {
                        nums[j]--;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
