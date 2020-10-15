package exam.vipkid;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/30 20:17
 */
public class ParseChineseNumber {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.nextLine();

        }
    }

    public static String parseChineseNumber(String s) {
        String[] strs;
        StringBuilder result = new StringBuilder();
        if (s.length() == 3 && parseWord(s.charAt(0)) != -1 && parseWord(s.charAt(2)) != -1) {
            result.append(parseWord(s.charAt(0))).append(s.charAt(2));
            if (s.charAt(1) == '万') {
                result.append(0).append(0).append(0);
            } else if (s.charAt(1) == '千') {
                result.append(0).append(0);
            } else if (s.charAt(1) == '百') {
                result.append(0);
            } else if (s.charAt(1) == '十') {

            }
            return result.toString();
        }
        return "";
    }

    public static int parseWord(char s) {
        switch (s) {
            case '一':
                return 1;
            case '二':
                return 2;
            case '三':
                return 3;
            case '四':
                return 4;
            case '五':
                return 5;
            case '六':
                return 6;
            case '七':
                return 7;
            case '八':
                return 8;
            case '九':
                return 9;
            case '零':
                return 0;
            default:
                return -1;
        }
    }
}
