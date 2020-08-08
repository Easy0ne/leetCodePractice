package bishi.netease;

import java.util.*;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-08-08 15:50
 */
public class SubSeq {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        if (n == 0 || m == 0) {
            System.out.println(0);
            return;
        }
        LinkedList<Integer> lList = new LinkedList<Integer>();
        for (int i = 0; i < m; i++) {
            lList.add(cin.nextInt());
        }
        if (n <= m) {
            for (int i = 0; i < lList.size() - 1; i++) {
                System.out.print(lList.get(i) + " ");
            }
            System.out.println(lList.getLast());
        }

        HashSet<Integer> hSet = new HashSet<>(lList);
        int count_need = n - hSet.size();
        int lastIdx = 0;
        for (int i = 1; i <= n && count_need > 0; i++) {
            if (!hSet.contains(i)) {
                for (int j = lastIdx; j < lList.size(); j++) {
                    if (lList.get(j) > i ) {
                        lList.add(j, i);
                        hSet.add(i);
                        count_need -= 1;
                        lastIdx = j+1;
                        break;
                    }
                    if (j == lList.size() - 1) {
                        lList.addLast(i);
                        hSet.add(i);
                        count_need -= 1;
                        lastIdx = j+1;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < lList.size() - 1; i++) {
            System.out.print(lList.get(i) + " ");
        }
        System.out.println(lList.getLast());

    }
}
