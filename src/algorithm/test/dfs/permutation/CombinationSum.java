package algorithm.test.dfs.permutation;

import java.util.*;

/**
 * @description: leetCode 39. 组合总和
 * @author: wangzk
 * @date: 2020/8/29 20:11
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2,3,5};
        List<List<Integer>> result = combinationSum.combinationSumByBacktrack(candidates, 8);
        System.out.println(result);
    }

    /*
    关键是如何设计路径来构造求解树
    这里给出的方法是，从可选数字中选一个添加到当前state中，为了避免重复解，可选数字只能是比到达当前状态的路径所代表数字更大或等于的数字。
    例如,对于{1,2,3,4},初始状态[],在第一次选择了3得到状态[3]后，接下来只能在3/4中选择，不允许选择1/2是因为在选择了1/2的状态中已经有选择3的。
    其实，这种思路更容易想起动态规划。
     */
    public List<List<Integer>> combinationSumByBacktrack(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        Deque<Integer> state_root = new LinkedList<>();
        combinationSumBacktrack(state_root, candidates, 0, target, result);
        return result;
    }

    public void combinationSumBacktrack(Deque<Integer> state, int[] nums, int start, int target, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(state));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (target < nums[i]) {
                    return;
                }
                state.addLast(nums[i]);
                combinationSumBacktrack(state, nums, i, target-nums[i], result);
                state.removeLast();
            }
        }
    }
}
