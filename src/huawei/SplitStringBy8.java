package huawei;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:    HJ4 字符串分隔
 * @author: wangzk
 * @date: 2020/8/21 15:53
 */
public class SplitStringBy8 {

    public static void main(String[] args) {
        splitStringBy8_optm();
    }

    public static void splitStringBy8() {
        Scanner cin = new Scanner(System.in);
        List<String> stringList = new LinkedList<>();
        for (int k = 0; k < 2; k++) {
            String str = cin.nextLine();
            if(str.replaceAll(" ", "").equals(""))
                continue;
            int n = str.length();
            for (int i = 0; i < n; i+=8) {
                int endIdx = i+8;
                if (endIdx > n){
                    endIdx = n;
                    StringBuilder str_addition = new StringBuilder();
                    for (int j = 0; j < i+8-(n-1)-1; j++) {
                        str_addition.append("0");
                    }
                    stringList.add(str.substring(i, endIdx) + str_addition.toString());
                } else {
                    stringList.add(str.substring(i, endIdx));
                }

            }
        }
        stringList.forEach(System.out::println);
    }

    public static void splitStringBy8_optm() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.nextLine();
            if(str.replaceAll(" ", "").equals(""))
                continue;

            int n_origin = str.length();
            if (str.length() % 8 != 0) {
                str += "00000000";
            }

            for (int i = 0; i < n_origin; i+=8) {
                System.out.println(str.substring(i, i+8));
            }
        }
    }
}
