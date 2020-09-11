package langtest;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/1 9:04
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        CopyOnWriteArrayListTest copyOnWriteArrayListTest = new CopyOnWriteArrayListTest();
        copyOnWriteArrayListTest.testAdd();
    }

    public void testAdd() {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(0);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 100; i++) {
                    copyOnWriteArrayList.add(i);
                    System.out.println("add " + i);
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(copyOnWriteArrayList);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
