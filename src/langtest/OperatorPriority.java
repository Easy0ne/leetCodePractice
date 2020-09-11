package langtest;

import java.util.Random;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/28 17:16
 */
public class OperatorPriority {

    public static void main(String[] args) {
        OperatorPriority operatorPriority = new OperatorPriority();
        operatorPriority.testForceCast();
    }

    public void testForceCast() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println((int) random.nextFloat()*10);
        }
    }
}
