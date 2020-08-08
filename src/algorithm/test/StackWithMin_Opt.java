package algorithm.test;

import java.util.Stack;

/**
 * @author wangzk
 * @date 2020-04-29 11:01
 */
public class StackWithMin_Opt {
    Stack stack = new Stack();
    Stack stack_min = new Stack();

    public void push(int x) {
        if (stack_min.isEmpty()) {
            stack_min.push(x);
        } else {
            if (x < (Integer) stack_min.peek()) {
                stack_min.push(x);
            }
        }
        stack.push(x);
    }

    public int pop() {
        if ((Integer)stack.peek() == (Integer) stack_min.peek()) {
            stack_min.pop();
        }
        return (Integer) stack.pop();
    }

    public int top() {
        return (Integer) stack.peek();
    }

    public int min() {
        return (Integer) stack_min.peek();
    }
}
