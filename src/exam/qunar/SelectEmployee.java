package exam.qunar;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/10/14 19:40
 */
public class SelectEmployee {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int m = cin.nextInt();
            int n = cin.nextInt();
            System.out.println(combination(m, n));
        }
    }

    public static long combination(int m, int n) {
        if (n > m || m <= 0 || n < 0) {
            return 0;
        }
        if (n > m/2) {
            n = m - n;
        }

        double prod1 = 1;
        int i = m, j = n;
        while (j >= 1) {
            prod1 /= (double) j;
            prod1 *= i;
//            System.out.println(prod1);
            i--;
            j--;
        }
        return Math.round(prod1);
    }
}
