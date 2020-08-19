package base;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/13 12:16
 */
public class StringTest {

    @Test
    public void testContact() {
        String s = "a";
        String s_1 = new String("a");
        String s1 = "a";
        String s2 = "a" + s;
        String s3 = s1 + s;
        String s4 = "a" + "a";
        String s5 = "aa";
        String s6 = s_1 + s1;

        System.out.println("s == s1:" + (s == s1));    //T
        System.out.println("s2 == s3:" + (s2 == s3));   //F
        System.out.println("s3 == s4:" + (s3 == s4));   //F
        System.out.println("s3 == s5:" + (s3 == s5));   //F
        System.out.println("s5 == s6:" + (s5 == s6));  //F
        System.out.println("s4 == s5:" + (s4 == s5));    //T,
        // 表达式只有常量时，编译阶段会优化
        // 表达式有变量时，运行期才计算，所以地址不一样
    }

    // ref https://blog.csdn.net/qq_41907991/article/details/106799400
    @Test
    public void testIntern6Diff7() {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println("s == s2 : " + (s == s2));
        //JDK1.6 false
        //JDK1.7 false

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println("s3 == s4 : " + (s3 == s4));
        //JDK1.6 false
        //JDK1.7 true
    }

    @Test
    public void testIntern() {
        String s1 = "a";
        String s2 = new String("a");
        String s3 = s2.intern();

        System.out.println("s1 == s2 : " + (s1 == s2));
        System.out.println("s1 == s3 : " + (s1 == s3));
        System.out.println("s2 == s3 : " + (s2 == s3));
    }

    @Test
    public void testInternCase() {
        int MAX = 1000 * 10000;
        String[] arr = new String[MAX];
        Integer[] DB_DATA = new Integer[10];
        Random random = new Random( 10 * 1000);
        for (int i = 0; i < DB_DATA.length; i++) {
            DB_DATA[i] = random.nextInt();
        }
        long t = System.currentTimeMillis();
        for (int i = 0; i < MAX; i++) {
//            arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length]));
            arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length])).intern();
        }

        System.out.println((System.currentTimeMillis() - t) + "ms");
        System.gc();
    }
}
