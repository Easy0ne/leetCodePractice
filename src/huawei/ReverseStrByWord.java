package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/22 11:54
 */
public class ReverseStrByWord {

    public void reverseStrByWord() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.nextLine();
            if (str.replaceAll(" ", "").equals(""))
                continue;
            String[] words = str.split(" ");
            for (int i = words.length-1; i >= 1; i--) {
                System.out.print(words[i] + " ");
            }
            System.out.println(words[0]);

        }
    }

    public void reverseStrByWord2() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.nextLine();
            str.replaceAll("![a-z|A-Z]", " ").replaceAll("(/s)*", " ");
        }
    }

    public static void main(String[] args) {
        new ReverseStrByWord().reverseStrByWord();
    }
}
