package algorithm.test.permutation;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:    leetCode 47. 全排列 II
 * @author: wangzk
 * @date: 2020/8/28 11:11
 */
public class PermutationUnique {

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> results = new PermutationUnique().permuteUnique(nums);
        for (List<Integer> result: results)
            System.out.println(result);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return null;
//        List<List<Integer>> results = new LinkedList<>();
//        permuteUniqueHelper(nums, 0, results);
        List<List<Integer>> results = permuteByDictSort(nums);
        return results;
    }


    /*
    11ms
    40.7MB
     */
    public void permuteUniqueHelper(int[] nums, int start, List<List<Integer>> results) {
        if (start == nums.length-1) {
            results.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        } else {
            Set<Integer> integerSet = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                if (!integerSet.contains(nums[i])) {
                    swap(nums, start, i);
                    permuteUniqueHelper(nums, start+1, results);
                    swap(nums, start, i);
                    integerSet.add(nums[i]);
                }
            }
        }
    }



    /*
    8ms
    40.8MB
    字典序全排列的寻找下一个序列必然是“大于”当前序列的，
    不会存在重复的问题(在实现上是因为<=及>=都被排除了)。
     */
    public List<List<Integer>> permuteByDictSort(int[] nums){
        if (nums == null || nums.length == 0) return null;
//        int n = nums.length, n_counter = n, capacity = 1;
//        while (n_counter > 1) capacity *= n_counter--;
//        List<List<Integer>> itgLists = new ArrayList<>(capacity);
        int n = nums.length;
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

    public void reverse(int[] nums, int idx1, int idx2) {
        int n = idx2 - idx1 + 1;
        for (int i = 0; i < n/2; i++) {
            swap(nums, idx1+i, idx2-i);
        }
    }

    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }


    /*
    使用自写的PermutationUtils
    208ms
    47.9MB看来还是不行啊
     */
}
