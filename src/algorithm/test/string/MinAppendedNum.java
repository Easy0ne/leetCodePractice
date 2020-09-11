package algorithm.test.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:    JZ 32 把数组排成最小的数
 * @author: wangzk
 * @date: 2020/9/8 10:29
 */
public class MinAppendedNum {
    /*
    这题容易陷入的坑就是，自己在将字符串按位比较。
    应该学会更好地利用String::compareTo方法，将待比较的两个字符串设置为等长度的：
    例如s1+s2 : s2+s1，而不是s1+s2 : s1+s2.
     */
    public static void main(String[] args) {
        MinAppendedNum minAppendedNum = new MinAppendedNum();
        int[] nums = {3,32,321};
        System.out.println(minAppendedNum.PrintMinNumberOptm(nums));
    }


    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        int n = numbers.length;
        List<List<Integer>> dp = new ArrayList<>();
        List<Integer> list0 = new LinkedList<>();
        list0.add(0, 0);
        dp.add(0, list0);

        for (int i = 1; i < n; i++) {
            String localMin = "9999999999999999999999999999999999999999";
            int size = dp.get(i-1).size();
            for (int j = 0; j <= size; j++) {
                dp.get(i-1).add(j, i);
                StringBuilder sb = new StringBuilder();
                for (int idx: dp.get(i-1)) {
                    sb.append(numbers[idx]);
                }
                String numStr = sb.toString();
                if (numStr.compareTo(localMin) < 0) {
                    dp.add(i, new LinkedList<>(dp.get(i-1)));
                    localMin = numStr;
                }
                dp.get(i-1).remove(j);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int idx: dp.get(n-1)) {
            result.append(numbers[idx]);
        }
        return result.toString();
    }

    public String PrintMinNumberOptm(int [] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        int n = numbers.length;
        List<String> strings = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            strings.add(String.valueOf(numbers[i]));
        }
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+""+o2).compareTo(o2+""+o1);
            }
        });
        return strings.stream().collect(Collectors.joining());
    }
}
