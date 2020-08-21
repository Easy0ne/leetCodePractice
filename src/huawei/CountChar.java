package huawei;

import java.util.Scanner;

/**
 * @description:    HJ2 计算字符个数
 * @author: wangzk
 * @date: 2020/8/19 19:29
 */
public class CountChar {
    public static void countChar() {
        Scanner sin = new Scanner(System.in);
        while (sin.hasNext()) {
            String str = sin.nextLine().toLowerCase();
            char c = sin.nextLine().toLowerCase().charAt(0);
            if(str == "" || str == " ") {
                System.out.println(0);
                continue;
            }
            int count = 0;
            for(int i = 0; i < str.length(); i++) {
                if(c == str.charAt(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        countChar();
    }
}
