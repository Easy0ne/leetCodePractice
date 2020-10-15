package exam.dianxin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/10/15 19:15
 */
public class LongestComPrefix {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String line = cin.nextLine();
            String[] strings = line.split(",");
            if (strings.length == 0) {
                System.out.println("");
            } else {
                System.out.println(longestComPrefix(strings));
            }
        }
    }

    public static String longestComPrefix(String[] strings) {
        int n = strings.length;
        int maxLen = Arrays.stream(strings).min((x1, x2) -> x1.length() - x2.length()).get().length();
        int maxIdx = 0;
        for (int i = 0; i < maxLen; i++) {
            char ch = strings[0].charAt(i);
            boolean flag = true;
            for (int j = 1; j < n; j++) {
                if (strings[j].charAt(i) != ch) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                maxIdx = i-1;
                break;
            }
        }
        return strings[0].substring(0, maxIdx+1);
    }
}
