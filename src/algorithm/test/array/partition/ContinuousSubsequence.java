package algorithm.test.array.partition;

import java.util.HashMap;

/**
 * @description:    leetCode  659. 分割数组为连续子序列
 * @author: wangzk
 * @date: 2020/9/21 8:54
 */
public class ContinuousSubsequence {

    public static void main(String[] args) {
        ContinuousSubsequence continuousSubsequence = new ContinuousSubsequence();
        int[] nums = {1,2,3,3,4,5};
        int[] nums1 = {1,2,3};
        int[] nums2 = {1,2,3,3,4,4,5,5};
        int[] nums3 = {1,2,3,4,4,5};
        System.out.println(continuousSubsequence.isPossible(nums));
        System.out.println(continuousSubsequence.isPossible(nums1));
        System.out.println(continuousSubsequence.isPossible(nums2));
        System.out.println(continuousSubsequence.isPossible(nums3));
    }


    /*
    贪心策略，遍历nums，对于每个num，只需要找到以num-1结尾的所有子序列，将自己附随到其后，并更新为以自己为结尾的子序列；若有多个想找的子序列，优先附随到最短的那个上。
    但其实，这道题并不需要所有的子序列，而是判断能否分割成这样的多个子序列；
    因此，只需要统计以num-1结尾的子序列的个数，认为优先附随在最短的子序列上。
    对于每个num，要么向前找以num-1结尾的子序列，要么向后找num+1和num+2，如果都不存在则划分失败
     */
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> endCountMap = new HashMap<>();
        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }

        for(int num: nums) {
            if (countMap.getOrDefault(num, 0) <= 0) {
                continue;
            }
            countMap.put(num, countMap.getOrDefault(num, 0)-1);
            if(endCountMap.getOrDefault(num-1, 0) > 0) {
                endCountMap.put(num-1, endCountMap.get(num-1)-1);
                endCountMap.put(num, endCountMap.getOrDefault(num, 0)+1);
            } else if (countMap.getOrDefault(num+1, 0) > 0 && countMap.getOrDefault(num+2, 0) > 0) {
                countMap.put(num+1, countMap.getOrDefault(num+1, 0)-1);
                countMap.put(num+2, countMap.getOrDefault(num+2, 0)-1);
                endCountMap.put(num+2, endCountMap.getOrDefault(num+2, 0)+1);
            } else {
                return false;
            }
        }
        return true;
    }
}
