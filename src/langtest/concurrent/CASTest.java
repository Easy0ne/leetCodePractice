package langtest.concurrent;

import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/17 9:58
 */
public class CASTest {
    private static int count;
//    private static volatile int count;    // synchronized与unlock已经保证可见性了(unlock之前会把修改的变量写回主存)，就不需要volatile了

    public static void main(String[] args) throws InterruptedException {
        CASTest casTest = new CASTest();
        System.out.println("testSimpleAdd");    casTest.testSimpleAdd();
        System.out.println();

        System.out.println("testSynchronized"); casTest.testSynchronized();
        System.out.println();

        System.out.println("testLock");     casTest.testLock();
        System.out.println();

        System.out.println("testCAS");  casTest.testCAS();
    }

    public void testSimpleAdd() throws InterruptedException {
        int nThreads = 20;
        int nAdd = 100000;
        long sleepTime = 1000;

        long start = System.currentTimeMillis();
        for (int i = 0; i < nThreads; i++) {
            new Thread(()-> {
                for (int j = 0; j < nAdd; j++) {
                    count++;
                }
            }).start();
        }
//        Thread.sleep(sleepTime); //  确保其他线程都执行完
        while (Thread.activeCount()>1) {
            Thread.yield();
        }
        System.out.println("count = " + count);
        System.out.println("time : " + (System.currentTimeMillis() - start));
    }

    public void testSynchronized() throws InterruptedException {
        int nThreads = 20;
        int nAdd = 100000;
        long sleepTime = 1000;
        count = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < nThreads; i++) {
            new Thread(()-> {
                synchronized (this) {
                    for (int j = 0; j < nAdd; j++) {
                        count++;
                    }
                }
            }).start();
        }
//        Thread.sleep(sleepTime); //  确保其他线程都执行完
        while (Thread.activeCount()>1) {
            Thread.yield();
        }
        System.out.println("count = " + count);
        System.out.println("time : " + (System.currentTimeMillis() - start));
    }

    public void testLock()  throws InterruptedException {
        int nThreads = 20;
        int nAdd = 100000;
        count = 0;
        long sleepTime = 1000;

        long start = System.currentTimeMillis();
        Lock lock = new ReentrantLock();
        for (int i = 0; i < nThreads; i++) {
            new Thread(()-> {
                for (int j = 0; j < nAdd; j++) {
                     lock.lock();
                     count++;
                     lock.unlock();
                }
            }).start();
        }
        //        Thread.sleep(sleepTime); //  确保其他线程都执行完
        while (Thread.activeCount()>1) {
            Thread.yield();
        }
        System.out.println("count = " + count);
        System.out.println("time : " + (System.currentTimeMillis() - start));
    }

    public void testCAS()  throws InterruptedException {
        int nThreads = 20;
        int nAdd = 100000;
        long sleepTime = 1000;
        AtomicInteger atomicInteger = new AtomicInteger(0);

        long start = System.currentTimeMillis();
        for (int i = 0; i < nThreads; i++) {
            new Thread(()-> {
                for (int j = 0; j < nAdd; j++) {
                    atomicInteger.getAndIncrement();
                }
            }).start();
        }
        //        Thread.sleep(sleepTime); //  确保其他线程都执行完
        while (Thread.activeCount()>1) {
            Thread.yield();
        }
        System.out.println("atomicInteger = " + atomicInteger.toString());
        System.out.println("time : " + (System.currentTimeMillis() - start));
    }
}
