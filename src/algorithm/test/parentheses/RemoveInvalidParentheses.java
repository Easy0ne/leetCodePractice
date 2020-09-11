package algorithm.test.parentheses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/7 17:27
 */
public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
        removeInvalidParentheses.removeInvalidParentheses("()())()");
    }

    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) return null;
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int[] marks = new int[n];
        List<Integer> invalidRightIdxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                marks[i] = -1;  // letters
            } else if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                marks[stack.pop()] = 1; // matched (
                marks[i] = 2;   //matched )
            } else {
                marks[i] = 3;   // invalid
                invalidRightIdxes.add(i);
            }
        }

        int k = 0, count = 0;
        List<List<Integer>> idxesList = new ArrayList<>(invalidRightIdxes.size());
        for (int i = 0; i < invalidRightIdxes.size(); i++) {
            idxesList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {

            if (i < invalidRightIdxes.get(k)) {
                if (marks[i] == 2 || marks[i] == 0) {
                    count++;
                    idxesList.get(k).add(i);
                }
            } else {
                idxesList.get(k).add(i);
                k++;
            }
        }

        for (int i = 0; i < idxesList.size(); i++) {
            int idx = invalidRightIdxes.get(i);
            for (int j = idxesList.get(i).size()-2; j >= 0 ; j--) {
                if (idx-1 == idxesList.get(i).get(j)) {
                    idxesList.get(i).remove(j);
                    idx--;
                }
            }
            System.out.println(idxesList);
        }

        return null;
    }
}
