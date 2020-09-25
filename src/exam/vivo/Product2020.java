package exam.vivo;

import java.util.Arrays;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/12 20:05
 */
public class Product2020 {

    public static void main(String[] args) {
        Product2020 product2020 = new Product2020();
        product2020.solution(15);
    }
    public int solution (int n) {
        // write code here
        int count = 1;
        int[] nums = new int[n+1];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < count; j++) {
                nums[i+j] = count;
                System.out.println(String.format("%d %d %d %d", i, j, count, nums[i]));
            }
            i = i+count-1;
            count++;
        }

        System.out.println(Arrays.toString(nums));
        return Arrays.stream(nums).sum();
    }
}
