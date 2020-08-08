package algorithm.test;

import org.junit.Test;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-05-10 11:13
 */
public class TestMySolution {

    @Test
    public void testStackWithMin() {
        StackWithMin_Opt stackWithMin_opt = new StackWithMin_Opt();
        stackWithMin_opt.push(2);
        stackWithMin_opt.push(4);
        stackWithMin_opt.push(5);
        stackWithMin_opt.push(7);
        System.out.println(stackWithMin_opt.min());
        stackWithMin_opt.push(1);
        System.out.println(stackWithMin_opt.min());
        stackWithMin_opt.pop();
        System.out.println(stackWithMin_opt.min());
    }
}
