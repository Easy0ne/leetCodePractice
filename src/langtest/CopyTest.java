package langtest;

import java.util.Arrays;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/9 9:04
 */
public class CopyTest {

    public static void main(String[] args) {
        CopyTest copyTest = new CopyTest();
        copyTest.testArrayCopy();

        String s = "String";
        StringBuilder sb = new StringBuilder("String Builder");
        copyTest.testStringArgsCopy(s, sb);
        System.out.println(s);
        System.out.println(sb);
    }

    public void testStringArgsCopy(String str, StringBuilder sb) {
        str = "new string"; // 只是让这里的str指向"new string"
        sb.append("2"); // 对对象的修改是会起作用的
        sb = new StringBuilder("String Builder3"); // 让这里的sb指向新的StringBuilder对象
    }

    public void testArrayCopy() {
        int[] a = new int[5];
        int[] b = Arrays.copyOf(a, 5);  //一维数组的引用是直接指向int[]对象的
        a[1] = 1;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println("--------------");

        int[][] as = new int[3][5];
        int[][] bs = Arrays.copyOf(as, 3);  // as指向的是5个引用，bs实际copy的是5个引用，这5个引用指向的int[]对象还是原来as的5个引用所指向的
        as[2][0] = 1;
        as[2][2] = 1;
        System.out.println("as:");
        for (int[] item: as) {
            System.out.println(Arrays.toString(item));
        }
        System.out.println("bs:");
        for (int[] item: bs) {
            System.out.println(Arrays.toString(item));
        }
    }
}
