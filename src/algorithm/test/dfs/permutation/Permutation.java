package algorithm.test.dfs.permutation;

import java.util.Arrays;
import java.util.LinkedList;
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
//        int capacity = 1;
//        while (n_counter != 1) capacity *= n_counter--;
//        List<List<Integer>> result = new ArrayList<>(capacity);
        List<List<Integer>> result = new LinkedList<>();
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
    leetCode 运行时间 8ms，内存消耗40M
     */
    public List<List<Integer>> permuteByDictSort(int[] nums){
        if (nums == null || nums.length == 0) return null;
        int n = nums.length, n_counter = n, capacity = 1;
        while (n_counter > 1) capacity *= n_counter--;
        List<List<Integer>> itgLists = new LinkedList<>();
        Arrays.sort(nums);
        itgLists.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        while (true) {
            int idx1 = n-2;
            while (idx1 >= 0 && nums[idx1] >= nums[idx1+1]) idx1--;
            if (idx1 == -1) break;
            int idx2 = n-1;
            while (nums[idx2] <= nums[idx1]) idx2--;
            swap(nums, idx1, idx2);
            reverse(nums, idx1+1, n-1);
            itgLists.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        return itgLists;
    }


    public static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    public static void reverse(int[] nums, int idx1, int idx2) {
        int n = idx2 - idx1 + 1;
        for (int i = 0; i < n/2; i++) {
            swap(nums, idx1+i, idx2-i);
        }
    }
}
