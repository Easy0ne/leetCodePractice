package algorithm.test.array.intervals;

import java.util.Arrays;

/**
 * @description:    leetcode 435. 无重叠区间   类似问题有452、605、455、253
 * @author: wangzk
 * @date: 2020/10/9 20:38
 */
public class EraseOverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
        int[][] intervals2 = {{1,2},{1,2},{1,2}};
        EraseOverlapIntervals eraseOverlapIntervals =  new EraseOverlapIntervals();
        System.out.println(eraseOverlapIntervals.eraseOverlapIntervals(intervals2));
    }


    /*
    贪心思想，按照起点排序，遇到重叠时，选择终点最小的留下，后面才可能连接更多的区间。
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int n;
        if (intervals == null || (n=intervals.length) == 0) return 0;
        Arrays.sort(intervals, (x1, x2) ->x1[0]-x2[0]);
        int end = intervals[0][0];
        int count = 0;
        for (int[] interval: intervals) {
            if (interval[0] >= end) {
                end = interval[1];
                count++;
            } else {
                end = Math.min(end, interval[1]);
            }
        }
        return n - count;
    }

}
