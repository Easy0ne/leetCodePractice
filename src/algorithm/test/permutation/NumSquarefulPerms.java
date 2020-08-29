package algorithm.test.permutation;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/28 14:48
 */
public class NumSquarefulPerms {

    public static void main(String[] args) {
        NumSquarefulPerms numSquarefulPerms = new NumSquarefulPerms();
        int[] A1 = {1,17,8};
        int[] A2 = {2,2,2};
        int[] A3 = {99,62,10,47,53,9,83,33,15,24};
        System.out.println(numSquarefulPerms.numSquarefulPerms(A3));
    }

    public int numSquarefulPerms(int[] A) {
        if (A == null || A.length <= 1) return 0;
        int n = A.length;
        Arrays.sort(A);
        int temp = (int)Math.sqrt(A[n-2] + A[n-1]);
        Set<Long> squarefulNums = new HashSet<>();
        for (int i = 0; i <= temp; i++) {
            squarefulNums.add((long)(i*i));
        }

        List<List<Integer>> permLists = permute(A);
        int counter = 0;
        for(List<Integer> permList: permLists) {
            if (checkSquareful(permList, squarefulNums))
                counter++;
        }

        return counter;
    }

    public boolean checkSquareful(List<Integer> numList, Set<Long> squarefulNums) {
        for (int i = 0; i < numList.size()-1; i++) {
            if(!squarefulNums.contains((long)(numList.get(i)+numList.get(i+1)))) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int n = nums.length;
        List<List<Integer>> itgLists = new LinkedList<>();
//        Arrays.sort(nums);
        itgLists.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        while (true) {
            int idx1 = n-2;
            while (idx1 >= 0 && nums[idx1] >= nums[idx1+1]) idx1--;
            if (idx1 == -1) break;
            int idx2 = n-1;
            while (nums[idx2] <= nums[idx1]) idx2--;
            swap(nums, idx1, idx2);
            reverse(nums, idx1+1, n-1);
            itgLists.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        return itgLists;
    }

    public void reverse(int[] nums, int idx1, int idx2) {
        int n = idx2 - idx1 + 1;
        for (int i = 0; i < n/2; i++) {
            swap(nums, idx1+i, idx2-i);
        }
    }

    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
