package algorithm.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author wangzk
 * @date 2020-03-12 16:54
 */
public class DataStructure {

    public static void main(String[] args) {
        getConsecutiveNums();
    }

    @Test
    public void testMerge2Arr() {
        int[] arr1 = {7,9};
        int[] arr2 = {8};
        System.out.println(Arrays.toString(merge2SortedArr(arr1, arr2)));
    }

    @Test
    public void testFind1stDuplicate() {
        int[] arr1 = {2,5,3,7,2,1};
        int[] arr2 = {1,1};
        System.out.println(find1stDuplicate(arr2));
    }

    public static int[] merge2SortedArr(int[] arr1, int[] arr2) {
        int i=0, j=0, k=0, n1 = arr1.length, n2 = arr2.length;
        int[] newArr = new int[n1+n2];
        while (i<n1 && j<n2) {
            if (arr1[i] < arr2[j]) newArr[k++] = arr1[i++];
            else newArr[k++] = arr2[j++];
        }
        while (i<n1) newArr[k++] = arr1[i++];
        while (j<n2) newArr[j++] = arr2[j++];
        return newArr;
    }

    public static int find1stDuplicate(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i=0; i<n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i])+1);
                return i;
            }
        }
        return -1;
    }

    public static void getConsecutiveNums() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int L = sc.nextInt();
            if (N < 1 || N > 1000000000 || L < 2 || L > 100) {
                System.out.println("No");
            }
            boolean flag = false;
            for (int i = L; i <= 100; i++) {
                if (i % 2 == 0 && ((float) N / i - N / i) * 2 == 1.0) {
                    int quotient = N / i;
                    if (quotient - i / 2 + 1 < 0) break;
                    else {
                        for (int j = -(i / 2) + 1; j < i / 2; j++)
                            System.out.print(quotient + j + " ");
                        System.out.println(quotient + i / 2);
                        flag = true;
                        break;
                    }
                }
                if(i % 2 !=0 && (float) N/i == N/i) {
                    int quotient = N / i;
                    if (quotient - i / 2 < 0) break;
                    else {
                        for (int j = -(i / 2); j < i / 2; j++)
                            System.out.print(quotient + j + " ");
                        System.out.println(quotient + i / 2);
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) System.out.println("No");
        }
    }


}
