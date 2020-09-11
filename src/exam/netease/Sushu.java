package exam.netease;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-08-08 15:11
 */
public class Sushu {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
        }
        int countSum = 0;
        for (int i = 0; i < n; i++) {
            countSum += primeNumberSumHelper(arr[i]);
        }
        System.out.println(countSum);
    }


    public static int primeNumberSumHelper(int n) {
        if (n == 2) return 1;
        if (n <= 1) return 0;
        return 1 + primeNumberSumHelper(n - 2);
    }
}
