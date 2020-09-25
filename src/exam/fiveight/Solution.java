package exam.fiveight;

import java.util.*;

class TreeNode {
  int val = 0;
   TreeNode left = null;
   TreeNode right = null;
}

public class Solution {
    /**
     *
     * @param node TreeNode类 
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> printNode (TreeNode node) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (node == null) return result;
        ArrayList<Integer> line = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        line.add(node.val);
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            ArrayList<Integer> lineTemp = new ArrayList<>();
            if (temp.left!=null){
                queue.add(temp.left);
                lineTemp.add(temp.left.val);
            }
            if (temp.right!=null) {
                queue.add(temp.right);
                lineTemp.add(temp.right.val);
            }
            result.add(lineTemp);
        }
        return result;

    }
}