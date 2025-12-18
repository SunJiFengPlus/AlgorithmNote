package leetcode;


/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author 孙继峰
 * @since 2020/4/18
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, max = 0;
        while (i < j) {
            max = Math.max(max, (j-i)* Math.min(height[j], height[i]));
            if (height[j] > height[i]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
    
    // 使用双指针, 每次移动较小的指针, 因为较大的指针盛的水只会越来越少
    public int maxArea2(int[] height) {
        int max = 0, temp;
        int le = 0, ri = height.length - 1;
        while (le < ri) {
            max = Math.max(Math.min(height[le], height[ri]) * (ri - le), max);
            temp = height[le] >= height[ri] ? ri-- : le++;
        }
        return max;
    }
}
