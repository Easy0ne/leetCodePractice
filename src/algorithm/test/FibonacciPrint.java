package algorithm.test;

import org.junit.Test;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-06-30 09:50
 */
public class FibonacciPrint {
    private int[] fibonacciArr = new int[1000];
    public void initFibonacciArr(int maxIdx) {
        fibonacciArr[0] = 0;
        fibonacciArr[1] = 1;
        for (int i=2; i <= maxIdx; i++) {
            fibonacciArr[i] = fibonacciArr[i-1] + fibonacciArr[i-2];
        }
    }

    public void printFibonacciPyramid(int n) {
        int maxIdx = 2 * n - 1;
        initFibonacciArr(maxIdx);
        for (int i=1; i<=n; i++) {
            for (int k=0; k<n-i; k++) System.out.print("\t");
            int j=0;
            for (; j<2*i-2; j++)
                System.out.print(fibonacciArr[j] + "\t");
            System.out.println(fibonacciArr[j]);
        }
    }

    @Test
    public void testPrintFibonacciPyramid() {
        int n = 6;
        printFibonacciPyramid(6);
    }
}
