package langtest;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/16 19:04
 */
public class ExceptionTest {

    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();

        System.out.println(exceptionTest.testCatchFinally(1));
        System.out.println("--------------");
        System.out.println(exceptionTest.testCatchFinally(-1));
    }

    public int testCatchFinally(int i) {
        try {
            i = i++ / i;
            System.out.println("i="+i);
            return i;
        } catch (Exception e) {
            System.out.println("catch e");
            return 0;
        } finally {               // finally 无论如何都会被执行
            System.out.println("finally");
            return 1;
        }
    }
}
