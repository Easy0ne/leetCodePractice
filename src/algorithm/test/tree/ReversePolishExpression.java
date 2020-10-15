package algorithm.test.tree;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:    leetcode 150. 逆波兰表达式求值
 * @author: wangzk
 * @date: 2020/9/25 8:41
 */
public class ReversePolishExpression {

    public static void main(String[] args) {
        ReversePolishExpression reversePolishExpression = new ReversePolishExpression();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] tokens2 = {"19"};
        System.out.println(reversePolishExpression.evalRPN(tokens2));
    }

    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        int len = tokens.length;
        Stack<Integer> stack = new Stack<>();
        Pattern pattern = Pattern.compile("-?\\d+");
        int result = 0;
        for (int i = 0; i < len; i++) {
            String item = tokens[i];
            Matcher matcher = pattern.matcher(item);
            if (matcher.matches()) {
                result = Integer.valueOf(item);
                stack.push(result);
            } else {
                int opNum2 = stack.pop(), opNum1 = stack.pop();
                switch (item) {
                    case "+":
                        result = opNum1 + opNum2;
                        break;
                    case "-":
                        result = opNum1 - opNum2;
                        break;
                    case "*":
                        result = opNum1 * opNum2;
                        break;
                    case "/":
                        result = opNum1 / opNum2;
                        break;
                }
                stack.push(result);
            }
        }
        return result;
    }


}
