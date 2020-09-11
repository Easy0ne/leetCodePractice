package exam.tencent;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/5 19:09
 */
public class UnzipString {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.nextLine();
            System.out.println(deZip(str));
        }
    }

    public static String deZip(String str) {
        if (str == null || str.equals("")) return "";
        if (!str.contains("|") || !str.contains("[") || !str.contains("]")) {
            return str;
        }
        int firstBracketIdx = str.indexOf("[");
        int lastBracketIdx = str.lastIndexOf("]");
        int shuIdx = str.indexOf("|");
        String prefix = str.substring(0, firstBracketIdx);
        String numStr = str.substring(firstBracketIdx+1, shuIdx);
        String zipStr = str.substring(shuIdx+1, lastBracketIdx);
        String suffix = str.substring(lastBracketIdx+1);

        int n = Integer.valueOf(numStr);
        String deZippedStr = deZip(zipStr);
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        for (int i = 0; i < n; i++) {
            sb.append(deZippedStr);
        }
        sb.append(suffix);
        return sb.toString();
    }
}
