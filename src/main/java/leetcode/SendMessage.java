package leetcode;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author 孙继峰
 * @since 2020/4/18
 */
public class SendMessage {
    /**
     * https://leetcode-cn.com/contest/season/2020-spring/problems/chuan-di-xin-xi-UGC/
     * 未 AC
     */
    Map<Integer, Set<Integer>> map = new HashMap<>();

    public int numWays(int n, int[][] relation, int k) {
        for (int[] ints : relation) {
            if (map.containsKey(ints[0])) {
                map.get(ints[0]).add(ints[1]);
            } else {
                map.put(ints[0], new HashSet<>(Collections.singleton(ints[1])));
            }
        }
        return numWays(n, k, 0);
    }

    public int numWays(int n, int k, int cur) {
        if (k == 1) {
            return map.get(cur).contains(n - 1) ? 1 : 0;
        }
        int res = 0;
        for (Integer integer : map.getOrDefault(cur, Collections.emptySet())) {
            res += numWays(n, k - 1, integer);
        }
        return res;
    }

    @Test
    public void test2() {
        Assert.assertEquals(numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3), 3);
    }
}
