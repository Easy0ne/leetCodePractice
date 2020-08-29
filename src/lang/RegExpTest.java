package lang;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/29 20:22
 */
public class RegExpTest {

    public static void main(String[] args) {
        RegExpTest regExpTest = new RegExpTest();
        regExpTest.regExpTest();
    }

    public void regExpTest() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.nextLine();
            String[] nums = str.split("[+|-|*|/]");
            for(String num: nums)
                System.out.println(num);
        }
    }
}
