package huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/27 14:40
 */
public class PokerScore24 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String s = cin.nextLine();
            s = s.toUpperCase();
            if (s.contains("JOKER")){
                System.out.println("ERROR");
                continue;
            }
            String[] strings = s.split(" ");
            int[] nums = new int[strings.length];
            int n_nums = strings.length;
            for (int i = 0; i < n_nums; i++) {
                if (strings[i].matches("[A-Z]")){
                    char c = strings[i].charAt(0);
                    switch (c) {
                        case 'J': nums[i] = 11; break;
                        case 'Q': nums[i] = 12; break;
                        case 'K': nums[i] = 13; break;
                        case 'A': nums[i] = 1; break;
                        default:
                            System.out.println("ERROR");
                    }
                } else {
                    nums[i] = Integer.valueOf(strings[i]);
                }
            }

            int[][] idxes = permutationIdxes(n_nums);
            Arrays.sort(nums);
            boolean flag = false;
            for (int[] sub_idxes: idxes) {
                int[] temp_nums = new int[n_nums];
                for (int i = 0; i < n_nums; i++) {
                    temp_nums[i] = nums[sub_idxes[i]];
                }
                char[] result = score24(temp_nums);
                if (result != null) {
                    System.out.print(temp_nums[0]);
                    for (int k = 1; k < n_nums; k++) {
                        System.out.print(result[k]);
                        int num_out = temp_nums[k];
                        switch (num_out) {

                            case 1:
                                System.out.print("A");
                                break;
                            case 11:
                                System.out.print("J");
                                break;
                            case 12:
                                System.out.print("Q");
                                break;
                            case 13:
                                System.out.print("K");
                                break;
                            default:
                                System.out.print(num_out);
                        }
                    }
                    flag = true;
                    break;
                }
            }
            if (!flag) System.out.println("NONE");
        }
    }


    public static char[] score24(int[] nums) {
        int capacity = 24 * 13;
        int n_types = nums.length;
        char[] ks = {'+', '-', '*', '/'};
        char[][] dp = new char[n_types][capacity+1];
        for (int i = 0; i < n_types; i++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i][j] = 'n';
            }
        }

        for (int j = 0; j <= capacity; j++) {
            if (j == nums[0])
                dp[0][j] = '+';
        }
        for (int i = 1; i < n_types; i++) {
            for (int j = 0; j <= capacity; j++) {
                for (char k: ks) {
                    if (k == '+'){
                        if (j-nums[i] < 0)
                            continue;
                        if (dp[i-1][j-nums[i]] != 'n') {
                            dp[i][j] = '+';
                            break;
                        }
                    }
                    if (k == '-') {
                        if (j+nums[i] > capacity)
                            continue;
                        if (dp[i - 1][j + nums[i]] != 'n') {
                            dp[i][j] = '-';
                            break;
                        }
                    }
                    if (k == '*' && (j%nums[i] == 0) && dp[i-1][j/nums[i]] != 'n'){
                        dp[i][j] = '*';
                        break;
                    }
                    if (k == '/') {
                        if (j * nums[i] > capacity)
                            continue;
                        if (dp[i - 1][j * nums[i]] != 'n') {
                            dp[i][j] = '/';
                            break;
                        }
                    }
                }
            }
        }

        // no solutions
        if (dp[n_types-1][24] == 'n') return null;

        char[] result = new char[4];
        int score = 24;
        for (int k = 3; k >= 0; k--) {
            result[k] = dp[k][score];
            char c = result[k];
            switch (c) {
                case '+': score-= nums[k]; break;
                case '-': score+= nums[k]; break;
                case '*': score/= nums[k]; break;
                case '/': score*= nums[k]; break;
            }
        }
        return result;
    }


    public static int[][] permutationIdxes(int n) {
        if (n == 0) return null;
        if (n == 1) return new int[][]{{1}};

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        int product = 1, n_count = n;
        while (n_count != 1) product *= n_count--;
        int[][] result = new int[product][n];

        result[0] = Arrays.copyOf(nums, n);
        int counter = 1;
        while (counter < product) {
            int idx1 = n-2;
            while (idx1 >= 0 && nums[idx1] > nums[idx1+1]) idx1--;
            if (idx1 == -1) break;

            int idx2 = n-1;
            while (nums[idx2] < nums[idx1]) idx2--;
            swap(nums, idx1, idx2);
            reverse(nums, idx1+1, n-1);
            result[counter++] = Arrays.copyOf(nums, n);
        }

        return result;
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void reverse(int[] arr, int idx1, int idx2) {
        if (idx2 < idx1) {
            System.out.println("Reverse Wrong");
            return;
        }
        int n = idx2 - idx1 + 1;
        for (int i = 0; i < n/2; i++) {
            swap(arr, idx1+i, idx2-i);
        }
    }
}
