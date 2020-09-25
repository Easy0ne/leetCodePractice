package langtest.concurrent;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/19 15:54
 */
public class VolatileTest {
    static boolean flag = true;
//    static volatile boolean flag = true;
    static int count = 0;



    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
//        volatileTest.testVisibility();
        volatileTest.testAtomicity();
    }

    public void testVisibility() {
        String s = "a";
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                    count++;
                }
                System.out.println(count);  //flag不是volatile的话，不会执行到这一步的
            }
        });
        thread.start();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
        System.out.println("count = " + count);
    }

    public void testAtomicity() {
        int nThreads = 20;
        int nAdd = 1000;
        for (int i = 0; i < nThreads; i++) {
            new Thread(()-> {
                for (int j = 0; j < nAdd; j++)
                count++;    // ++操作包含两个指令，iload 和 iinc, Volatile不保证原子性
            }).start();
        }
        System.out.println(count);
    }
}
