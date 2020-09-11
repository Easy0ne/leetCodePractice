package lang;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-09-03 23:08
 */

public class SingletonTest{

    public static void main(String[] args) {
        new SingletonTest().test();
    }
    public void test() {
        Singleton1 s11 = Singleton1.getInstance();
        Singleton1 s12 = Singleton1.getInstance();
        System.out.println(s11 == s12);

        Singleton2 s21 = Singleton2.getInstance();
        Singleton2 s22 = Singleton2.getInstance();
        System.out.println(s21 == s22);

        Singleton3 s31 = Singleton3.instance;
        Singleton3 s32 = Singleton3.instance;
        System.out.println(s31 == s32);

        Singleton4 s41 = Singleton4.getInstance();
        Singleton4 s42 = Singleton4.getInstance();
        System.out.println(s41 == s42);
    }
}


class Singleton1 {
    private Singleton1() {}
    private static Singleton1 singleton1 = new Singleton1();
    public static Singleton1 getInstance() {
        return singleton1;
    }
}

class Singleton2 {
    private Singleton2(){}
    private static Singleton2 instance;
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

enum  Singleton3 {
    instance;
    private Singleton3() {}
}

class Singleton4 {
    private Singleton4() {}
    private static class Singleton4Holder{
        private static Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return Singleton4Holder.instance;
    }
}
