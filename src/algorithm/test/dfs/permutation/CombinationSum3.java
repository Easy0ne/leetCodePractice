package algorithm.test.dfs.permutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:    leetCode 216. 组合总和 III
 * @author: wangzk
 * @date: 2020/9/10 19:49
 */
public class CombinationSum3 {

    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        System.out.println(combinationSum3.combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> stateRoot = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        combinationSum3Helper(stateRoot, 1, k, n, result);
        return result;
    }

    public void combinationSum3Helper(LinkedList<Integer> state, int start, int k, int target, List<List<Integer>> result) {
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(state));
        } else if (k == 0 || target > k * 9 || start > 9) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > target) {
                return;
            }
            state.addLast(i);
            combinationSum3Helper(state, i+1, k-1, target-i, result);
            state.removeLast();
        }
    }
}
