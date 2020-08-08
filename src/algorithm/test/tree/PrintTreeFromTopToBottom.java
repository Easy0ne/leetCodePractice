package algorithm.test.tree;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-05-17 15:35
 */
public class PrintTreeFromTopToBottom {
    public ArrayList<Integer> printTreeFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            System.out.println(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return list;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        printTreeFromTopToBottom(root);
        TreeNode root1 = null;
        printTreeFromTopToBottom(null);
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(list.toString());
    }
}
