package algorithm.test.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:    leetCode 54. 螺旋矩阵
 * @author: wangzk
 * @date: 2020/8/27 9:13
 */
public class SpiralOrderOfMatrix {

    public static void main(String[] args) {
        Random random = new Random();
        int m = 4, n = 3;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = random.ints(n, 0, 100).toArray();
        }
        for (int[] sub_matrix : matrix)
            System.out.println(Arrays.toString(sub_matrix));

        SpiralOrderOfMatrix spiralOrderOfMatrix = new SpiralOrderOfMatrix();
        System.out.println("\n" + spiralOrderOfMatrix.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> integerList = new LinkedList<>();
        if (matrix == null || matrix.length == 0) return integerList;

        int m = matrix.length, n = matrix[0].length;
        int up = 0, down = m-1, left = 0, right = n-1;
        while (true) {
            for (int i = left; i <= right; i++) integerList.add(matrix[up][i]);
            if (++up > down) break;
            for (int i = up; i <= down; i++) integerList.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i >= left; i--) integerList.add(matrix[down][i]);
            if (--down < up) break;
            for (int i = down; i >= up; i--) integerList.add(matrix[i][left]);
            if (++left > right) break;
        }
        return integerList;
    }
}
