package algorithm.test.array;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-07-22 22:35
 */

/*
输入n个整数，找出其中最小的K个数。
例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

 */
public class KLeastNums {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        if (input == null || input.length < k || k <= 0) return intList;
        int n = input.length;
        for (int i=((n-2)>>1); i>=0; i--) {
            minHeapify(input, i, n-1);
        }
        for (int j=n-1; j>=n-k; j--) {
            swap(input, 0, j);
            minHeapify(input, 0, j-1);
            intList.add(input[j]);
        }
        return intList;
    }

    private void minHeapify(int[] arr, int sIdx, int eIdx) {
        int minIdx = sIdx, lIdx = sIdx*2+1, rIdx = sIdx*2+2;
        if (lIdx <= eIdx && arr[lIdx] < arr[minIdx]) minIdx = lIdx;
        if (rIdx <= eIdx && arr[rIdx] < arr[minIdx]) minIdx = rIdx;
        if (minIdx != sIdx) {
            swap(arr, sIdx, minIdx);
            minHeapify(arr, minIdx, eIdx);
        }
    }

    private void swap(int[] input, int idx1, int idx2) {
        int temp = input[idx1];
        input[idx1] = input[idx2];
        input[idx2] = temp;
    }


    @Test
    public void test() {
        int[] arr = {4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(arr, 4));
    }
}
