package algorithm.test.parentheses;

import java.util.Stack;

/**
 * @description:    leetCode 20. 有效的括号
 * @author: wangzk
 * @date: 2020/9/6 16:10
 */
public class BracketMatch {

    public static void main(String[] args) {
        BracketMatch bracketMatch = new BracketMatch();
        System.out.println(bracketMatch.isValid("({[}"));
        System.out.println(bracketMatch.isValid("({[]})"));
        System.out.println(bracketMatch.isValid("({[]})]"));


    }

    /*
    建议去leetCode上看下更多的方法
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        int n = s.length();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (c - stack.peek() == 1 || c - stack.peek() == 2) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
