package exam.kingsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/23 21:45
 */
public class SubTreeWeight {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int m = cin.nextInt();
        cin.nextLine();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String line = cin.nextLine();
            String[] numStrs = line.split( " ");
            int n = numStrs.length;
            if (n == 0) {
//                System.out.println("No");
                result.add("No");
                continue;
            }
            int[] weights = new int[n];
            for (int j = 0; j < n; j++) {
                weights[j] = Integer.valueOf(numStrs[j]);
            }
            if (find(weights)) {
//                System.out.println("Yes");
                result.add("Yes");
            } else {
//                System.out.println("No");
                result.add("No");
            }
        }
        for(String str: result) {
            System.out.println(str);
        }
    }


    public static boolean find(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return false;
        }
        int[] sum = new int[n];
        for (int i = n-1; i >= (n-1)/2; i--) {
            sum[i] = nums[i];
        }
        for (int i = (n-1)/2-1; i >=0 ; i--) {
            if (sum[2*i+1] == sum[2*i+2]) {
                return true;
            }
            sum[i] = sum[2*i+1] + sum[2*i+2] + nums[i];
        }
        return false;
    }
}
