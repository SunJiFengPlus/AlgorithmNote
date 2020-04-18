package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author 孙继峰
 * @since 2020/4/18
 */
public class ContainerWithMostWater {
    // 使用双指针, 每次移动较小的指针, 因为较大的指针盛的水只会越来越少
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
