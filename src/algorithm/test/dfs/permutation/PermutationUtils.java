package algorithm.test.dfs.permutation;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:    只能说可以用，但性能不太行
 * @author: wangzk
 * @date: 2020/8/27 16:37
 */
public class PermutationUtils {

    public static void main(String[] args) {
        int[] nums = {5};
        PermutationUtils permutationUtils = new PermutationUtils();
        List<List<Integer>> result = permutationUtils.testPermuteArray(nums);
        for (List<Integer> sub_result: result)
            System.out.println(sub_result);

        String str = "abaa";
        List<String> stringResults = permutationUtils.testPermuteString(str);
        for(String oneResult: stringResults)
            System.out.println(oneResult);
    }


    /*
    使用Set<String>去重
    如果需要排序，deComment Arrays.sort(nums);
     */
    public List<List<Integer>> testPermuteArray(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int n = nums.length;
        List<List<Integer>> itgLists = new LinkedList<>();
        Set<String> stringSet = new HashSet<>();
        // Arrays.sort(nums);   //如果需要字典序的话
        int[][] idxesArr = permutationIdxes(n);
        int[] nums_temp = new int[n];
        for (int i = 0; i < idxesArr.length; i++) {
            for (int j = 0; j < n; j++) {
                nums_temp[j] = nums[idxesArr[i][j]];
            }
            List<Integer> oneResult = Arrays.stream(nums_temp).boxed().collect(Collectors.toList());
            if (!stringSet.contains(oneResult.toString())) {
                stringSet.add(oneResult.toString());
                itgLists.add(oneResult);
            }
        }

        return itgLists;
    }


    /*
    使用Set<String>去重
    如果需要排序，deComment Arrays.sort(chars);
     */
    public List<String> testPermuteString(String str) {
        if (str == null || str.length() == 0) return null;
        int n = str.length();
        List<String> stringList = new LinkedList<>();
        Set<String> stringSet = new HashSet<>();
        char[] chars = str.toCharArray();
        // Arrays.sort(chars);  //如果需要字典序的话

        char[] chars_temp = new char[n];
        int[][] idxesArr = permutationIdxes(n);
        for (int i = 0; i < idxesArr.length; i++) {
            for (int j = 0; j < n; j++) {
                chars_temp[j] = chars[idxesArr[i][j]];
            }
            String oneResult = String.valueOf(chars_temp);
            if (!stringSet.contains(oneResult)) {
                stringSet.add(oneResult);
                stringList.add(oneResult);
            }
        }

        return stringList;
    }




    /*
    以下是实现
     */

    public int[][] permutationIdxes(int n) {
        if (n == 0) return null;
        if (n == 1) return new int[][]{{0}};

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        int product = 1, n_count = n;
        while (n_count > 1) product *= n_count--;
        int[][] result = new int[product][n];

        result[0] = Arrays.copyOf(nums, n);
        int counter = 1;
        while (counter < product) {
            int idx1 = n-2;
            while (idx1 >= 0 && nums[idx1] >= nums[idx1+1]) idx1--;
            if (idx1 == -1) break;

            int idx2 = n-1;
            while (nums[idx2] <= nums[idx1]) idx2--;
            swap(nums, idx1, idx2);
            reverse(nums, idx1+1, n-1);
            result[counter++] = Arrays.copyOf(nums, n);
        }
        return result;
    }

    public void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public void reverse(int[] arr, int idx1, int idx2) {
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
