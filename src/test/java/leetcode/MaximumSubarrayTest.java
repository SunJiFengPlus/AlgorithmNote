package leetcode;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaximumSubarrayTest {
    @Test
    public void test1() {
        int res = new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertThat(res).isEqualTo(6);
    }

    @Test
    public void test2() {
        int res = new MaximumSubarray().maxSubArray(new int[]{1});
        assertThat(res).isEqualTo(1);
    }

    @Test
    public void test3() {
        int res = new MaximumSubarray().maxSubArray(new int[]{5,4,-1,7,8});
        assertThat(res).isEqualTo(23);
    }
}