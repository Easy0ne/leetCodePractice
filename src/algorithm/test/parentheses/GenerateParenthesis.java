package algorithm.test.parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:    leetCode 22. 括号生成
 * @author: wangzk
 * @date: 2020/9/6 16:55
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }


    // wrong
    public List<String> generateParenthesisWrong(int n) {
        if (n == 0) return null;
        List<HashSet<String>> strLists = new ArrayList<>(n+1);
        HashSet<String> strListOf0 = new HashSet<>();
        strListOf0.add("");
        strLists.add(0, strListOf0);
        HashSet<String> strListOf1 = new HashSet<>();
        strListOf1.add("()");
        strLists.add(1, strListOf1);
        String[] continuedLeftStrs = new String[n+1];
        String[] continuedRightStrs = new String[n+1];
        continuedLeftStrs[0] = "";
        continuedRightStrs[0] = "";
        for (int i = 1; i <= n; i++) {
            continuedLeftStrs[i] = "(" + continuedLeftStrs[i-1];
            continuedRightStrs[i] = continuedRightStrs[i-1] + ")";
        }
        for (int i = 2; i <= n; i++) {
            HashSet<String> strsOfi = new HashSet<>();
            for (int j = 1; j < i; j++) {
                for(String strOfj: strLists.get(j)) {
                    strsOfi.add(strOfj + continuedLeftStrs[i-j] + continuedRightStrs[i-j]);
                    strsOfi.add(continuedLeftStrs[i-j] + strOfj + continuedRightStrs[i-j]);
                    strsOfi.add(continuedLeftStrs[i-j] + continuedRightStrs[i-j] + strOfj);
                }
            }
            strLists.add(i, strsOfi);
        }
        List<String> result = new ArrayList<>(strLists.get(n));
        result.sort(String::compareTo);
        return result;
    }

    public List<String> generateParenthesis(int n) {
        if (n < 0) return null;
        List<String> result = new LinkedList<>();
        StringBuilder stateRoot = new StringBuilder("");
        generateHelper(stateRoot, 0, 0, n, result);
        return result;
    }

    public void generateHelper(StringBuilder str, int count1, int count2, int n, List<String> result) {
        if (count1 == n && count2 == n) {
            result.add(str.toString());
        }

        // + "("
        if (count1 + 1 <= n) {
            generateHelper(str.append("("), count1+1, count2, n, result);
            str.deleteCharAt(str.length()-1);
        }

        // + ")"
        if (count2+1 <= n && count2+1 <= count1){
            generateHelper(str.append(")"), count1, count2+1, n, result);
            str.deleteCharAt(str.length()-1);
        }
    }

}
