package algorithm.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/24 10:46
 */
public class Queen8 {

    public static List<List<Integer>> result = new ArrayList<>();

    public void queen8() {

    }

    public void queen8Helper(List<Integer> rows_remain, int n, List<Integer> rows_path) {

        for (Integer i: rows_remain) {
            List<Integer> new_rows_remain = new ArrayList<>(rows_remain);
            new_rows_remain.remove(i);
            List<Integer> new_rows_path = new ArrayList<>(rows_path);
            queen8Helper(new_rows_remain, n-1, new_rows_path);
        }
    }
}
