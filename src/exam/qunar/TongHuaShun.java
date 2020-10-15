package exam.qunar;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/10/14 20:36
 */
public class TongHuaShun {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            cin.nextLine();
            String line = cin.nextLine();
            String[] cards = line.split(" ");
            for (int i = 0; i < n; i++) {
                cards[i] = cards[i].replace("J", "11");
                cards[i] = cards[i].replace("Q", "12");
                cards[i] = cards[i].replace("K", "13");
                cards[i] = cards[i].replace("A", "1");
            }
            Arrays.sort(cards, (x1, x2) -> Integer.valueOf(x2.substring(1))-Integer.valueOf(x1.substring(1)));
            System.out.println(Arrays.toString(cards));
            char[] huaxings = new char[n];
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                huaxings[i] = cards[i].charAt(0);
                values[i] = Integer.valueOf(cards[i].substring(1));
            }
            judge(huaxings, values);
        }
    }

    public static void judge(char[] huaxings, int[] values) {
        int n = huaxings.length;
        boolean tonghua = false, shunzi = false, ace = false;
        int maxCount = 0;
        int[] count = new int[13];
        boolean[] huaxing = new boolean[4];
        for (int i = 0; i < n; i++) {
            char ch = huaxings[i];
            if (ch == 'S') huaxing[0] = true;
            else if (ch == 'H') huaxing[1] = true;
            else if (ch == 'C') huaxing[2] = true;
            else if (ch == 'D') huaxing[3] =true;
        }
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            if (huaxing[i]) temp++;
        }
        if (temp == 1) tonghua = true;

        for (int i = 0; i < n; i++) {
            count[values[i]] ++;
        }
        maxCount = Arrays.stream(count).max().getAsInt();

        if (n >= 3) {
            if (values[0]==13 && values[n-2]==10 && values[n-1]==1) {
                ace = true;
            } else if (values[0] - values[n-1] == n-1) {
                tonghua = true;
            }
        }

        if (ace && tonghua) {
            System.out.println("HuangJiaTongHuaShun");
        } else if (tonghua && values[0] - values[n-1] == n-1) {
            System.out.println("TongHuaShun");
        } else if (maxCount == 4) {
            System.out.println("SiTiao");
        } else if (maxCount == 3 && Arrays.stream(count).filter((x) -> x== 2).count() == 1) {
            System.out.println("HuLu");
        } else if (tonghua) {
            System.out.println("TongHua");
        } else if (values[0] - values[n-1] == n-1) {
            System.out.println("ShunZi");
        } else if (Arrays.stream(count).max().getAsInt() == 3) {
            System.out.println("SanTiao");
        }
    }
}
