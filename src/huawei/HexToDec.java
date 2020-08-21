package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 * @description:    HJ5 进制转换
 * @author: wangzk
 * @date: 2020-08-04 08:45
 */
public class HexToDec {
    private List<Integer> valueList = new ArrayList<>(8);

    public HexToDec() {
        initValueVect();
    }

    private void initValueVect() {
        valueList.add(1);
        for (int i = 1; i < 8; i++) {
            valueList.add(valueList.get(i-1) * 16);
        }
    }

    public void hexToDec() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (!scanner.hasNext())
                break;
            String hexStr = scanner.nextLine();
            int n = hexStr.length();
            if (!hexStr.startsWith("0x") || n < 3) {
                System.out.println("");
                continue;
            }
            long sum = 0;
            for (int i = 2; i < n; i++) {
                char c = hexStr.charAt(i);
                int num = 0;
                if (c >= '0' && c <= '9') {
                    num = c - '0';
                } else if (c >= 'A' && c <= 'F') {
                    num = c - 'A' + 10;
                } else {
                    System.out.println("");
                    continue;
                }
                sum += num * valueList.get(n - i -1);
            }
            System.out.println(sum);
            System.out.println(Long.parseLong(hexStr.substring(2), 16));

        }
    }

    public static void main(String[] args) {
        HexToDec hexToDec = new HexToDec();
        hexToDec.hexToDec();
    }
}
