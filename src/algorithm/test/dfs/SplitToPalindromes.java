package algorithm.test.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:    leetcode 131. 分割回文串
 * @author: wangzk
 * @date: 2020/9/10 15:14
 */
public class SplitToPalindromes {

    public static void main(String[] args) {
        SplitToPalindromes splitToPalindromes = new SplitToPalindromes();
        System.out.println(splitToPalindromes.partition("acbcadda"));
        System.out.println(splitToPalindromes.partition("seeslaveidemonstrateyetartsnomedievalsees"));
    }

    /*
    理解错题意
    是分割后的每个子串都是回文串
     */
    public List<List<String>> partitionWrong(String s) {
        if (s == null) return null;
        int n = s.length();
        List<List<String>> palindromesList = new ArrayList<>(n);
        for (int i = 1; i < n; i++) {
            List<String> palindromes = new LinkedList<>();
            for (int j = 0; j <= n-i; j++) {
                String temp = s.substring(j, j+i);
                if (isPalindrome(temp)) {
                    palindromes.add(temp);
                }
            }
            if (palindromes.size() > 0) {
                palindromesList.add(palindromes);
            }
        }
        return palindromesList;
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        if (n == 0) return false;
        if (n == 1) return true;
        for (int i = 0; i <= n/2; i++) {
            if (s.charAt(i) != s.charAt(n-1-i)) {
                return false;
            }
        }
        return true;
    }

    /*
    "d _ a _ b _ c _ b _ a _ b" 七个字母间有六个空位可分割
    每个空位都可选分/不分，类似求子集
    但这种求解树时间复杂度为O(2^n)，如果不及时剪枝，肯定会超时的。
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        if (s == null || s.length() == 0) return result;
        LinkedList<String> stateRoot = new LinkedList<>();
        partitionDfs(stateRoot, 0, 0, s, result);
        return result;
    }

    public void partitionDfs(LinkedList<String> state, int start, int last, String s, List<List<String>> result) {
        if (start == s.length()-1) {
            String temp = s.substring(last, start+1);
            if (isPalindrome(temp)) {
                state.addLast(s.substring(last, start+1));
                result.add(new ArrayList<>(state));
                state.removeLast();
            }
            return;
        }
        // cut
        String temp = s.substring(last, start+1);
        if (isPalindrome(temp)){    // 一定要及时剪枝
            state.addLast(temp);
            partitionDfs(state, start+1, start+1, s, result);
            state.removeLast();
        }
        // not cut
        partitionDfs(state, start+1, last, s, result);
    }


}
