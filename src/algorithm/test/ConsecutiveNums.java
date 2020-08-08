package algorithm.test;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author wangzk
 * @date 2020-05-08 20:45
 */
public class ConsecutiveNums {
    public static void main(String[] args) {
        MySolution();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int L = sc.nextInt();
            boolean exist = false;
            //这里还有个坑，题目中N最大可以为 1000000000 (10亿)，而Integer.MAX_VALUE为 2147483647 (21亿多)
            //N值没有溢出，但使用公式求解时*8了，导致溢出，Math.sqrt()求得NaN，k<NaN为false
            // 从而测试用例1000000000 2输出了No
            for (int k = L; k <= (Math.sqrt(1 + 8 * (long)N) - 1) / 2 + 1 && k <= 100; k++) {
                if (k % 2 == 0 && (double) N / k - N / k == 0.5f) {
                    int quotient = N / k;
                    for (int i = -k / 2 + 1; i < k / 2; i++) {
                        System.out.print(quotient + i + " ");
                    }
                    System.out.println(quotient + k / 2);
                    exist = true;
                    break;
                }
                //这里有个坑，原先使用强转为float，543792409/57约为9540217.701754386，但543792409.0f/57得到9540217.0
                //使用double可以解决精度问题，但也不是个办法，所以，最好还是用%取余数
//                if (k % 2 == 1 && (double) N / k == N / k) {
                if (k % 2 == 1 && N % k == 0) {
                    int quotient = N / k;
                    for (int i = -k / 2; i < k / 2; i++) {
                        System.out.print(quotient + i + " ");
                    }
                    System.out.println(quotient + k / 2);
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                System.out.println("No");
            }
        }
    }



    /**
    * @Description: 牛客上的方法，使用等差数列前n项和的公式推导
    * @Param: []
    * @Return: void
    * @Author: wangzk
    * @Date: 2020/5/9
    */
    public static void MySolution() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            boolean exist = false;
            int N = sc.nextInt();
            int L = sc.nextInt();
            for (int n = L; n <= 100; n++) {
                if ( (2 * N + n - n * n) % (2 * n) == 0) {
                    int a1 = (2 * N + n - n * n) / (2 * n);
                    for (int j = 0; j < n-1; j++) {
                        System.out.print(a1 + j + " ");
                    }
                    System.out.println(a1 + n-1);
                    exist = true;
                    break;
                }
            }
            if (!exist) System.out.println("No");
        }
    }
}
