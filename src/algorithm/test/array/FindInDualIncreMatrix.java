package algorithm.test.array;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/8 9:12
 */
public class FindInDualIncreMatrix {

    public boolean Find(int target, int [][] array) {
        if (array == null ||
                array.length == 0 || array[0].length == 0) return false;
        int n = array.length, m = array[0].length, up = 0, right = m-1;
        if (target > array[n-1][m-1] || target < array[0][0]) return false;
        while (up < n && right >= 0) {
            if (array[up][right] == target) return true;
            else if (array[up][right] > target) right--;
            else up++;
        }
        return false;
    }
}
