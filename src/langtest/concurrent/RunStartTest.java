package langtest.concurrent;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/16 19:18
 */
public class RunStartTest {

    public static void main(String[] args) throws InterruptedException {
        TestThread testThread = new TestThread();
        testThread.run();
        new TestThread().start();
        Thread.sleep(1000);
        testThread.run();

    }
}


class TestThread extends Thread {
    public int i;
    public void run() {
        try {
            i++;
            System.out.println(i);
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}