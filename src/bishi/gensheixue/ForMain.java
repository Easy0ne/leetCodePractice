package bishi.gensheixue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-08-07 17:52
 */
public class ForMain {

    public void findPaisan() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            Set<Integer>[] pSet = new HashSet[n];
            for (int k = 0; k < n; k++) {
            }
            for (int i = 0; i < m; i++) {
                int p1 = cin.nextInt();
                int p2 = cin.nextInt();
                int connected = cin.nextInt();
                if (connected == 1) {
                    System.out.println();
                }
            }
        }
    }
}
