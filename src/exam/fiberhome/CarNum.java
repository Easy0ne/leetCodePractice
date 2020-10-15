package exam.fiberhome;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/10/10 22:19
 */
public class CarNum {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        List<Integer> suffixes = new ArrayList<>();
        String string = cin.nextLine();
        String[] strs = string.split(" ");
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            count += countNum(Integer.valueOf(strs[i]));
        }
        System.out.println(count);
    }

    public static int countNum(int suffix) {
        if (suffix != 4) {
            return (int)(Math.pow(35, 4)) - ((int)Math.pow(35, 2) * 3 - 35 * 2);
        } else {
            return (int)(Math.pow(35, 4)) - ((int)Math.pow(35, 2) * 2 - 35 + (int) Math.pow(35, 3) - 35 * 2);
        }
    }
}
