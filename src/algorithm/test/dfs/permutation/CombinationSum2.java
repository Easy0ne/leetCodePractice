package algorithm.test.dfs.permutation;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:    leetCode 40. 组合总和 II
 *                  给定的数组中包含重复元素，要求最终集合不能重复
 * @author: wangzk
 * @date: 2020/9/10 21:39
 */
public class CombinationSum2 {

    /*
    两种求不重复子集的求解树思路，参考Subsets
    // emmm 第二种思路是错误的。
     */
    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] candidates = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2.combinationSum2(candidates, 8));
    }

    /*
    思路一：[0,1,2,3,4]中，第一次选中2后，state为[2],下一次可选path只剩[3,4]了。
    这种方法叶子节点不在同一层遍历经过的总路径长度会小一些(相比于下一种思路)
    4 ms        55.54%
    40.3 MB     11.84%
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        LinkedList<Integer> stateRoot = new LinkedList<>();
        combination2Dfs(stateRoot, 0, target, candidates, result);

        return result;

    }

    public void combination2Dfs(LinkedList<Integer> state, int start, int target, int[] nums, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(state));
        }
//        Set<Integer> integerSet = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if(nums[i] > target) {
                return;
            }
//            if (integerSet.contains(nums[i])) { // 这里主要是因为给定数组中可能包含重复的元素
//                continue;
//            }
//            integerSet.add(nums[i]);
            if (i>start && nums[i] == nums[i-1]) continue;  //这种方法来去重,需要排序来配合
            state.addLast(nums[i]);
            combination2Dfs(state, i+1, target-nums[i], nums, result);
            state.removeLast();
        }
    }


    /*
    思路二：{0,1,2,3,4}挨个进行决定，有两种选择：加它or不加它，求解树深度是n，所有叶子节点在一层。
    时间复杂度为O(2^n)，不进行剪枝的话，很有可能会超时。
    in fact，这种方法对这个问题并不可行，因为在求解过程中避免不了重复，构建一下求解树就知道了。
     */
    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (candidates == null || candidates.length == 0) return result;
        LinkedList<Integer> stateRoot = new LinkedList<>();
        combination2Dfs2(stateRoot, 0, target, candidates, result);
        result = result.stream().distinct().collect(Collectors.toList());
        return result;

    }


    public void combination2Dfs2(LinkedList<Integer> state, int cur, int target, int[] nums, List<List<Integer>> result) {
        if (cur == nums.length) {
            if (target == 0) {
                result.add(new ArrayList<>(state));
            }
            return;
        }

        // add
        if (nums[cur] <= target) {   // 这里要注意剪枝不是return，因为return会将解剪掉，所以这种方法是用不到排序的
            state.addLast(nums[cur]);
            combination2Dfs2(state, cur+1, target-nums[cur], nums, result);
            state.removeLast();
        }
        // not add
        combination2Dfs2(state, cur+1, target, nums, result);
    }

}
