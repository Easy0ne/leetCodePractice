package lang;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/19 15:54
 */
public class VolatileTest {
//    boolean flag = true;
    volatile boolean flag = true;
    int i = 0;

    public static void main(String[] args) throws Exception {
        VolatileTest volatileTest = new VolatileTest();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (volatileTest.flag) {
                    volatileTest.i++;
                }
                System.out.println(volatileTest.i);  //flag不是volatile的话，不会执行到这一步的
            }
        });
        thread.start();
        Thread.sleep(2000);
        volatileTest.flag = false;
        System.out.println("volatileTest.i = " + volatileTest.i);
    }
}
