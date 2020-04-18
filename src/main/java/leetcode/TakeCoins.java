package leetcode;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author 孙继峰
 * @since 2020/4/18
 */
public class TakeCoins {
    /**
     *  https://leetcode-cn.com/contest/season/2020-spring/problems/na-ying-bi-UGC/
     */
    public int minCount(int[] coins) {
        return Arrays.stream(coins).map(a -> (int) Math.ceil(a / 2D)).sum();
    }

    @Test
    public void test1() {
        Assert.assertEquals(minCount(new int[]{4,2,1}), 4);
    }

    @Test
    public void test2() {
        Assert.assertEquals(minCount(new int[]{2,3,10}), 8);
    }
}
