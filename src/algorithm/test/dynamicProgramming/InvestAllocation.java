package algorithm.test.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/24 16:42
 */
public class InvestAllocation {

    public static int[][] profit_max = new int[4][7];

    public static int[][] profit = new int[][] {
            {0, 20,50,65,80,85,85},
            {0, 20,40,50,55,60,65},
            {0, 25,60,85,100,110,115},
            {0, 25,40,50,60,65,70}
    };

    public static List<List<Integer>> path = new ArrayList<List<Integer>>();

    public static void func() {
        int m = 7, n = 4;
        for (int i = 0; i < m; i++) {
            profit_max[0][i] = profit[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < j; k++) {
//                    profit_max[i][j] = profit_max[i][j] > (profit[i][k] + profit_max[i-1][j-k]) ? profit_max[i][j] : (profit[i][k] + profit_max[i-1][j-k*10]);
                    profit_max[i][j] = Math.max(profit_max[i][j], profit[i][k] + profit_max[i-1][j-k]);
                }
            }
        }
        System.out.println(profit_max[n-1][m-1]);
    }

    public static void main(String[] args) {
        func();
    }
}
