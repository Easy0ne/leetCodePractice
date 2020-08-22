package huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/22 10:29
 */
public class ReverseDedupOfInt {

    public static void main(String[] args) {
//        reverseOfInt();
        reverseOfInt2();
    }

    public static void reverseOfInt() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int x_origin = cin.nextInt();
            if (x_origin == 0) {
                System.out.println(0);
                continue;
            }
            int x = Math.abs(x_origin);
            boolean[] flags = new boolean[10];
            int sum = 0;
            while (x != 0) {
                int remainder = x % 10;
                if(!flags[remainder]) {
                    sum = sum * 10 + remainder;
                    flags[remainder] = true;
                }
                x = x / 10;
            }
            if(x_origin % 10 == 0){
                System.out.println("0" + sum);
            } else {
                System.out.println(sum);
            }
        }
    }

    public static void reverseOfInt2() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            StringBuilder stringBuilder = new StringBuilder(cin.nextLine());
            String reversedStr = stringBuilder.reverse().toString();
            LinkedHashSet<Character> characters = reversedStr.chars()
                    .mapToObj(x -> (char) x)
                    .collect(Collectors.toCollection(LinkedHashSet::new));
            characters.forEach(System.out::print);
            System.out.println();
        }
    }

}
