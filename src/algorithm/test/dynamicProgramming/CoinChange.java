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

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {2, 5};
        int amount = 11;
        System.out.println(coinChange.coinChange(coins, amount));
    }


    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n_types = coins.length;
        if (amount == 0) return 0;
        if (n_types == 0) return -1;
        if (amount < coins[0]) return -1;

        int capacity = amount;
        int[][] dp = new int[n_types][capacity+1];
        for (int i = 0; i < n_types; i++) {
            for (int j = 1; j <= capacity; j++) {
                dp[i][j] = Integer.MAX_VALUE>>2;
            }
        }

        for (int j = 1; j <= capacity; j++) {
            for (int k = 0; k*coins[0] <= j ; k++) {
                if (k* coins[0] == j)
                    dp[0][j] = k;
            }
        }

        for (int i = 1; i < n_types; i++) {
            for (int j = 0; j <= capacity; j++) {
                for (int k = 0; k*coins[i] <= j; k++) {
                    dp[i][j] = Math.min(k+dp[i-1][j-k*coins[i]], dp[i][j]);
                }
            }
        }

        return dp[n_types-1][capacity] > amount ? -1 : dp[n_types-1][capacity];
    }
}
