package exam.jdong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/17 19:55
 */
public class FindNums {

    // 201003abc2020输出：2020

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.nextLine();
            System.out.println(findNums(str).stream().collect(Collectors.joining(" ")));
        }
    }

    public static List<String> findNums(String str) {
        List<String> result = new ArrayList<>();
        // ".{1}[\\d]{4}[,\\\\.\\s\\r\\n]"
        // "[\\D|\\s]{1}[\\d]{4}[\\D]+"
        Pattern pattern = Pattern.compile("[\\d]+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String s = matcher.group();
            if (s.length() <= 4 && 1000 <= Integer.valueOf(s) && Integer.valueOf(s) <= 2020) {
                result.add(s);
            }
        }
        return result;
    }
}
