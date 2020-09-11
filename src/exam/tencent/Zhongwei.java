package exam.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/6 21:33
 */
public class Zhongwei {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            if (n <= 0) {
                System.out.println();
                continue;
            }
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = cin.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                if (i < n/2) {
                    System.out.println(arr[n/2]);
                } else {
                    System.out.println(arr[(n/2)-1]);
                }
            }
        }
    }
}
