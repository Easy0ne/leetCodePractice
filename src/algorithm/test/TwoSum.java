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
        int n = nums.length;
        int[] result = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(target - nums[i])) {
                result[0] = hm.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            hm.put(nums[i], i); //先containsKey再put是为了target/2不重复使用。
        }
        return result;
    }

    public void test(){
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        ts.test();
    }
}
