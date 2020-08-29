package algorithm.test.permutation;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-07-10 23:25
 */

    /*
    JZ27 字符串的排列组合
    题目描述
    输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
    输入描述:
    输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
     */
public class PermutationString {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> strList = new ArrayList<>();
        if (str != null && str.length()>0) {
            permutationHelper(str.toCharArray(), 0, strList);
            Collections.sort(strList);
        }
        return strList;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private void permutationHelper(char[] chars, int start, ArrayList<String> list) {
        if (start == chars.length - 1) {
            list.add(String.valueOf(chars));
        } else {
            Set<Character> charSet = new HashSet<Character>();
            for (int j = start; j < chars.length; j++) {
                if (!charSet.contains(chars[j])) {
                    charSet.add(chars[j]);
                    swap(chars, start, j);
                    permutationHelper(chars, start+1, list);
                    swap(chars, start, j);
                }
            }

        }
    }


    @Test
    public void test() {
        String str = "vazwz";
//        String str = "abcd";
        ArrayList<String> strList = new ArrayList<String>();
        ArrayList<String> strList2 = new ArrayList<String>();
        strList = Permutation(str);
        strList2 = Permutation2(str);
        for (int i=0; i < strList.size()-1; i++) {
            System.out.print(strList.get(i) + "\t" + strList2.get(i) + "\t" + strList.get(i).equals(strList2.get(i)));
            System.out.println();
        }
    }

    //-----------------------------------------------------------------
    /*
    字典序排列算法

    * 可参考解析： http://www.cnblogs.com/pmars/archive/2013/12/04/3458289.html  （感谢作者）
    *
    * 一个全排列可看做一个字符串，字符串可有前缀、后缀。
    * 生成给定全排列的下一个排列.所谓一个的下一个就是这一个与下一个之间没有其他的。
    * 这就要求这一个与下一个有尽可能长的共同前缀，也即变化限制在尽可能短的后缀上。
    *
    * [例]839647521是1--9的排列。1—9的排列最前面的是123456789，最后面的987654321，
    * 从右向左扫描若都是增的，就到了987654321，也就没有下一个了。否则找出第一次出现下降的位置。
    *
    * 【例】 如何得到346987521的下一个
    * 1，从尾部往前找第一个P(i-1) < P(i)的位置
    * 3 4 6 <- 9 <- 8 <- 7 <- 5 <- 2 <- 1
    * 最终找到6是第一个变小的数字，记录下6的位置i-1
    *
    * 2，从i位置往后找到最后一个大于6的数
    * 3 4 6 -> 9 -> 8 -> 7 5 2 1
    * 最终找到7的位置，记录位置为m
    *
    * 3，交换位置i-1和m的值
    * 3 4 7 9 8 6 5 2 1
    * 4，倒序i位置后的所有数据
    * 3 4 7 1 2 5 6 8 9
    * 则347125689为346987521的下一个排列
    */

    public ArrayList<String> Permutation2(String str) {
        ArrayList<String> strList = new ArrayList<String>();
        if (str == null || str.length() == 0) return strList;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        int n = chars.length;
        strList.add(String.valueOf(chars));
        while (true) {
            int lIdx = n - 2, rIdx = n - 1;
            while (lIdx > -1 && chars[lIdx] >= chars[lIdx+1])
                lIdx--;
            if (lIdx == -1) return strList;
            while (chars[rIdx] <= chars[lIdx])
                rIdx--;
            swap(chars, lIdx, rIdx);
            reverse(chars, lIdx+1, n-1);
            strList.add(String.valueOf(chars));
        }
    }

    private void reverse(char[] chars, int lIdx, int rIdx) {
        for(int i = 0; i <= ((rIdx - lIdx)>>1); i++) {
            char temp = chars[lIdx+i];
            chars[lIdx+i] = chars[rIdx-i];
            chars[rIdx-i] = temp;
        }
    }

}
