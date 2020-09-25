package exam.shopee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/9/16 15:49
 */
public class SequenceGame {

    public static void main(String[] args) {
        // 12345678
        // 17245368
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            cin.nextLine();
            String[] strings = new String[n*2];
            for (int i = 0; i < 2*n; i++) {
                strings[i] = cin.nextLine();
            }
            List<String> resultString = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                minLength = Integer.MAX_VALUE;
                System.out.println(strings[2*i]);
                StringBuilder rootState = new StringBuilder(strings[2*i]);
                String endState = strings[2*i+1];
                List<String> result = new LinkedList<>();
                StringBuilder path = new StringBuilder();
                trans(rootState, path, endState, result);
                result.sort(String::compareTo);
                resultString.add(result.get(0));
            }
            for(String str: resultString){
                System.out.println(str);
            }
        }
    }

    public static int minLength = Integer.MAX_VALUE;
    public static void trans(StringBuilder state, StringBuilder path, String endState, List<String> result) {
        if (state.toString().equals(endState)) {
            if (path.length() < minLength){
                minLength = path.length();
                result.add(new String(path));
            }
        }
        //A
        if (path.length()+1 < minLength && (path.length() == 0 || path.charAt(path.length()-1) != 'A')) {
            state.reverse();
            path.append("A");
            trans(state, path, endState, result);
            state.reverse();
            path.deleteCharAt(path.length()-1);
        }

        //B
        int countB = 0;
        String s = path.toString().replaceAll("A", "");
        for (int i = s.length()-1; i >= 0 &&s.charAt(i)=='B'; i--) {
            countB++;
        }
        if (path.length()+1 < minLength && countB<=3) {
            System.out.println(path);
            StringBuilder newState = new StringBuilder();
            newState.append(state.charAt(3));
            newState.append(state.substring(0, 3));
            newState.append(state.substring(5, 8));
            newState.append(state.charAt(4));
            path.append("B");
            trans(newState, path, endState, result);
            path.deleteCharAt(path.length()-1);
        }

        //C
        int countC = 0;
        for (int i = s.length()-1; i >= 0 && s.charAt(i)=='C'; i--) {
            countC++;
        }
        if (path.length()+1 < minLength && countC <= 3) {
            StringBuilder newState = new StringBuilder();
            int[] seqIdx = {0,6,1,3,4,2,5,7};
            for (int i = 0; i < seqIdx.length; i++) {
                newState.append(state.charAt(seqIdx[i]));
            }
            path.append("C");
            trans(newState, path, endState, result);
            path.deleteCharAt(path.length()-1);
        }
    }
}
