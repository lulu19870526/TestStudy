package leetcode.niuke.suanfa;

import java.util.Arrays;

/**
 * @Author: zengqx
 * @Date: 2023/2/5 17:21
 */
public class NC222 {

    public static void main(String[] args) {
        Interval n1 = new Interval(1, 3);
        Interval n2 = new Interval(6, 9);
        Interval[] arr = new Interval[]{n1, n2};
        Interval n3 = new Interval(2, 5);
        insertInterval(arr, n3);
    }


    public static Interval[] insertInterval(Interval[] Intervals, Interval newInterval) {
        // write code here
        Interval[] arr = new Interval[Intervals.length + 1];
        int i = 0;
        int index = 0;
        while (i < Intervals.length && Intervals[i].end < newInterval.start) {
            arr[index++] = Intervals[i++];
        }
        while (i < Intervals.length && Intervals[i].start <= newInterval.end) {
            newInterval.start = Math.min(Intervals[i].start, newInterval.start);
            newInterval.end = Math.max(Intervals[i].end, newInterval.end);
            i++;
        }
        arr[index++] = newInterval;
        while (i < Intervals.length) {
            arr[index++] = Intervals[i++];
        }
        return Arrays.copyOf(arr, index);
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
