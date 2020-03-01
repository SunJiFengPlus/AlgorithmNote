package leetcode;

import java.util.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author 孙继峰
 * @since 2020/3/26
 */
public class ThreeSum {
    /**
     * 双向指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int start, end;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                if (start > i + 1 && nums[start] == nums[start - 1]) {
                    start++;
                    continue;
                }
                if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                } else if (nums[i] + nums[start] + nums[end] > 0) {
                    end--;
                } else if (nums[i] + nums[start] + nums[end] == 0) {
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                }
            }
        }
        return res;
    }

    @Test
    public void testThreeSum1() {
        // GIVEN
        int[] input = {-1, 0, 1, 2, -1, -4};
        // WHEN
        List<List<Integer>> res = threeSum(input);
        // THEN
        Assertions.assertThat(res).containsExactlyInAnyOrder(
                Arrays.asList(-1, 0, 1),
                Arrays.asList(-1, -1, 2)
        );
    }

    @Test
    public void testThreeSum2() {
        // GIVEN
        int[] input = {0, 0, 0, 0};
        // WHEN
        List<List<Integer>> res = threeSum(input);
        // THEN
        Assertions.assertThat(res).containsExactly(
                Arrays.asList(0, 0, 0)
        );
    }

    @Test
    public void testThreeSum3() {
        // GIVEN
        int[] input = {0, 1, 1};
        // WHEN
        List<List<Integer>> res = threeSum(input);
        // THEN
        Assertions.assertThat(res).isEmpty();
    }

    @Test
    public void testThreeSum4() {
        // GIVEN
        int[] input = {0, 0};
        // WHEN
        List<List<Integer>> res = threeSum(input);
        // THEN
        Assertions.assertThat(res).isEmpty();
    }

    @Test
    public void testThreeSum5() {
        // GIVEN
        int[] input = {-2, 0, 0, 2, 2};
        // WHEN
        List<List<Integer>> res = threeSum(input);
        // THEN
        Assertions.assertThat(res).containsExactly(
                Arrays.asList(-2, 0, 2)
        );
    }
}
