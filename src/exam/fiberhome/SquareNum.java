package exam.fiberhome;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/10/10 22:45
 */
public class SquareNum {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            System.out.println(count(n));
        }
    }

    static int[] squares = new int[68];

    static {
        int j = 0;
        for (int i = 32; i < 100; i++) {
            squares[j++] = i * i;
        }
    }

    public static int count(int num) {
        int count = 0;
        for (int i = 0; i < squares.length; i++) {
            if (countDiff(num, squares[i]) <= 2) {
                count++;
            }
        }
        return count;
    }

    public static int countDiff(int num, int num2) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int temp1 = num % 10;
            int temp2 = num2 % 10;
            if (temp1 != temp2) count++;
            num /= 10;
            num2 /= 10;
        }
        return count;
    }
}
