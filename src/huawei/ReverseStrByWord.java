package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/22 11:54
 */
public class ReverseStrByWord {

    public static void main(String[] args) {
        new ReverseStrByWord().reverseStrByWord2();
    }

    public void reverseStrByWord() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.nextLine();
            if ((str = str.replaceAll(" ", "")).equals(""))
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
            String sentence = str.replaceAll("[^a-zA-Z]", " ").replaceAll("(\\s)+", " ");
            if ((str = sentence.replaceAll(" ", "")).equals(""))
                continue;
            String[] words = sentence.split(" ");
            for (int i = words.length-1; i >= 1; i--) {
                System.out.print(words[i] + " ");
            }
            System.out.println(words[0]);
        }
    }


}
