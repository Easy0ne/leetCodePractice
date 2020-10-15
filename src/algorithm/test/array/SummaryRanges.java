package algorithm.test.array;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:    leetcode 228. 汇总区间
 * @author: wangzk
 * @date: 2020/10/8 9:46
 */
public class SummaryRanges {

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        SummaryRanges summaryRanges = new SummaryRanges();
        System.out.println(summaryRanges.summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            int expected = nums[i];
            while (j < n &&nums[j] == expected) {
                j++;
                expected++;
            }
            if (j == i+1) {
                result.add(String.valueOf(nums[i]));
            } else {
                result.add(nums[i] + "->" + (expected-1));
                i = j-1;
            }
        }
        return result;
    }

    public List<String> summaryRanges1(int[] nums) {
        int n;
        List<String> result = new LinkedList<>();
        if (nums == null || (n = nums.length) == 0) return result;
        for (int i = 0; i < n;) {

            int expected = nums[i];
            for (int j = i; j < n; j++) {
                if (nums[j] != expected) {
                    if (j == i+1) {
                        result.add(String.valueOf(nums[i]));
                    } else {
                        result.add(nums[i] + "->" + (expected-1));
                    }
                    i = j;
                    break;
                } else {
                    expected++;
                    if (j == n-1) {
                        if (j == i) {
                            result.add(String.valueOf(nums[i]));
                        } else {
                            result.add(nums[i] + "->" + (expected-1));
                        }
                        i = n;
                    }
                }
            }

        }
        return result;
    }
}
