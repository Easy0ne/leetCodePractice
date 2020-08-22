package huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @description: HJ10 字符个数统计
 * @author: wangzk
 * @date: 2020/8/22 11:41
 */
public class CountRangedChar {

    public static void countRangedChar() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.nextLine();
            HashSet<Character> characterHashSet = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (0 <= c && c <= 127) {
                    characterHashSet.add(c);
                }
            }
            System.out.println(characterHashSet.size());
        }
    }

    public static void main(String[] args) {
        countRangedChar();
    }
}
