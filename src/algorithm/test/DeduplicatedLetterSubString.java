package algorithm.test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/10/11 18:10
 */
public class DeduplicatedLetterSubString {

    /*
    滑动动态窗口：j表示窗口的右端，逐步向前，i表示窗口的左端，是使得窗口不含有重复的最大下标
     */
    public String LongestDeduplicatedSubstring (String s) {
        int[] lastIdx = new int[128];   // 仅浪费128-26*2个int，但后面编写程序很方便且省去减法
        for (int i = 0; i < 128; i++) {
            lastIdx[i] = -1;
        }
        int i = 0, max = 0, startOpt = 0, endOpt = 0;
        for (int j = 0; j < s.length(); j++) {
            int ch = s.charAt(j);
            if (lastIdx[ch] >= i) {
                i = lastIdx[ch]+1;
            }
            int len = j-i+1;
            if (len > max) {
                startOpt = i;
                endOpt = j;
                max = len;
            }
            lastIdx[ch] = j;
        }
        return s.substring(startOpt, endOpt+1);
    }


    /*
    wrong
     */
    public String findMaxSubstr (String str) {
        // write code here
        List<List<Integer>> idxes = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            idxes.add(new ArrayList<>());
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                idxes.get(ch - 'a').add(i);
            }
        }

        int max = 0, startOpt = 0, endOpt = 0;
        for (int i = 0; i < idxes.get(0).size()-1; i++) {
            int start = idxes.get(0).get(i), end = idxes.get(0).get(i+1)-1;
            for (int j = 1; j < 26; j++) {
                for (int k = 0; k < idxes.get(j).size()-1; k++) {
                    if (idxes.get(j).get(k) > start && idxes.get(j).get(k+1) < end) {
                        end = Math.min(end, idxes.get(j).get(k+1) - 1);
                    }
                }
            }
            int len = end - start + 1;
            if (len > max) {
                startOpt = start;
                endOpt = end;
                max = len;
            }
        }
        return str.substring(startOpt, endOpt+1);
    }

    public static void main(String[] args) {
        String s = "abcdbcdcbabcdefggcwa";
//        String s2 = "abcaa";
        System.out.println(new DeduplicatedLetterSubString().LongestDeduplicatedSubstring(s));
    }
}
