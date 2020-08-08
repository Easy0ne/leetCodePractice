package algorithm.test.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-06-18 23:37
 */
public class VerifySequenceOfBST {
    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return verifySubSequence_opt(sequence, 0, sequence.length-1);
    }

    public boolean verifySubSequence(int[] sequence) {
        int n = sequence.length;
        if (n == 0 || n == 1) {
            return true;
        }
        int pivot = n-2;
        for (; pivot >= 0; pivot--) {
            if (sequence[pivot] < sequence[n-1])
                break;
        }
        boolean flag = true;
        for (int i=pivot; i >=0; i--) {
            if (sequence[i] > sequence[n-1])
                flag = false;
        }
        int[] rightSequence = Arrays.copyOfRange(sequence, pivot+1, n-1);
        int[] leftSequence = Arrays.copyOfRange(sequence, 0, pivot+1);
        return flag && verifySubSequence(leftSequence) && verifySubSequence(rightSequence);
    }

    public boolean verifySubSequence_opt(int[] sequence, int start, int end) {
        if (start >= end || start == end -1) return true;
        int pivot = end - 1;
        for(; pivot >= start; pivot--)
            if (sequence[pivot] < sequence[end])
                break;
        for(int i = pivot; i >= start; i--)
            if (sequence[i] > sequence[end])
                return false;
        return verifySubSequence_opt(sequence, start, pivot) && verifySubSequence_opt(sequence, pivot+1, end-1);
    }

    @Test
    public void test() {
        int[] seq = {1,3,2,9,8,4,5};
        int[] seq1 = {9,8};
        int[] seq2 = {1,9,5,10,12,8};
        System.out.println(verifySequenceOfBST(seq2));
    }
}
