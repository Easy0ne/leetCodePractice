package algorithm.test;

import java.util.Scanner;
public class Program12 {
    public static Scanner in = new Scanner(System.in);

    public static int[] getInput(String str) {
        int[] arr = new int[3];
        System.out.print(str);
        String str_input = in.nextLine();
        String[] arr_str = str_input.split(" ");
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(arr_str[i]);
        }
        return arr;
    }

    public static int rnd(int min, int max) {
        //使用Math.random()方法生成随机数
        return (int) (min + Math.random() * (max - min + 1));
    }

    public static boolean isDone(int[][] arr) {
        //遍历arr所有元素
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //如果有0则返回false
                if (arr[i][j] == 0)
                    return false;
            }
        }
        //遍历完毕，数组arr中没有0，返回true
        return true;
    }

    public static boolean acceptVal(int[][] arr) {
        //使用visited数组来记录数字1-3在一行/列出现的次数,下标对应数字
        int[] visited = new int[4];
        for (int k = 0; k < 4; k++) visited[k] = 0;
        //遍历所有行和列，一共遍历3行3列
        for (int i = 0; i < 3; i++) {
            //重置 visited array 并遍历第i行
            for (int k = 1; k < 4; k++) visited[k] = 0;
            for (int j = 0; j < 3; j++) {
                int x = arr[i][j];
                if (x != 0) visited[x] ++;
                //数字arr[i][j]出现了多次，duplicated，返回false
                if (visited[x] > 1) return false;
            }

            //重置 visited array 并遍历第i列
            for (int k = 1; k < 4; k++) visited[k] = 0;
            for (int j = 0; j < 3; j++) {
                int x = arr[j][i];
                if (x != 0) visited[x] ++;
                //数字arr[i][j]出现了多次，duplicated，返回false
                if (visited[x] > 1) return false;
            }
        }
        //遍历完毕，每行每列都没有出现重复数字
        return true;
    }

    public static void display(int[][] arr) {
        int i = 0, j = 0;
        for (int[] row: arr) {
            for (int col: row) {
                System.out.printf("%-15s", "["+ i + " " + (j++) +"]: " + col);
            }
            i++;
            j = 0;
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    public static void initial(int[][] arr) {
        int val = 0, col = 0;
        boolean check = true;

        for (int i = 0; i < 3; i++) {
            do {
                check = true;
                val = rnd(1, 3);
                col = rnd(0, 2);
                arr[i][col] = val;
                if (!acceptVal(arr)) {
                    for (int k=0; k<3; k++){
                        for (int j=0; j<3; j++){
                            System.out.print(arr[k][j]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    check = false;
                    arr[i][col] = 0;
                }
            } while (!check);
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int val = 0, col = 0, row = 0;
        boolean check = true;

        initial(arr);

        while (!isDone(arr)) {
            display(arr);

            do {
                check = true;

                int[] inputs = getInput("Enter your move [row col num]: ");
                row = inputs[0];
                col = inputs[1];
                val = inputs[2];

                if (val < 1 || val > 3 || row < 0 || row > 2
                        || col < 0 || col > 2) {
                    check = false;
                    continue;
                }
                arr[row][col] = val;
                if (!acceptVal(arr)) {
                    check = false;
                    arr[row][col] = 0;

                }
            } while(!check);
        }

        display(arr);
        System.out.println("End!");
    }
}
