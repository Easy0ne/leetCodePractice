package exam.tencent;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/6 20:09
 */
public class SortedListCommon {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            long[] list1 = new long[n];
            for (int i = 0; i < n; i++) {
                list1[i] = cin.nextInt();
            }
            int m = cin.nextInt();
            long[] list2 = new long[m];
            for (int i = 0; i < m; i++) {
                list2[i] = cin.nextInt();
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0, j = 0; i < n && j < m;) {
                if (list1[i] > list2[j]) {
                    i ++;
                } else if (list1[i] == list2[j]) {
                    sb.append(list1[i] + " ");
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            System.out.println(sb.deleteCharAt(sb.length()-1));
        }
    }
}
