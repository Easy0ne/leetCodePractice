package algorithm.test.tree;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-06-17 13:30
 */
public class Tree {
    public void preOrderTravelRecur(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val+ "\t");
        preOrderTravelRecur(node.left);
        preOrderTravelRecur(node.right);
    }

    public void inOrderTravelRecur(TreeNode node) {
        if (node == null) return;
        if (node.left != null) inOrderTravel(node.left);
        System.out.print(node.val+ "\t");
        if (node.right != null) inOrderTravel(node.right);
    }

    public void postOrderTravelRecur(TreeNode node) {
        if (node == null) return;
        if (node.left != null) postOrderTravelRecur(node.left);
        if (node.right != null) postOrderTravelRecur(node.right);
        System.out.print(node.val+ "\t");
    }

    public static TreeNode createTreeByLevelOrder(int[] levelOrder) {
        int len = levelOrder.length;
        TreeNode[] nodes = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            int val = levelOrder[i];
            if(val < 0) continue;
            nodes[i] = new TreeNode(val);
            if (i % 2 == 1) nodes[(i-1)/2].left = nodes[i];
            else nodes[(i-1)/2].right = nodes[i];
        }
        return nodes[0];
    }


    //非递归的思路参考https://blog.csdn.net/z_ryan/article/details/80854233
    //Java实现参考https://www.cnblogs.com/0ffff/p/11095250.html

    public void inOrderTravel(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.val + "\t");
                node = node.right;
            }
        }
    }


    public void preOrderTravel(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node!=null || !stack.empty()) {
            if (node != null) {
                System.out.print(node.val + "\t");
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /*
    ////////////////////还是比较难的
     */
    public void postOrderTravel(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode lastNode = null;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == lastNode) {
                stack.pop();
                System.out.print(node.val + "\t");
                lastNode = node;
                node = null;
            } else {
                node = node.right;
            }
        }
    }

    // 一种巧妙的设计，参考 https://blog.csdn.net/GSCurry/article/details/77993483
    // 思想是：
    // 后序遍历(左->右->根)是(根->右->左)的反转
    // (根->右->左)可参考前序遍历(根->左->右)
    // 也可以使用另一个栈来反转
    public ArrayList<Integer> postOrderTravelByPreReverse(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.right;
            }
            if (!stack.empty()) {
                node = stack.pop();
                node = node.left;
            }
        }
        Collections.reverse(list);
        System.out.println(list);
        return list;
    }

    public TreeNode creatTreeByPreAndIn(int[] preSeq, int[] inSeq) {
        if (preSeq == null || inSeq == null) return null;
        int n = inSeq.length;
        if (n <= 0) return null;
        int pivot_idx = 0;
        for (int i = 0; i < n; i++) {
            if (preSeq[0] == inSeq[i]) {
                pivot_idx = i;
                break;
            }
        }
        // 递归的关键就在于{root,| left, left, ...| right, right, ...}与{left, left, ...| root,| right, right, ...}的left长度是相同的
        int[] leftPreSeq = Arrays.copyOfRange(preSeq, 1, pivot_idx+1);
        int[] rightPreSeq = Arrays.copyOfRange(preSeq, pivot_idx+1, n);
        int[] leftInSeq = Arrays.copyOfRange(inSeq, 0, pivot_idx);
        int[] rightInSeq = Arrays.copyOfRange(inSeq, pivot_idx+1, n);
        TreeNode root = new TreeNode(preSeq[0]);
        root.left = creatTreeByPreAndIn(leftPreSeq, leftInSeq);
        root.right = creatTreeByPreAndIn(rightPreSeq, rightInSeq);
        return root;
    }

    @Test
    public void testTravel() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;

        node2.right = node4;

        node4.left = node5;
        node4.right = node6;

        System.out.println("PreOrder:");
        preOrderTravelRecur(node1);
        System.out.println();
        preOrderTravel(node1);
        System.out.println();


        System.out.println("InOrder:");
        inOrderTravelRecur(node1);
        System.out.println();
        inOrderTravel(node1);
        System.out.println();

        System.out.println("postOrder");
        postOrderTravelRecur(node1);
        System.out.println();
        postOrderTravel(node1);
        System.out.println();
        postOrderTravelByPreReverse(node1);
        System.out.println();
    }

    @Test
    public void testCreatTree() {
        int[] preOrder = {1,2,4,5,6,3};
        int[] inOrder = {2,5,4,6,1,3};
        int[] postOrder = {5, 6, 4, 2, 3, 1};

        TreeNode root = creatTreeByPreAndIn(preOrder, inOrder);
        List<Integer> generatedPostOrder = postOrderTravelByPreReverse(root);
        System.out.println(Arrays.equals(generatedPostOrder.stream().mapToInt(Integer::valueOf).toArray(), postOrder));
    }
}
