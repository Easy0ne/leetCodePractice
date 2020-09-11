package exam.tencent;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/5 19:59
 */
public class SeeBuildings {

    public static int[][] countToTail;
    public static int[][] countToFront;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[] w = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = cin.nextInt();
            }
            if (n==1) {
                System.out.println(1);
                continue;
            }
            countToTail = new int[n][n];
            countToFront = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(countToTail[i], -1);
                Arrays.fill(countToFront[i], -1);
            }
            int[] toTailN = toTailCount(w);
            int[] toFrontN = toFrontCount(w);
            int[] countAll = new int[n];
            for (int i = 0; i < n; i++) {
                countAll[i] = toTailN[i] + toFrontN[i] + 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i: countAll) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }


    public static int[] toTailCount(int[] w) {
        int n = w.length;
        int[] toTailN = new int[n];
        int[] toTailMax = new int[n];
        int[] toTailMaxIdx = new int[n];
//        toTailN[n-1] = 0;
//        toTailMax[n-1] = 0;
//        toTailMaxIdx[n-1] = n;
        toTailN[n-2] = 1;
        toTailMax[n-2] = 1;
        toTailMaxIdx[n-2] = w[n-1];
        for (int i = n-3; i >= 0; i--) {
            if (w[i+1] < w[i+2]) {
                toTailN[i] = toTailN[i+1] + 1;
                toTailMax[i] = toTailMax[i+1];
                toTailMaxIdx[i] = toTailMaxIdx[i+1];
            } else if (w[i+1] > toTailMax[i+1]) {
                toTailN[i] = 1;
                toTailMax[i] = w[i+1];
                toTailMaxIdx[i] = i+1;
            } else {
                toTailMax[i] = toTailMax[i+1];
                toTailMaxIdx[i] = toTailMaxIdx[i+1];
                int counter = 1;
                int localMax = w[i+1];
                for (int j = i+2; j <= toTailMaxIdx[i+1]; j++) {
//                    if (countToTail[j][toTailMaxIdx[i+1]] != -1) {
//                       counter = counter + countToTail[j][toTailMaxIdx[i+1]];
//                       break;
//                    }
                    if (w[j] > localMax) {
                        counter+=1;
                        localMax = w[j];
                    }
                }
                toTailN[i] = counter;
                countToTail[i][toTailMaxIdx[i+1]] = counter;
            }
        }
        return toTailN;
    }

    public static int[] toFrontCount(int[] w) {
        int n = w.length;
        int[] toFrontN = new int[n];
        int[] toFrontMax = new int[n];
        int[] toFrontMaxIdx = new int[n];
//        toFrontN[0] = 0;
//        toFrontMax[0] = 0;
//        toFrontMaxIdx[0] = -1;
        toFrontN[1] = 0;
        toFrontMax[1] = w[0];
        toFrontMaxIdx[1] = 0;
        for (int i = 2; i < n; i++) {
            if (w[i-1] < w[i-2]) {
                toFrontN[i] = toFrontN[i-1] + 1;
                toFrontMax[i] = toFrontMax[i-1];
                toFrontMaxIdx[i] = toFrontMaxIdx[i-1];
            } else if (w[i-1] > toFrontMax[i-1]) {
                toFrontN[i] = 1;
                toFrontMax[i] = w[i-1];
                toFrontMaxIdx[i] = i-1;
            } else {
                toFrontMax[i] = toFrontMax[i-1];
                toFrontMaxIdx[i] = toFrontMaxIdx[i-1];
                int counter = 1;
                int localMax = w[i];
                for (int j = i-2; j >= toFrontMaxIdx[i-1]; j--) {
                    if (w[j] > localMax) {
                        counter+=1;
                        localMax = w[j];
                    }
                }
                toFrontN[i] = counter;
                countToFront[i][toFrontMaxIdx[i-1]] = counter;
            }
        }
        return toFrontN;
    }


}
