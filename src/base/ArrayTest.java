package base;

import org.junit.Test;


/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/19 10:17
 */
class TestObj {
    int value;
}

public class ArrayTest {

    @Test
    public void testInit() {
        int[] arr = new int[5];
        String[] strArr = new String[5];
        TestObj[] testObjs = new TestObj[5];
        System.out.println(arr[3]);
        System.out.println(strArr[3]);
        System.out.println(testObjs[3]);
    }
}
