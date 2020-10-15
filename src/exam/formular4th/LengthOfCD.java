package exam.formular4th;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/30 20:57
 */
public class LengthOfCD {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[][] durations = new int[n][2];
            for (int i = 0; i < n; i++) {
                durations[i][0] = cin.nextInt();
                durations[i][1] = cin.nextInt();
            }
            System.out.println(getLengthOfCD(durations));
        }
    }

    public static int getLengthOfCD(int[][] durations) {
        int n = durations.length;
//        int[][] dp = new int[n][2];
        for (int i = 1; i < n; i++) {
            int left = durations[i][0], right = durations[i][1];
            for (int j = i-1; j >=0 ; j--) {
                if (left == durations[j][1]+1 || (durations[j][0] <= left && left <= durations[j][1])) {
                    durations[i][0] = durations[j][0];
                }
                if (right == durations[j][0]-1 || (durations[j][0] <= right && right <= durations[j][1])) {
                    durations[i][1] = durations[j][1];
                }
            }
        }

        int[] lens = new int[n];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            lens[i] = durations[i][1] - durations[i][0];
            if(lens[i] > maxLen) {
                maxLen = lens[i];
            }
        }
//        for (int[] duration: durations)
//            System.out.println(Arrays.toString(duration));
        return maxLen;
    }
}
