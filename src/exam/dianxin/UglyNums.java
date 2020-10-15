package exam.dianxin;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/10/15 19:02
 */
public class UglyNums {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int count = 1, num = 1;
            while (count < n) {
                num ++;
                if (isUglyNum(num)) {
                    count++;
                }
            }
            System.out.println(num);
        }

    }

    public static boolean isUglyNum(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        if (num == 1) return true;
        else return false;
    }
}
