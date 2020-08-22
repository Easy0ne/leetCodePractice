package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description: HJ6 获取质因数
 * @author: wangzk
 * @date: 2020/8/22 8:52
 */
public class PrimeNumbers {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            long n = cin.nextLong();
            List<Long> primeFactors = getAllPrimeFactors(n);
            StringBuilder stringBuilder = new StringBuilder();
            for (long factor: primeFactors)
                stringBuilder.append(factor + " ");
            System.out.println(stringBuilder);
        }
    }

    public static long firstFactor(long x) {
        for (int i = 2; i < Math.sqrt(x); i++) {
            if ( x % i == 0)
                return i;
        }
        return x;
    }


    public static List<Long> getAllPrimeFactors(Long x) {
        if(x <= 1) return null;
        List<Long> longList = new ArrayList<Long>((int)(Math.sqrt(x)/2));
        while (x != 1) {
            long firstFactor = firstFactor(x);
            longList.add(firstFactor);
            x = x / firstFactor;
        }
        return longList;
    }
}
