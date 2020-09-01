package lang;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/31 16:02
 */
public class RandomTest {

    public static void main(String[] args) {
        RandomTest randomTest = new RandomTest();
        randomTest.testRandom();
    }

    public void testRandom() {
        Random random = new Random();
        List<Integer> integerList = random.ints(50, 10, 20).boxed().collect(Collectors.toList());
        System.out.println(integerList);

    }
}
