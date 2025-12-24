package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 70
 */
public class ClimbingStairs {
    /**
     * 最小子问题:
     * - 剩余1级台阶只能迈1步, 有1种迈法
     * - 剩余2级台阶可以迈1步或者2步, 有2种迈法
     */
    public int climbStairs1(int n) {
        if (n < 2) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    // 加上缓存,这样不会超时
    Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs2(int n) {
        if (n < 2) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int res = climbStairs2(n - 1) + climbStairs2(n - 2);
        cache.put(n, res);

        return res;
    }
}
