package algorithm.test.backtrack;

import java.util.*;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/24 10:46
 */
public class QueenN {

    public static void main(String[] args) {
        QueenN queenN = new QueenN();
        List<List<String>> strListsLists = queenN.solveNQueens(1);
        for(List<String> solution: strListsLists){
            for(String lineStr: solution){
                System.out.println(lineStr);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return null;
        int n_queens = n;
        List<List<List<Integer>>> result = new LinkedList<>();
        LinkedList<List<Integer>> state_root = new LinkedList<>();
        queenNHelper(state_root, 0, n_queens, result);
        List<List<String>> resultStringsLists = new LinkedList<>();
        char[] chars = new char[n_queens];
        Arrays.fill(chars, '.');
        for (List<List<Integer>> solution: result) {
            List<String> lineStrs = new ArrayList<>(n_queens);
            for (int i = 0; i < n_queens; i++) {
                char[] lineI = Arrays.copyOf(chars, n_queens);
//                int x = solution.get(i).get(0);
                int y = solution.get(i).get(1);
                lineI[y] = 'Q';
                lineStrs.add(String.valueOf(lineI));
            }
            resultStringsLists.add(lineStrs);
        }
        return resultStringsLists;
    }

    public void queenNHelper(LinkedList<List<Integer>> state, int start, int n_queens, List<List<List<Integer>>> result) {

        if (state.size() == n_queens) {
            result.add(new ArrayList<>(state));
        } else {
            out:
            for (int i = 0; i < n_queens; i++) {
                for (int j = 0; j < state.size(); j++) {
                    if (i == state.get(j).get(1)) {
                        continue out;
                    }
                    if (Math.abs(start-state.get(j).get(0)) == Math.abs(i-state.get(j).get(1))) {
                        continue out;
                    }
                }
                List<Integer> posOfStart = new ArrayList<>();
                posOfStart.add(start);
                posOfStart.add(i);
                state.addLast(posOfStart);
                queenNHelper(state, start+1, n_queens, result);
                state.removeLast();
            }
        }
    }
}
