package leetcode;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeIntervalsTest {
    @Test
    public void test1() {
        int[][] res = new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        assertThat(res).isEqualTo(new int[][]{{1,6},{8,10},{15,18}});
    }
}