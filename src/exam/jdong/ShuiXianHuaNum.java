package exam.jdong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/17 18:15
 */
public class ShuiXianHuaNum {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int num1 = cin.nextInt();
            int num2 = cin.nextInt();
            List<Integer> results = new ArrayList<>();
            boolean flag = false;
            for (int i = num1; i <= num2; i++) {
                if (isShuixianhua(i)) {
                    flag = true;
                    results.add(i);
                }
            }
            if (!flag) {
                System.out.println("no");
            } else {
                String out = results.stream().map(String::valueOf).collect(Collectors.joining(" "));
                System.out.println(out);
            }
        }
    }

    public static boolean isShuixianhua(int num) {
        int sum = 0, temp = num;
        int m;
        while (num > 0) {
            sum += Math.pow((num % 10), 3);
            num /= 10;
        }
        return sum == temp;
    }
}
