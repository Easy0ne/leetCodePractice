package algorithm.test.dynamicProgramming;

import java.util.Arrays;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/25 17:13
 */
/*
这道题也容易陷入0-1背包问题的贪心算法中，认为先用大的填n个，然后再用次大的……
但这里的坑在于，这么做可能会导致丢失可行解。
比如coins=[2,5], amount = 6;

其实是个需填满的完全背包问题，f值为硬币个数，取最小。
 */

public class CoinChange {


    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n_types = coins.length;
        if (amount == 0) return 0;
        if (n_types == 0) return -1;
        if (amount < coins[0]) return -1;
        int n_base_large = amount / coins[n_types-1];
        int capacity = amount - n_base_large * coins[n_types-1];
        int[][] f = new int[n_types][capacity+1];
        for (int i = 0; i < n_types; i++) {
            for (int j = 1; j <= capacity; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int j = 0; j <= capacity; j++) {
            for (int k = 0; k < ; k++) {

            }
        }
    }
}
