package algorithm.test.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description:    计算含有"+-/*以及括号()"的表达式  参考https://blog.csdn.net/sinat_27908213/article/details/80273557
 * @author: wangzk
 * @date: 2020/10/11 10:05
 */
public class Calculator {

    public static void main(String[] args) {
        String[] tokens = {"1", "+", "(", "2", "-", "3", ")", "*", "4", "+", "4", "/", "2"};
        Calculator calculator = new Calculator();
        String[] postfixTokens = calculator.transferMidFix2Postfix(tokens);
        ReversePolishExpression reversePolishExpression = new ReversePolishExpression();
        System.out.println(reversePolishExpression.evalRPN(postfixTokens));
        System.out.println(calculator.calMidFix(tokens));
    }


    public int getPriority(char operator) {
        if (operator == '(') return 0;  // 这里不是指括号的优先级小，而是transferMidFix2Postfix中while弹栈时弹到(处停止。
        else if (operator == '+' || operator == '-') return 1;
        else if (operator == '*' || operator == '/') return 2;
        else return 3;
    }

    public String[] transferMidFix2Postfix(String[] tokens) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (String token: tokens) {
            char tokenFix = token.charAt(token.length()-1);
            if ('0' <= tokenFix && tokenFix <= '9') {
                result.append(token + " ");
            } else if (tokenFix == '+' || tokenFix == '-' || tokenFix == '*' || tokenFix == '/'){
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(tokenFix)) {
                        result.append(stack.pop() + " ");
                }
                stack.push(tokenFix);
            } else if (tokenFix == '(') {
                stack.push(tokenFix);
            } else if (tokenFix == ')') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    } else {
                        result.append(stack.pop() + " ");
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop() + " ");
        }
        System.out.println(result);
        return result.toString().split(" ");
    }


    /*
    思路其实挺简单的，类似上面中缀转后缀，关键在于优先级比较，当遇到+或-操作符时，stack中上一个+或-上面的*和/要先算完
     */
    public int calMidFix(String[] tokens) {
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (String token: tokens) {
            char tokenFix = token.charAt(token.length()-1);
            if ('0' <= tokenFix && tokenFix <= '9') {
                numStack.push(Integer.valueOf(token));
            } else if (tokenFix == '+' || tokenFix == '-' || tokenFix == '*' || tokenFix == '/'){
                while (!opStack.isEmpty() && getPriority(opStack.peek()) >= getPriority(tokenFix)) {
                    cal1TimeByStack(opStack, numStack);
                }
                opStack.push(tokenFix);
            } else if (tokenFix == '(') {
                opStack.push(tokenFix);
            } else if (tokenFix == ')') {
                while (opStack.peek() != '(') {
                    cal1TimeByStack(opStack, numStack);
                }
                opStack.pop();
            }
        }
        while (!opStack.isEmpty()) {
            cal1TimeByStack(opStack, numStack);
        }
        return numStack.pop();
    }

    public void cal1TimeByStack(Stack<Character> opStack, Stack<Integer> numStack) {
        char operator = opStack.pop();
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        if (operator == '+') {
            numStack.push(num1+num2);
        } else if (operator == '-') {
            numStack.push(num1-num2);
        } else if (operator == '*') {
            numStack.push(num1*num2);
        } else if (operator == '/') {
            numStack.push(num1/num2);
        }
    }


    /*
    leetcode 227. 基本计算器 II
    没有括号，可以将所有操作都转换成加法，得到数字先不压栈，*和/可以直接计算并将结果保存到stack中，-可以转换为负数，最后将stack中的数累加
    这里是一个String表达式，对数字处理会麻烦些
     */
    public int calculateMidFixString(String exp) {
        int num = 0;
        char op = '+';
        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if ( '0' <= ch && ch <= '9') {
                num = num * 10 + (ch - '0');
            }
            if (ch < '0' && ch != ' ' || i == exp.length()-1) {  //这里需要注意, 末尾的数字也需要压栈
                if (op == '+') numStack.push(num);
                else if (op == '-') numStack.push(-num);
                else if (op == '*') numStack.push(numStack.pop() * num);
                else if (op == '/') numStack.push(numStack.pop() / num);
                op = ch;
                num = 0;
            }
        }
        int sum = 0;
        while (!numStack.isEmpty()) {
            sum += numStack.pop();
        }
        return sum;
    }

    @Test
    public void testCalculateMidFixString() {
        String exp = "3+2*2";
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculateMidFixString(exp));
    }
}
