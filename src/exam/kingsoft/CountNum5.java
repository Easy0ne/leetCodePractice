package exam.kingsoft;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/23 22:12
 */
public class CountNum5 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            System.out.println(count5(n));
        }
    }

    public static int count5(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n%10);
            n /= 10;
        }
        int len = sb.length(), count = 0;
        for (int i = 0; i < len; i++) {
            int count1 = 0, count2 = 0;
            for (int j = i-1; j >= 0; j--) {
                count1 = count1 * 10 + (sb.charAt(j) - '0');
            }
            for (int j = len-1; j > i; j--) {
                count2 = count2 * 10 + (sb.charAt(j) - '0');
            }
            count += count2 * Math.pow(10, i);
            if(sb.charAt(i) > '5') {
                count += Math.pow(10, i);
            } else if (sb.charAt(i) == '5') {
                count += count1 + 1;
            }
        }
        return count;
    }
}
