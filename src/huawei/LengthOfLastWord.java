package huawei;

import java.util.Scanner;

/**
 * @description:    HJ1 字符串最后一个单词长度
 * @author: wangzk
 * @date: 2020/8/11 20:16
 */
public class LengthOfLastWord {

    public static void lengthOfLastWord() {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()) {
            String str = cin.nextLine();
            String[] words = str.split(" ");
            System.out.println(words[words.length - 1].length());
        }
    }

    public static void main(String[] args) {
        lengthOfLastWord();
    }
}
