package algorithm.test.dfs.permutation;

import java.util.*;

/**
 * @description:    leetCode 78. 子集
 *                  给定的数组中不包含重复元素，返回的子集也不能重复
 * @author: wangzk
 * @date: 2020/8/28 21:21
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsetsByDFS(nums);
        System.out.println(result);
    }

    /*
    类似动态规划
     */
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


    /*
    最经典的位运算
     */
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

    public List<List<Integer>> subsetsByDFS(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> state_root = new LinkedList<>();
        subsetsDfs2(state_root, nums, 0, result);
        return result;
    }

    /*
    dfs
    思路一：对于nums中的每个数字，下标i从0到n-1, 可选path都有两条：让nums[i]加入当前集合和不让nums[i]加入当前集合,求解树是二叉的,深度为n
    所以，时间复杂度为O(2^n)，思路很简单。用这种思路要注意：
    一、因为只有叶子节点才是解，如果中途不能剪枝，很有可能会超时；
    二、这种方法要求给定的nums中不包含重复元素，否则结果集会重复。如果nums有重复，可以转dfs思路二。
     */
    public void subsetsDfs(LinkedList<Integer> state, int[] nums, int cur, List<List<Integer>> result) {
        if (cur == nums.length) {
            result.add(new ArrayList<>(state));
        } else {
            //这里的可选路径就只有两条，不用for循环了

            // 不选nums[start]
            subsetsDfs(state, nums, cur+1, result);

            //选nums[start]
            state.addLast(nums[cur]);
            subsetsDfs(state, nums, cur+1, result);
            state.removeLast();
        }
    }

    /*
    dfs
    思路二：对于[0,1,2,3,4],初始state为[],可选路径为0/1/2/3/4,当第一次选择了2,state为[2]，那么下一次的可选路径只有3/4
     */
    public void subsetsDfs2(LinkedList<Integer> state, int[] nums, int start, List<List<Integer>> result) {
        result.add(new ArrayList<>(state));
        for (int i = start; i < nums.length; i++) {
            state.addLast(nums[i]);
            subsetsDfs2(state, nums, i+1, result);
            state.removeLast();
        }
    }
}
