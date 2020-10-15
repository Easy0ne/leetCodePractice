package algorithm.test.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:    leetcode 104. 二叉树的最大深度
 * @author: wangzk
 * @date: 2020/9/25 10:38
 */
public class DepthOfTree {

    public static void main(String[] args) {
        int[] levelOrder = {3,9,20,-1,-1,15,7,-1,-1,-1,-1,4};
        TreeNode root = Tree.createTreeByLevelOrder(levelOrder);
        DepthOfTree depthOfTree = new DepthOfTree();
        System.out.println(depthOfTree.maxDepth(root));
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        int count = 1;
        queue1.add(root);
        while (true) {
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.remove();
                if (node.left != null) queue2.add(node.left);
                if (node.right != null) queue2.add(node.right);
            }
            if (queue2.isEmpty()) {
                break;
            }
            Queue<TreeNode> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
            count ++;
        }
        return count;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            count ++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return count;
    }
}
