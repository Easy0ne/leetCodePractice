package algorithm.test.array.intervals;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @description:    leetCode 56. 合并区间
 * @author: wangzk
 * @date: 2020/9/30 21:45
 */
public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{1,3},{2,6},{3,5},{15,18}};
        int[][] intervals2 = {{1,4},{4,5}};
        intervals = mergeIntervals.merge(intervals);
        for(int[] interval: intervals) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public int[][] merge1(int[][] intervals) {
        int n = intervals.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            for (int j = i-1; j >=0 ; j--) {
                boolean isMerged = false;
                if (intervals[j] != null) {
                    if (intervals[j][0] <= left && left <= intervals[j][1]) {
                        intervals[i][0] = intervals[j][0];
                        isMerged = true;
                    }
                    if (intervals[j][0] <= right && right <= intervals[j][1]) {
                        intervals[i][1] = intervals[j][1];
                        isMerged = true;
                    }
                    if (left <= intervals[j][0] && intervals[j][1] <= right) {
                        isMerged = true;
                    }
                    if (isMerged) {
                        intervals[j] = null;
                        count ++;
                    }
                }
            }
        }

        int[][] mergedIntervals = new int[n - count][2];
        int j = 0;
        for (int[] interval : intervals) {
            if (interval != null) {
                mergedIntervals[j++] = interval;
            }
        }
        return mergedIntervals;
    }

    /*
    贪心思想，遍历按起点升序排序后的区间，如果当前区间与前一个区间有重合，则扩展当前的区间到最长覆盖，如果无重合，则前一个区间可以加入结果集中。
     */
    public int[][] merge(int[][] intervals) {
        int n;
        if (intervals == null || (n = intervals.length) == 0) return new int[][]{};
        int[][] mergedIntervals = new int[n][2];
        Arrays.sort(intervals, (x1, x2) -> x1[0]-x2[0]);
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= intervals[i-1][1]) {
                intervals[i][0] = intervals[i-1][0];
                intervals[i][1] = intervals[i][1] > intervals[i-1][1] ? intervals[i][1] : intervals[i-1][1];
            } else {
                mergedIntervals[count++] = intervals[i-1];
            }
        }
        mergedIntervals[count++] = intervals[n-1];
        return Arrays.copyOf(mergedIntervals, count);
    }

    public int[][] mergeByBitSet(int[][] intervals) {
        BitSet bitSet = new BitSet();
        for (int[] interval: intervals) {
            bitSet.set(interval[0], interval[1]+1, true);
        }
        int count = 0, idx = 0;
//        System.out.println(bitSet.size());
//        System.out.println(bitSet.length());
        for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i+1)) {
            int end = bitSet.nextClearBit(i);
            int[] temp = {i, end-1};
            intervals[count++] = temp;
            i = end;
        }
        return Arrays.copyOf(intervals, count);
    }
}
