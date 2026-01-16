package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

// leetcode 56
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] pre = res.getLast();
            int[] cur = intervals[i];
            if(canMerge(pre, cur)) {
                res.removeLast();
                res.addLast(new int[]{Math.min(pre[0], cur[0]), Math.max(pre[1], cur[1])});
            } else {
                res.add(cur);
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }

    private boolean canMerge(int[] pre, int[] cur) {
        return cur[0] <= pre[1];
    }
}
