package exam.jdong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/17 17:48
 */
public class ShulieSum {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            double n = cin.nextDouble();
            int m = cin.nextInt();
            double result = shulieSum(n, m);
            System.out.println(String.format("%.2f", result));
        }
        /*List<Double> results = new ArrayList<>();
        List<Double> ns = new ArrayList<>();
        List<Integer> ms = new ArrayList<>();
        while (cin.hasNext()) {
            ns.add(cin.nextDouble());
            ms.add(cin.nextInt());
        }
        for (int i = 0; i < ns.size(); i++) {
            results.add(shulieSum(ns.get(i), ms.get(i)));
        }
        for (double result: results) {
            System.out.println(result);
        }*/

    }

    public static double shulieSum(double n, int m) {
        if(n <= 0) return 0;
        double sum = 0;
        for (int i = 0; i < m; i++) {
            sum += n;
            n = Math.sqrt(n);
        }
        return sum;
    }
}
