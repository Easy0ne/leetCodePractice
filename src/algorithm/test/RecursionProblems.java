package algorithm.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-07-02 09:31
 */
public class RecursionProblems {

    /*
    * 编写一个方法用于验证指定的字符串是否为反转字符，返回true和false。
    * 我们只写递归部分
    */
    public boolean isReversedStr(char[] str, int start, int end) {
        if (start>=end) return true;
        return (str[start] == str[end]) && isReversedStr(str, start+1, end-1);
    }
    @Test
    public void testIsReversedStr() {
        char[] str = "ava".toCharArray();
        System.out.println(isReversedStr(str, 0, str.length-1));
        str = "aa".toCharArray();
        System.out.println(isReversedStr(str, 0, str.length-1));
        str = "avva".toCharArray();
        System.out.println(isReversedStr(str, 0, str.length-1));

    }


    /*
    一列数的规则如下: 1、1、2、3、5、8、13、21、34...... 求第30个是多少
     */
    public int fibonacci(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    @Test
    public void testFibonacci() {
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(6));
    }


    /*
    一列数的规则如下: 1、12、123、1234、12345、123456......,求第n个数的递归算法（n<=9）。
     */
    public int nNums(int n) {
        return n == 1 ? 1 : nNums(n - 1) * 10 + n;
    }
    @Test
    public void testNNums() {
        for (int i = 1; i <= 9; i++) System.out.println(nNums(i));
    }


    /*
    !!!!!!!!!!!
    将一整数逆序，如987654321变为123456789。
    这种做法比较有意思
     */
    private int n = 1;
    public long reverseLong(long x) {
        return x<10 ? x : reverseLong(x/10) + (x % 10) * (n *= 10);
    }
    @Test
    public void testReverseLong() {
        System.out.println(reverseLong(987654));
    }


    /*
    一个射击运动员打靶,靶一共有10环,连开10枪打中90环的可能行有多少种?
     */
    public int countCombinations(int n, int m) {
        // 出口
        if (n == 1) {
            if (0 < m && m <= 10)
                return 1;
            else
                return 0;
        }
        //
        if (n * 10 < m || m < 0) return 0;
        if (n * 10 == m) return 1;
        // 核心
        int count = 0;
        for (int i = 0; i <= 10 ; i++) count += countCombinations(n-1, m-i);
        return count;
    }
    @Test
    public void testCountCombinations() {
        System.out.println(countCombinations(10, 90));
    }



    /*
    ！！！
    思考
    以上几个问题求解的(或者说方法的返回值)是一个值而不是一个数组/链表，或者有的不是通过返回值的方式，而是在给定输入的空间上进行修改，这时，返回值和内层递归之间就不是简单的加减关系了。
    因此，需要思考如何完成与内层递归之间的协作。
    以题“1、12、123、1234、12345、123456.....”为例，求前n个数，思考 递归中是否应该使用全局变量(类的成员变量)？
     */

    /*
    第一种方法，使用全局变量
     */
    private ArrayList<Long> evenList = new ArrayList<Long>();
    public ArrayList<Long> getEvens(int n) {
        if(n < 1) return evenList;
        getEvenSub(n);
        return evenList;
    }
    private Long getEvenSub(int n) {
        if (n == 1) {
            evenList.add(1L);
            return 1L;
        }
        Long nthNum = getEvenSub(n-1) * 10 + n;
        evenList.add(nthNum);
        return nthNum;
    }


    /*
    第二种，用局部变量，但在外层方法中创建好供内部递归共享(其实差不多)。
     */
    public ArrayList<Long> getEvens1(int n) {
        ArrayList<Long> evenList1 = new ArrayList<Long>();
        if(n < 1) return evenList1;
        getEvenSub1(evenList1, n);
        return evenList;
    }
    private Long getEvenSub1(ArrayList<Long> evenList1, int n) {
        if (n == 1) {
            evenList1.add(1L);
            return 1L;
        }
        Long nthNum = getEvenSub1(evenList1, n-1) * 10 + n;
        evenList1.add(nthNum);
        return nthNum;
    }

    @Test
    public void testGetEvens() {
        System.out.println(getEvens(5));
    }
}
