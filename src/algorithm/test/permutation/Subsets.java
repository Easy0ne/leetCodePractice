package algorithm.test.permutation;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/28 21:21
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsetsByBacktrack(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 不能在使用iterator遍历的时候对List进行修改
//            for (List<Integer> subset: result){
//                List<Integer> newSubset = new LinkedList<>(subset);
//                newSubset.add(nums[i]);
//                result.add(newSubset);
//            }
            int numOfSubsetsCur = result.size();
            int newNum = nums[i];
            for (int j = 0; j < numOfSubsetsCur; j++) {
                List<Integer> newSubset = new LinkedList<>(result.get(j));
                newSubset.add(newNum);
                result.add(newSubset);
            }
        }
        return result;
    }


    public List<List<Integer>> subsetsByBits(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> result = new LinkedList<>();
        int n = nums.length;
        int n_subsets = (int)Math.pow(2, n);
        for (int i = 0; i < n_subsets; i++) {
            int k = i;
            List<Integer> subset = new LinkedList<>();
            for (int j = n-1; j >= 0; j--) {
                if ((k&1) == 1){
                    subset.add(nums[j]);
                }
                k = k>>1;
            }
            result.add(subset);
        }
        return result;
    }

    public List<List<Integer>> subsetsByBacktrack(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> result = new LinkedList<>();
        Deque<Integer> state_root = new LinkedList<>();
        subsetsBacktrack(state_root, nums, 0, result);
        return result;
    }

    public void subsetsBacktrack(Deque<Integer> state, int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(new ArrayList<>(state));
        } else {
            //这里的可选路径就只有两条，不用for循环了

            // 不选nums[start]
            subsetsBacktrack(state, nums, start+1, result);

            //选nums[start]
            state.addLast(nums[start]);
            subsetsBacktrack(state, nums, start+1, result);
            state.removeLast();
        }
    }
}
