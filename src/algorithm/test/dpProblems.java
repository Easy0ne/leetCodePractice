package algorithm.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-07-17 13:53
 */
public class dpProblems {

    /*
    LeetCode 53
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    示例:
    输入: [-2,1,-3,4,-1,2,1,-5,4],
    输出: 6
    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    public int maxSumOfSubSerials(int[] arr) {  //带有路径的
        int n = arr.length;
        if (n == 1) return arr[0];
        int[] optm = new int[n];
        HashMap<Integer, ArrayList<Integer>> pathMap = new HashMap<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        pathMap.put(0, path);
        optm[0] = arr[0];
        int newOptm = 0;
        for (int i = 1; i < n; i++) {
            if ((newOptm = arr[i] + optm[i-1]) > arr[i]) {  //以arr[i]结尾的最佳路径
                path = new ArrayList<>(pathMap.get(i-1));
                path.add(i);
                pathMap.put(i, path);
                optm[i] = newOptm;
            } else {
                path = new ArrayList<>();
                path.add(i);
                pathMap.put(i, path);
                optm[i] = arr[i];
            }
        }
        int optmSum = optm[0];
        ArrayList<Integer> optmPath = pathMap.get(0);
        for (int i = 1; i < n; i++) {
            if (optm[i] > optmSum) {
                optmSum = optm[i];
                optmPath = pathMap.get(i);
            }
        }
        for (int i : optmPath) {
            System.out.print(arr[i]+ "\t");
        }
        System.out.println();
        return optmSum;
    }

    @Test
    public void testMaxSumOfSubSerials() {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSumOfSubSerials_Better(arr));
    }

    public int maxSumOfSubSerials_Better(int[] arr) {
        int preMax = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preMax = Math.max(arr[i], arr[i] + preMax);
            max = Math.max(preMax, max);
        }
        return max;
    }

    /*
    LeetCode 121
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
    注意你不能在买入股票前卖出股票。

    示例 1:
    输入: [7,1,5,3,6,4]
    输出: 5
    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
         注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

    示例 2:
    输入: [7,6,4,3,1]
    输出: 0
    解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    public int maxProfit(int[] price) {
        int n = price.length;
        if (n == 1) return 0;
        int[] maxProfit = new int[n];
        maxProfit[0] = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            maxProfit[i] = Math.max(maxProfit[i-1] + price[i] - price[i-1], 0); //第i天卖出可以获得的最大profit
            max = Math.max(maxProfit[i], max);
        }
        return max;
    }

    @Test
    public void testMaxProfit(dpProblems dp) {
        int[] price = {7,1,5,3,6,4};
        int[] price1 = {7,6,4,3,1};
        System.out.println(maxProfit(price1));

    }
}
