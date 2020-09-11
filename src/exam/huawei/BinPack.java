package exam.huawei;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/2 19:58
 */
public class BinPack {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int K = cin.nextInt();
            int N = cin.nextInt();
            int[] w = new int[N];
            for (int i = 0; i < N; i++) {
                w[i] = cin.nextInt();
            }
            int[] v = new int[N];
            for (int i = 0; i < N; i++) {
                v[i] = cin.nextInt();
            }
            int maxV = binPackOf01(w, v, N, K);
            System.out.println(maxV);
        }
    }


    public static int binPackOf01(int[] w, int[] v, int N, int capacity) {
        int n_types = Math.min(Math.min(w.length, v.length), N);
        int[][] f = new int[n_types][capacity+1];
        for (int j = 0; j <= capacity; j++) {
            f[0][j] = j < w[0] ? 0 : v[0];
        }
        for (int i = 1; i < n_types; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (w[i] > j) {
                    f[i][j] = f[i-1][j];
                } else {
                    f[i][j] = Math.max(f[i-1][j], v[i]+f[i-1][j-w[i]]);
                }
            }
        }
//        for(int[] f_i: f)
//            System.out.println(Arrays.toString(f_i));
        return f[n_types-1][capacity];
    }
}
