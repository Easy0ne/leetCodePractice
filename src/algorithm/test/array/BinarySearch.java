package algorithm.test.array;

import org.junit.Test;

/**
 * @description:
 * @author: wangzk
 * @date: 2020-07-14 16:04
 */
public class BinarySearch {

    /*
    参考[算法面试题——二分查找套路法](https://zhuanlan.zhihu.com/p/97491967)
     */

    // #1.最基本的二分查找
    /*
    leetcode 704
    给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

    示例 1:
    输入: nums = [-1,0,3,5,9,12], target = 9
    输出: 4
    解释: 9 出现在 nums 中并且下标为 4

    示例 2:
    输入: nums = [-1,0,3,5,9,12], target = 2
    输出: -1
    解释: 2 不存在 nums 中因此返回 -1
     */
    public int binarySearchBasicRecur(int[] arr, int target) {
        int n = arr.length;
        return binarySearchBasicRecurHelper(0, n-1, arr, 2);
    }

    private int binarySearchBasicRecurHelper(int left, int right, int[] arr, int target) {
        if (left > right) return -1;
        if(left == right && arr[left] != arr[right]) return -1;

        int mid = (left + right) / 2;
        if (arr[mid] == target) return mid;
        else if (target < arr[mid]) return binarySearchBasicRecurHelper(left, mid - 1, arr, target);
        else return binarySearchBasicRecurHelper(mid + 1, right, arr, target);
    }

    public int binarySearchBasic(int[] arr, int target) {
        int n = arr.length;
        int left = 0, right = n-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }

    @Test
    public void testBinarySearchBasic() {
        int[] arr = {-1,0,3,5,9,12};
        System.out.println(binarySearchBasicRecur(arr, 2));
    }


    // #2.找到比target大的最小元素
    /*
    LeetCode 744：寻找比目标字母大的最小字母
    给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。

    数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。

    示例:
    输入:
    letters = ["c", "f", "j"]
    target = "a"
    输出: "c"

    输入:
    letters = ["c", "f", "j"]
    target = "c"
    输出: "f"

    输入:
    letters = ["c", "f", "j"]
    target = "d"
    输出: "f"

    输入:
    letters = ["c", "f", "j"]
    target = "g"
    输出: "j"

    输入:
    letters = ["c", "f", "j"]
    target = "j"
    输出: "c"

    输入:
    letters = ["c", "f", "j"]
    target = "k"
    输出: "c"

    注:
    letters长度范围在[2, 10000]区间内。
    letters 仅由小写字母组成，最少包含两个不同的字母。
    目标字母target 是一个小写字母。
     */

    public int nextGreaterLetter(char[] letters, char target) {
        int left = 0, right = letters.length-1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            char midLetter = letters[mid];
            if (midLetter > target) right = mid - 1;
            else left = mid + 1;
        }
        return left > letters.length-1 ? 0 : left;
    }

    @Test
    public void testNextGreaterLetter() {
        char[] letters = "accf".toCharArray();
        System.out.println(nextGreaterLetter(letters, 'b'));
    }

    // #3.找到比target小的最大元素
    /*
    LeetCode 69: x的平方根
    实现 int sqrt(int x) 函数。

    计算并返回 x 的平方根，其中 x 是非负整数。
    由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

    示例 1:
    输入: 4
    输出: 2

    示例 2:
    输入: 8
    输出: 2
    说明: 8 的平方根是 2.82842...,
         由于返回类型是整数，小数部分将被舍去。
     */

    public int lessSqrt(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int midSqr = mid * mid;
            if (midSqr == x) return mid;
            if (midSqr > x) right = mid -1;
            else left = mid + 1;
        }
        return right;
    }

    @Test
    public void testLessSqrt() {
        System.out.println(lessSqrt(37));
        System.out.println(lessSqrt(36));
        System.out.println(lessSqrt(1));
    }

    // #3. 寻找第一个等于target的元素
    /* Leetcode 278：第一个错误的版本
    你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。

    假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。

    你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

    示例:

    给定 n = 5，并且 version = 4 是第一个错误的版本。
    调用 isBadVersion(3) -> false
    调用 isBadVersion(5) -> true
    调用 isBadVersion(4) -> true

    所以，4 是第一个错误的版本。
     */
    private boolean isBadVersion(int x) {
        return x>=23;
    }
    public int firstBadVersion(int n) {
        int left = 0, right = n;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            boolean isBadMid = isBadVersion(mid);
            if(isBadMid) right = mid - 1; // means >=
            else left = mid + 1;
        }
        return left;
    }

    @Test
    public void testFirstBadVersion() {
        System.out.println(firstBadVersion(250));
    }

    // 4. 寻找最后一个等于target的元素
    /*
    以基础二分查找题为例
     */
    public int lastTarget(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int midValue = arr[mid];
            if (arr[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
}
