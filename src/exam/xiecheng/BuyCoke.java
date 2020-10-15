package exam.xiecheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/10/13 11:08
 */
public class BuyCoke {

    static int buyCoke(int m, int a, int b, int c, int x) {
        int have = 0, count = 0;
        int[] left = {c, b, a};
        int[] value = {100, 50, 10};
        while (have < m) {
            int pay = 0;
            for (int i = 0; i < 3; i++) {
                if (x > pay) {
                    int need = (int) Math.ceil((float)(x-pay) / value[i]);
                    int n = need > left[i] ? left[i] : need;
                    left[i] = left[i] - n;
                    pay += n * value[i];
                    count += n;
                } else if (x < pay) {
                    int over = pay - x;
                    for (int j = 1; j < 3; j++) {
                        int d = over / value[j];
                        left[j] += d;
                        over -= d * value[j];
                        pay -= d * value[j];
                    }
                    break;
                }
            }
            have += 1;
        }
        return count;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        int _b;
        _b = Integer.parseInt(in.nextLine().trim());

        int _c;
        _c = Integer.parseInt(in.nextLine().trim());

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = buyCoke(_m, _a, _b, _c, _x);
        System.out.println(String.valueOf(res));

    }
}
