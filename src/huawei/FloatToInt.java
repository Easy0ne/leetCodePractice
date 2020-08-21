package huawei;


import java.util.Scanner;
/**
 * @description: HJ7 取近似值
 * @author: wangzk
 * @date: 2020-08-11 11:45
 */
public class FloatToInt {

    public static void floatToInt() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            float num = cin.nextFloat();
            int num_int = (int) num;
            if (num - num_int >= 0.5) {
                System.out.println(num_int + 1);
            } else {
                System.out.println(num_int);
            }
        }
    }

    public static void main(String[] args) {
        floatToInt();
    }
}
