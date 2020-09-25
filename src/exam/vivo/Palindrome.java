package exam.vivo;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/12 20:32
 */
public class Palindrome {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        N:
        while (cin.hasNext()) {
            String str = cin.nextLine();
            if (str == null || str.length() == 0) {
                System.out.println("false");
                continue;
            }
            if (str.length() == 1) {
                System.out.println(str);
                continue;
            }
            int n = str.length();
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < n; i++) {
                char c = sb.charAt(i);
                if (check(sb.deleteCharAt(i))){
                    System.out.println(sb.toString());
                    continue N;
                } else {
                    sb.insert(i, c);
                }
            }
            System.out.println("false");
        }
    }

    public static boolean check(StringBuilder str){
        for (int i = 0; i <= str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
