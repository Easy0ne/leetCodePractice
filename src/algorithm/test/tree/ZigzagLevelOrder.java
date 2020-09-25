package algorithm.test.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/25 10:14
 */
public class ZigzagLevelOrder {

    public static void main(String[] args) {
        int[] levelOrder1 = {1,2,3,-1,-1,4,5};
        int[] levelOrder2 = {1,2,3,4,-1,-1,5};
        TreeNode root = Tree.createTreeByLevelOrder(levelOrder2);
        ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
        System.out.println(zigzagLevelOrder.zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        boolean flag = true;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> line = new LinkedList<>();
            if(flag) {
                int n = stack1.size();
                for (int i = 0; i < n; i++) {
                    TreeNode node = stack1.pop();
                    line.add(node.val);
                    if (node.left != null) stack2.push(node.left);
                    if (node.right != null) stack2.push(node.right);
                }
            } else {
                int n = stack2.size();
                for (int i = 0; i < n; i++) {
                    TreeNode node = stack2.pop();
                    line.add(node.val);
                    if (node.right != null) stack1.add(node.right);
                    if (node.left != null) stack1.add(node.left);
                }
            }
            flag = !flag;
            result.add(line);
        }
        return result;
    }
}
