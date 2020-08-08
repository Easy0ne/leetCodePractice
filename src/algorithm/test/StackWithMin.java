package algorithm.test;

import java.util.Stack;
/**
 * @author wangzk
 * @date 2020-04-29 10:08
 */
public class StackWithMin {

    private Stack stack = new Stack<Integer>();
    private int min = Integer.MAX_VALUE;

    public void push(int node) {
        if (node < min) min = node;
        stack.push(node);
    }

    public void pop() {
        if ((Integer)stack.peek() == min) {
            int temp_min = Integer.MAX_VALUE;
            for (int i=0; i<stack.size()-1; i++){
                if ((Integer)stack.elementAt(i) < temp_min) {
                    temp_min = (Integer) stack.elementAt(i);
                }
            }
            min = temp_min;
        }
        stack.pop();
    }

    public int top() {
        return (Integer) stack.peek();
    }

    public int min() {
        return min;
    }

    public static void main(String[] args) {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(1);
        stackWithMin.push(5);
        stackWithMin.push(-4);
        stackWithMin.push(3);
        stackWithMin.push(-7);
        System.out.println(stackWithMin.min());
        System.out.println(stackWithMin.top());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.push(-2);
        System.out.println(stackWithMin.min());
        stackWithMin.push(-6);
        System.out.println(stackWithMin.min());
    }
}
