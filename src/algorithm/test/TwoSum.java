package algorithm.test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wangzk
 * @date 2020-02-29 23:41
 */
public class TwoSum {
    public int[] twoSum_simple(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        for (int i=0;i<n;i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[i]+nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }


    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) return result;

        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])){
                int idx0 = map.get(nums[i]);
                int idx1 = i;
                result[0] = idx0;
                result[1] = idx1;
                return result;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum.twoSum(nums, 9)));
    }
}
