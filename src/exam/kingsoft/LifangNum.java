package exam.kingsoft;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/22 21:05
 */
public class LifangNum {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            int count = 0;
            for (int i = a; i <= b; i++) {
                long k = (long) Math.pow(i, 3);
                if (k > b) {
                    break;
                }
                if (check(i, k)) {
                    count++;
                }
                System.out.println(k);
            }
            System.out.println(count);
        }
    }

    public static boolean check(int m, long k) {
        int n = 0, temp = m;
        while (temp != 0) {
            n++;
            temp /= 10;
        }
        long left = k - m;
        for (int i = 0; i < n; i++) {
            if (left % 10 != 0) {
                return false;
            }
            left /= 10;
        }
        return true;
    }
}
