package exam.gensheixue;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MergeAccount {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static List<List<String>> mergeAccount(List<List<String>> accounts) {
        // 在此处编写实现代码逻辑
        List<List<String>> results = new ArrayList<List<String>>();
        int n = accounts.size();
        boolean[][] link = new boolean[n][n];
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 0; j < accounts.get(i).size(); j++) {
                for (int i1 = i+1; i1 < accounts.size(); i1++) {
                    for (int j1 = 0; j1 < accounts.get(i1).size(); j1++) {
                        if (accounts.get(i).get(j).equals(accounts.get(i1).get(j1))){
                            link[i][i1] = true;
                        }
                    }
                }
            }
        }
        


        return results;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int _count = Integer.parseInt(in.nextLine());

        int _i = 0;
        List<List<String>> _accounts = new ArrayList<List<String>>();
        while (_i++ < _count) {
            String _line = in.nextLine();
            String[] _item = _line.split(",");
            _accounts.add(Arrays.asList(_item));
        }

        List<List<String>> res = mergeAccount(_accounts);

        Collections.sort(res, new Comparator<List<String>>() {

            @Override
            public int compare(List<String> o1, List<String> o2) {
                String aName1 = String.join(",", o1);
                String aName2 = String.join(",", o2);
                return aName1.compareTo(aName2);
            }

        });

        for (int res_i = 0; res_i < res.size(); res_i++) {
            List<String> resItem = res.get(res_i);
            System.out.println(String.join(",", resItem));
        }
    }
}
