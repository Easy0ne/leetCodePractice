package algorithm.test.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:    leetCode 46. 全排列
 * @author: wangzk
 * @date: 2020/8/27 21:20
 */
public class Permutation {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutation permutation = new Permutation();
        System.out.println(permutation.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int n = nums.length, n_counter = n;
        int capacity = 1;
        while (n_counter != 1) capacity *= n_counter--;
        List<List<Integer>> result = new ArrayList<>(capacity);
        permuteHelper(nums, 0, result);
        return result;
    }


    /*
    交换+递归
    leetCode 运行时间 8ms， 内存消耗40M
     */
    public void permuteHelper(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length-1) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permuteHelper(nums, start+1, result);
                swap(nums, start, i);
            }
        }
    }


    /*
    字典序全排列
     */
    public List<List<Integer>> permuteByDictSort(int[] nums){

    }


    public static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
