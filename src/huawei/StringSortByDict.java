package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/22 15:40
 */
public class StringSortByDict {

    public static void main(String[] args) {
        sortString();
    }

    public static void sortString() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            List<String> stringList = new ArrayList<>();
            List<String> stringListRef = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = cin.nextLine();
                stringList.add(str);
                stringListRef.add(str);
            }

            for (int i = n-1; i >= 1; i--) {
                int max = 0;
                for (int j = 1; j <= i; j++) {
                    if (stringList.get(j).compareTo(stringList.get(max)) > 0)
                        max = j;
                }
                String temp = stringList.get(i);
                stringList.set(i, stringList.get(max));
                stringList.set(max, temp);
            }


            stringListRef.sort(String::compareTo);
            stringList.forEach(System.out::println);
            stringListRef.forEach(System.out::println);
//            String strResult = stringList.stream().collect(Collectors.joining(" "));
//            System.out.println(strResult);
//
//            String strResultRef = stringListRef.stream().collect(Collectors.joining(" "));
//            System.out.println(strResultRef);

        }
    }
}
