package algorithm.test.tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-07-08 11:08
 */

/*
牛客网JZ26 二叉搜索树与双向链表
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

public class ConvertBST2Link {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        queue.offer(pRootOfTree);
        map.put(pRootOfTree, 0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null && !map.containsKey(node.left)) {
                TreeNode oLeft = node.left;
                TreeNode left = node.left;
                while (left.right != null && (!map.containsKey(left.right) || map.get(left.right) > map.get(left))) {
                    left = left.right;
                }
                node.left = left;
                left.right = node;
                if (!map.containsKey(oLeft)) queue.offer(oLeft);
                map.put(oLeft, map.get(node)+1);
            }
            if (node.right != null && !map.containsKey(node.right)) {
                TreeNode oRight = node.right;
                TreeNode right = node.right;
                while (right.left != null && (!map.containsKey(right.left) || map.get(right.left) > map.get(right))) {
                    right = right.left;
                }
                node.right = right;
                right.left = node;
                if (!map.containsKey(oRight)) queue.offer(oRight);
                map.put(oRight, map.get(node)+1);
            }
        }
        while (pRootOfTree.left != null) pRootOfTree = pRootOfTree.left;
        return pRootOfTree;
    }


    /*
    首先知道，二叉搜索树的中序遍历可以从小到大地输出二叉搜索树。
    将“输出”操作换成链表后面追加。
     */
    public TreeNode convertByInOrderTravel(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pHead = pRootOfTree;
        TreeNode pLast = null;
        Boolean isFirst = true;
        TreeNode node = pRootOfTree;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (isFirst) {
                pHead = node;
                pLast = node;
                isFirst = false;
            } else {
                pLast.right = node;
                node.left = pLast;
                pLast = node;
            }
            node = node.right;
        }
        return pHead;
    }

    /*
    递归版中序遍历
    需要借助成员变量记录链表的尾部pLast，
    头部的记录方法也需要注意；
     */
    private TreeNode pLast = null;
    public TreeNode convertByInOrderTravel_Recur(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;

        TreeNode plHead = convertByInOrderTravel_Recur(pRootOfTree.left);
        if (plHead == null) plHead = pRootOfTree;  // !!!最先执行到这的是第一个递归出去后，这时可以得到链表头部。并且可以通过上一行的递归将头部传到最外层递归。
        //当然也可以使用成员变量的方式记录，但不返回的话，不符合方法返回值。
        if (pLast == null) {    //同上，第一个递归出去后
            pLast = pRootOfTree;
        } else {
            pLast.right = pRootOfTree;
            pRootOfTree.left = pLast;
            pLast = pRootOfTree;
        }
        convertByInOrderTravel_Recur(pRootOfTree.right);
        return plHead;
    }


    @Test
    public void test() {
        TreeNode node10 = new TreeNode(10);
        TreeNode node3 = new TreeNode(3);
        TreeNode node13 = new TreeNode(13);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node9 = new TreeNode(9);
        TreeNode node19 = new TreeNode(19);

        node10.left = node3;
        node10.right = node13;

        node3.right = node7;

        node13.right = node19;

        node7.left = node4;
        node7.right = node9;

        TreeNode node = convertByInOrderTravel_Recur(node10);
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.right;
        }
    }

}
