package algorithm.test.array;

import java.util.Arrays;

/**
 * @description:    59. 螺旋矩阵 II
 * @author: wangzk
 * @date: 2020/8/27 10:37
 */
public class GenerateSpiralOrderMatrix {
    public static void main(String[] args) {
        GenerateSpiralOrderMatrix generateSpiralOrderMatrix = new GenerateSpiralOrderMatrix();
        int[][] matrix = generateSpiralOrderMatrix.generateMatrix(5);
        for(int[] sub_matrix : matrix)
            System.out.println(Arrays.toString(sub_matrix));
    }

    public int[][] generateMatrix(int n) {
        if (n <= 0) return null;
        int[][] matrix = new int[n][n];
        int up = 0, down = n-1, left = 0, right = n-1;
        int counter = 1;
        while (true) {
            for (int i = left; i <= right; i++) matrix[up][i] = counter++;
            if (++up > down) break;
            for (int i = up; i <= down; i++) matrix[i][right] = counter++;
            if (--right < left) break;
            for (int i = right; i >= left; i--) matrix[down][i] = counter++;
            if (--down < up) break;
            for (int i = down; i >= up; i--) matrix[i][left] = counter++;
            if (++left > right) break;
        }
        return matrix;
    }
}
