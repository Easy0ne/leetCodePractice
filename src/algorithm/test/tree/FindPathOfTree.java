package algorithm.test.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-06-23 23:48
 */
/*
输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPathOfTree {
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
        if (root == null) return pathList;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashMap<TreeNode, Integer> valueMap = new HashMap<TreeNode, Integer>();
        HashMap<TreeNode, ArrayList<Integer>> pathMap = new HashMap<TreeNode, ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(root.val);
        pathMap.put(root, path);
        valueMap.put(root, root.val);
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                if (valueMap.get(node) == target)
                    pathList.add(pathMap.get(node));
            }else if (node.left != null && node.right != null) {
                if (node.left.val > node.right.val) {
                    // left node
                    valueMap.put(node.left, valueMap.get(node) + node.left.val);
                    ArrayList<Integer> path2Left = new ArrayList<>(pathMap.get(node));
                    path2Left.add(node.left.val);
                    pathMap.put(node.left, path2Left);
                    stack.push(node.left);
                    // right node
                    valueMap.put(node.right, valueMap.get(node) + node.right.val);
                    ArrayList<Integer> path2Right = new ArrayList<>(pathMap.get(node));
                    path2Right.add(node.right.val);
                    pathMap.put(node.right, path2Right);
                    stack.push(node.right);
                } else {
                    // right node
                    valueMap.put(node.right, valueMap.get(node) + node.right.val);
                    ArrayList<Integer> path2Right = new ArrayList<>(pathMap.get(node));
                    path2Right.add(node.right.val);
                    pathMap.put(node.right, path2Right);
                    stack.push(node.right);
                    // left node
                    valueMap.put(node.left, valueMap.get(node) + node.left.val);
                    ArrayList<Integer> path2Left = new ArrayList<>(pathMap.get(node));
                    path2Left.add(node.left.val);
                    pathMap.put(node.left, path2Left);
                    stack.push(node.left);
                }
            } else if (node.left != null) {
                valueMap.put(node.left, valueMap.get(node) + node.left.val);
                ArrayList<Integer> path2Left = new ArrayList<>(pathMap.get(node));
                path2Left.add(node.left.val);
                pathMap.put(node.left, path2Left);
                stack.push(node.left);
            } else {
                valueMap.put(node.right, valueMap.get(node) + node.right.val);
                ArrayList<Integer> path2Right = new ArrayList<>(pathMap.get(node));
                path2Right.add(node.right.val);
                pathMap.put(node.right, path2Right);
                stack.push(node.right);
            }
        }
        return pathList;
    }

    public ArrayList<ArrayList<Integer>> findPath_Optm(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        if (root == null) return pathList;
        findPathRecur_Optm(root, target, path, pathList);
        Collections.sort(pathList, (path1, path2) -> path1.size()-path2.size());
        return pathList;
    }

    private void findPathRecur_Optm(TreeNode node, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> pathList) {
        path.add(node.val);
        if (node.left == null && node.right == null && node.val == target)
            // 注意此处是new
            pathList.add(new ArrayList<Integer>(path));
        if (node.left != null)
            findPathRecur_Optm(node.left, target-node.val, path, pathList);
        if (node.right != null)
            findPathRecur_Optm(node.right, target-node.val, path, pathList);
        // 此处要remove
        path.remove(path.size()-1);
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;

        node2.right = node4;

        node3.right = node9;

        node4.left = node5;
        node4.right = node6;

        ArrayList<ArrayList<Integer>> pathList = findPath_Optm(node1, 13);
        for (ArrayList<Integer> path : pathList) {
            System.out.println(path);
        }
    }
}
