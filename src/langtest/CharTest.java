package langtest;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/22 11:34
 */
public class CharTest {

    public static void testIntToChar() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            System.out.println((char) n);
        }
    }

    public static void testCharsToCharacters() {
        char[] chars = {'a', 'b', 'c'};
        int[] ints = {1, 2, 3};
        Integer[] integers = Arrays.stream(ints)
                .boxed()
                .toArray(Integer[]::new);
        // ????????????????????????
    }

    public static void main(String[] args) {
        testIntToChar();
    }
}
