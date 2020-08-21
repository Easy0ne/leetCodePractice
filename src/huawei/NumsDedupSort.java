package huawei;


import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @description:    HJ3 明明的随机数-去重与排序
 * @author: wangzk
 * @date: 2020/8/20 12:16
 */
public class NumsDedupSort {
    public static void numsDedupSort1() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            boolean[] arr = new boolean[1001];
            for (int i = 0; i < n; i++) {
                int idx = cin.nextInt();
                if (!arr[idx])
                    arr[idx] = true;
            }
            for (int i = 1; i < 1001; i++) {
                if (arr[i])
                    System.out.println(i);
            }
        }
    }

    public static void numsDedupSort2() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = cin.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i]);;
            }
        }
    }

    public static void numsDedupSort3() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            TreeSet<Integer> integerTreeSet = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                integerTreeSet.add(cin.nextInt());
            }
            integerTreeSet.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
//        numsDedupSort2();
        numsDedupSort3();
    }

}
