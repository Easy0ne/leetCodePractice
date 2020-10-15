package exam.bianlifeng;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/10/10 20:30
 */
public class CombinationSumCount {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int k = cin.nextInt();
            int sum = 0;
            for (int i = 1; i <= k; i++) {
                sum += sumOf(n, i);
            }
            System.out.println(sum);
        }
    }

    public static int sumOf(int n, int m) {
        if (m == 0) return 0;
        if (m == 1) return 1;
        if (m == 2) return n/2;
        int count = 0;
        for (int i = 1; i <= (n-1)/2; i++) {
            count = count + sumOf(n-i, m-1) - (i-1);
        }
        return count;
    }
}
