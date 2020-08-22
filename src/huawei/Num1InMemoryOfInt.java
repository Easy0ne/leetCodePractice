package huawei;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/22 16:07
 */
public class Num1InMemoryOfInt {

    public static void main(String[] args) {
        count1();
    }

    public static void count1() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int x = cin.nextInt();
            int count = 0;
            while (x > 0) {
//                if (x % 2 == 1)
//                    count += 1;
                if ((x & 1) == 1)
                    count += 1;
                x = x >> 1;
            }
            System.out.println(count);
        }
    }
}
