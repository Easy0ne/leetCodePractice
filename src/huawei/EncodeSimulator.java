package huawei;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/2 10:10
 */
public class EncodeSimulator {

    private int n_bits = 32;

    public static void main(String[] args) {
        EncodeSimulator encodeSimulator = new EncodeSimulator();
        encodeSimulator.encode();
    }

    private void encode() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = cin.nextInt();
            }

            int[][] bitsArr = new int[n][32];
            for (int i = 0; i < n; i++) {
//                numBits[i] = Integer.toBinaryString(arr[i]).chars().map(x -> x=='0' ? 0 : 1).toArray();
                bitsArr[i] = toBinaryArr(arr[i]);
                stepA(bitsArr[i]);
            }
            stepB(bitsArr);
            for (int i = 0; i < n; i++) {
                System.out.println(toDecimal(bitsArr[i]));
            }
        }
    }

    private int[] toBinaryArr(int num) {
        int[] bits = new int[n_bits];
        for (int i = n_bits-1; i >=0 ; i--) {
            bits[i] = (num & 1);
            num = num >> 1;
        }
        return bits;
    }

    private long toDecimal(int[] bits) {
        char[] chars = new char[n_bits];
        for (int i = 0; i < n_bits; i++) {
            chars[i] = bits[i] == 0 ? '0' : '1';
        }
        return Long.valueOf(String.valueOf(chars), 2);
    }

    private void stepA(int[] bits) {
        for (int i = 0; i < n_bits-1; i+=2) {
            swap(bits, i, i+1);
        }
    }

    private void stepB(int[][] bitsArr) {
        int n_nums = bitsArr.length;
        int[][] overflow = new int[n_nums][2];
        overflow[0][1] = bitsArr[0][n_bits-1];
        overflow[0][0] = bitsArr[0][n_bits-2];
        for (int j = 2; j < n_bits; j++) {
            bitsArr[0][j] = bitsArr[0][j-2];
        }
        for (int i = 1; i < n_nums; i++) {
            overflow[i][1] = bitsArr[i][n_bits-1];
            overflow[i][0] = bitsArr[i][n_bits-2];
            for (int j = 2; j < n_bits; j++) {
                bitsArr[i][j] = bitsArr[i][j-2];
            }
            bitsArr[i][0] = overflow[i-1][0];
            bitsArr[i][1] = overflow[i-1][1];
        }
        bitsArr[0][0] = overflow[n_nums-1][0];
        bitsArr[0][1] = overflow[n_nums-1][1];
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    @Test
    public void testSubFunc() {
        EncodeSimulator encodeSimulator = new EncodeSimulator();
        int[] bits = encodeSimulator.toBinaryArr(5);
        System.out.println(Arrays.toString(bits));
    }
}
