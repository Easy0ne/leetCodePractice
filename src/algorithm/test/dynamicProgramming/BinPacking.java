package algorithm.test.dynamicProgramming;

import huawei.BinPack;
import org.omg.CORBA.MARSHAL;

import java.util.Arrays;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/25 8:46
 */
public class BinPacking {


    public static void main(String[] args) {
        int n = 4;
        int[] w = {2, 3, 5, 5};
        int[] v = {2, 4, 3, 7};
        int capacity = 10;
        BinPacking binPacking = new BinPacking();
        System.out.println(binPacking.binPackOf01(w, v, n, capacity));
        System.out.println(binPacking.binPackOfComplete(w, v, n, capacity));
        int[] nums1 = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 3, 5};
        System.out.println(binPacking.canPartition(nums1));

    }


    // 0-1背包问题
    public int binPackOf01(int[] w, int[] v, int n_types, int capacity) {
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
        for(int[] f_i: f)
            System.out.println(Arrays.toString(f_i));
        return f[n_types-1][capacity];
    }


    // 完全背包问题
    public int binPackOfComplete(int[] w, int[] v, int n_types, int capacity) {
        int[][] f = new int[n_types][capacity+1];
        for (int j = 0; j <= capacity; j++) {
            f[0][j] = j/w[0] * v[0];
        }
        for (int i = 1; i < n_types; i++) {
            for (int j = 0; j <= capacity; j++) {
                // for (int k = 0; k*w[i] < j && k <= n[i]; k++) {  多重背包问题就是再加个k的限制
                //其实0-1背包是完全背包的特例，完全背包是多重背包的特例，所以多重背包的代码可以代替完全和0-1，
                // 这里的完全背包也可以运行0-1背包，只需限制k取0/1即可。
                for (int k = 0; k*w[i] < j; k++) {
                    f[i][j] = Math.max(f[i][j], k*v[i]+f[i-1][j-k*w[i]]);
                }
            }
        }
        for(int[] f_i: f)
            System.out.println(Arrays.toString(f_i));
        return f[n_types-1][capacity];
    }


    // 恰好装满的完全背包问题
    // leetcode 416. 分割等和子集
    public boolean canPartition(int[] nums) {
        int n_types = nums.length;
        int sum = Arrays.stream(nums).sum() / 2;
        int[] w = nums;
        //对于恰好装满的背包问题，默认的f值应该为-INF(除capacity为0外)，因为默认情况是什么都不装，而此时的装法并不是一个解。
        //用此值来标注，使用了该子路径的路径也是不合理的，应当也标为-INF
        //否则，在比较max的时候，会把f[i][j]值为0对应的装法当作可行解。
        // 动态填表部分不变(递推关系是一样的)。
        int[][] f = new int[n_types][sum+1];
        for (int i = 0; i < n_types; i++) {
            for (int j = 1; j <= sum; j++) {
                f[i][j] = Integer.MIN_VALUE;
            }
        }

        int[][] kss = new int[n_types][sum+1];   //记录每个子问题的最后一个“物品”的个数k
        for (int j = 0; j <= sum; j++) {
            for (int k = 0; k*w[0] <= j && k <= 1; k++) {
                if (k * w[0] == j){
                    f[0][j] = k;
                    kss[0][j] = k;
                }
            }
        }
        for (int i = 1; i < n_types; i++) {
            for (int j = 0; j <= sum; j++) {
                int k_final = 0;
                for (int k = 0; k * w[i] <= j && k <= 1; k++) {
//                    f[i][j] = Math.max(f[i][j], 1 + f[i-1][j-k*w[i]]);
                    if(f[i][j] < k*1 + f[i-1][j-k*w[i]]){
                        f[i][j] = k*1 + f[i-1][j-k*w[i]];
                        k_final = k;
                    }
                }
                kss[i][j] = k_final;
            }
        }
        for (int[] ks : kss)
            System.out.println(Arrays.toString(ks));

        //路径 - 给出最优方案(不是针对装满背包问题)
        int j = sum;
        for (int i = n_types-1; i >=0 ; i--) {
            System.out.println(String.format("%d + nums[%d] ->  %d", nums[i], i, kss[i][j]));
            j = j - kss[i][j] * nums[i];
        }
        return (f[n_types-1][sum] > 0);
    }


    // 恰好装满的背包问题、求方法数
    // leetcode 494. 目标和

    //背包问题的变种问题中，除了递推公式，边界值一定要设置正确。
}
