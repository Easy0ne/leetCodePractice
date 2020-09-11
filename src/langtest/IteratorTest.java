package langtest;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/9 18:19
 */
public class IteratorTest {

    public static void main(String[] args) {
        IteratorTest iteratorTest = new IteratorTest();
        iteratorTest.testListForeach();

    }

    public void testListForeach() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(String.valueOf(i));
        }
        list.add(4, "3");
        list.add(5, "3");
        System.out.println(list);
        for (String s: list) {
            list.remove(s);
            System.out.println(list);
        }
    }
}
