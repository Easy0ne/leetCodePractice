package algorithm.test;

import java.util.Arrays;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/3 14:45
 */
public class CountNum1 {

    public static void main(String[] args) {
        CountNum1 countNum1 = new CountNum1();
        System.out.println(countNum1.NumberOf1Between1AndN_Solution(55));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) return 0;
        int n_digits = 0, num;
        int[] nums = new int[9];
        while (n / 10 != 0) {
            num = n % 10;
            nums[n_digits++] = num;
            n = n / 10;
        }
        nums[n_digits++] = n;
        int counter = 0;
        for (int i = 0; i < n_digits-1; i++) {
            counter += (nums[n_digits-1]-1) * Math.pow(10, n_digits-2);
            int product = 1;
            for (int j = n_digits-2; j >=0 ; j--) {
                product = product * (j==i ? 1 : (nums[j]+1));
            }
            counter += product;
        }


        if (nums[n_digits-1] == 1) {
            int product = 1;
            for (int j = n_digits-2; j >=0 ; j--) {
                product = product * (nums[j]+1);
            }
            counter += product;
        } else {
            counter += Math.pow(10, n_digits-1);
        }
        return counter;
    }
}
