package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author 孙继峰
 * @since 2020/4/18
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0, temp;
        int le = 0, ri = height.length - 1;
        while (le < ri) {
            max = Math.max(Math.min(height[le], height[ri]) * (ri - le), max);
            temp = height[le] >= height[ri] ? ri-- : le++;
        }
        return max;
    }

    @Test
    public void test1() {
        Assert.assertEquals(maxArea(new int[]{1,8,6,2,5,4,8,3,7}), 49);
    }
}
