package algorithm.test.array.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/10/11 15:46
 */
public class PartitionLabels {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels(s));
    }

    public List<Integer> partitionLabels(String string) {
        int[][] intervals = new int[26][2];
        for (int i = 0; i < 26; i++) {
            intervals[i][0] = Integer.MAX_VALUE;
            intervals[i][1] = Integer.MIN_VALUE;
        }
        int countLetter = 0;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            int idx = ch - 'a';
            if (i < intervals[idx][0]) {
                intervals[idx][0] = i;
                countLetter++;
            }
            if (i > intervals[idx][1]) intervals[idx][1] = i;
        }

        intervals = Arrays.stream(intervals).filter(x->x[0]!=Integer.MAX_VALUE).toArray(int[][]::new);
        Arrays.sort(intervals, (x1, x2) -> x1[0] - x2[0]);
        List<int[]> mergedIntervals = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] != Integer.MAX_VALUE && intervals[i][1] != Integer.MIN_VALUE) {
                if (intervals[i][0] > intervals[i-1][1]) {
                    mergedIntervals.add(new int[]{intervals[i-1][0], intervals[i-1][1]});
                } else {
                    intervals[i][0] = intervals[i-1][0];
                    intervals[i][1] = intervals[i][1] > intervals[i-1][1] ? intervals[i][1] : intervals[i-1][1];
                }
            }
        }
        mergedIntervals.add(new int[]{intervals[intervals.length-1][0], intervals[intervals.length-1][1]});
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < mergedIntervals.size(); i++) {
            result.add(mergedIntervals.get(i)[1] - mergedIntervals.get(i)[0] + 1);
        }
        return result;
    }
}
