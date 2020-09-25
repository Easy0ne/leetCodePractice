package exam.taledu;

import algorithm.test.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/20 14:06
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }

public class TravelTree {

    public static void main(String[] args) {
        TravelTree travelTree = new TravelTree();
//        String[] treeArr = {}
        ArrayList<TreeNode> treeNodes = new ArrayList<>();

        TreeNode root = new TreeNode(); root.val = 1;
        TreeNode node2 = new TreeNode(); node2.val = 2; root.left = node2;
        TreeNode node3 = new TreeNode(); node3.val = 3; root.right = node3;
        TreeNode node4 = new TreeNode(); node4.val = 4; node2.left = node4;
        TreeNode node5 = new TreeNode(); node5.val = 5; node2.right = node5;


        System.out.println(travelTree.notReCuPreOrder(root));
    }

    /**
     * 二叉树的非递归前序遍历
     * @param root TreeNode类 根节点
     * @return string字符串
     */
    public String notReCuPreOrder (TreeNode root) {
        // write code here
        StringBuilder sb = new StringBuilder();
        if (root == null) return sb.toString();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                sb.append(node.val + ",");
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return sb.substring(0, sb.length()-1);
    }

}
