package exam.shopee;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/16 15:08
 */
public class ReverseString1 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.nextLine();
            if (str.replaceAll("[^a-zA-Z]", "").equals("")) {
                System.out.println(str);
                continue;
            }
            char[] chars = str.toCharArray();
            int n = chars.length;
            int lIdx = 0, rIdx = n-1;
            while (lIdx < rIdx) {
                while (!isLetter(chars, lIdx)) lIdx++;
                while (!isLetter(chars, rIdx)) rIdx--;
                swap(chars, lIdx, rIdx);
                lIdx++; rIdx--;
            }
            System.out.println(String.valueOf(chars));
        }
    }

    public static boolean isLetter(char[] chars, int idx) {
        return  (String.valueOf(chars[idx]).matches("[a-zA-Z]"));
    }

    public static void swap(char[] chars, int idx1, int idx2) {
        char temp = chars[idx1];
        chars[idx1] = chars[idx2];
        chars[idx2] = temp;
    }
}
