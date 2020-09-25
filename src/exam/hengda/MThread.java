package exam.hengda;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/22 20:53
 */
public class MThread {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Thread t = Thread.currentThread();
                String name = t.getName();
                for (int i = 0; i < 20; i++) {
                    System.out.println("name=" + name);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
}
