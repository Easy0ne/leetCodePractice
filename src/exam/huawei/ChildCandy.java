package exam.huawei;

import java.util.*;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/2 19:08
 */
public class ChildCandy {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n_child = cin.nextInt();
            if(n_child == 0) {
                System.out.println("null");
                continue;
            }
            int[][] data = new int[n_child][2];
            for (int i = 0; i < n_child; i++) {
                data[i][0] = cin.nextInt();
                data[i][1] = cin.nextInt();
            }
//            List<List<Integer>> list1 = new ArrayList<>(n_child);
//            List<List<Integer>> list2 = new ArrayList<>(n_child);
            int[][] arr1 = new int[n_child][2];
            int[][] arr2 = new int[n_child][2];
            int nArr1 = 0, nArr2 = 0;
            for (int i = 0; i < n_child; i++) {
                if (data[i][1] == 1) {
                    arr1[nArr1][0] = i;
                    arr1[nArr1][1] = data[i][0];
                    nArr1 ++;
                } else {
                    arr2[nArr2][0] = i;
                    arr2[nArr2][1] = data[i][0];
                    nArr2 ++;
                }
            }
            if (nArr1 < 3 && nArr2 < 3) {
                System.out.println("null");
                continue;
            }
            int[] idxes1 = new int[3];
            int max1 = 0;
            int[] idxes2 = new int[3];
            int max2 = 0;
            if (nArr1 >= 3) {
                idxes1 = get3Idxes(arr1, nArr1);
                for (int i = 0; i < 3; i++) {
                    max1 += data[idxes1[i]][0];
                }
            }
            if (nArr2 >= 3) {
                idxes2 = get3Idxes(arr2, nArr2);
                for (int i = 0; i < 3; i++) {
                    max2 += data[idxes2[i]][0];
                }
            }

            if (max2 > max1) {
                for (int i = 0; i < 3; i++) {
                    System.out.print(idxes2[i]+1 + " ");
                }
                System.out.println();
                System.out.println("2");
                System.out.println(max2);
            } else {
                if (max1 > max2) {
                    for (int i = 0; i < 3; i++) {
                        System.out.print(idxes1[i]+1 + " ");
                    }
                    System.out.println();
                    System.out.println("1");
                    System.out.println(max1);
                } else {
                    for (int i = 0; i < 3; i++) {
                        System.out.print(idxes2[i]+1 + " ");
                    }
                    System.out.println();
                    System.out.println("2");
                    System.out.println(max2);
                }
            }
        }
    }

    public static int[] get3Idxes(int[][] arr, int n) {
        int idx1 = 0, idx2 = 0, idx3 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][1] > arr[idx1][1]) {
                idx1 = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != idx1 && arr[i][1] > arr[idx2][1]) {
                idx2 = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != idx1 && i != idx2 && arr[i][1] > arr[idx3][1]) {
                idx3 = i;
            }
        }
        int[] result = new int[3];
        result[0] = arr[idx3][0];
        result[1] = arr[idx2][0];
        result[2] = arr[idx1][0];
        return result;
    }
}
