package huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:    HJ16 购物单 ################
 * @author: wangzk
 * @date: 2020/8/24 18:43
 */
public class BinPack {

    //这样做就成了嵌套的背包问题了，或者里层的背包(只有四种情况)用枚举，但还是很复杂。
    /*public static void func() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int N = cin.nextInt();
            int n = N / 10;
            int m = cin.nextInt();
            int[][] data = new int[m][3];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 3; j++) {
                    data[i][j] = cin.nextInt();
                }
            }
            int count_main = 0;
            int[] mainIdxes = new int[m];
            HashMap<Integer, List<Integer>> idxesAttachedToMain = new HashMap<>(m);
            for (int i = 0; i < m; i++) {
                int p = data[i][2];
                if (p == 0) {
                    mainIdxes[count_main] = i;
                    count_main +=1;
                } else {

                    if (idxesAttachedToMain.get(p) == null) {
                        idxesAttachedToMain.put(p, new ArrayList<>());
                    }
                    idxesAttachedToMain.get(p).add(i);
                }
            }

            int[][] profit_max = new int[count_main][n];

            for (int i = 0; i < n; i++) {
                int mainIdx = mainIdxes[0];
                if (data[mainIdx][0] > n*10) {
                    profit_max[0][n] = 0;
                    continue;
                } else {
                    profit_max[0][n] += data[mainIdx][0] * data[mainIdx][1];
                    if (idxesAttachedToMain.get(mainIdx) != null) {
                        for (Integer idx: idxesAttachedToMain.get(mainIdx)) {
                            if ()
                        }
                    }
                }
            }

        }
    }*/

    /*巧妙点在于，可以将其转换成普通的0-1背包问题。
    比如
    1000 5
    800 2 0
    400 5 1
    300 5 1
    400 3 0
    500 2 0
    第一件主商品及其两件附属品可以演变成
    800 2
    1200 7
    1100 7
    1500 12
     */
    public static void binPack() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int N = cin.nextInt();
            int m = cin.nextInt();
            int[][] data = new int[m][3];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 3; j++) {
                    data[i][j] = cin.nextInt();
                }
            }
        }
    }

}
