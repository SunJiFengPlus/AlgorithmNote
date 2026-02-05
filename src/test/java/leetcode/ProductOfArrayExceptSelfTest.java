package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductOfArrayExceptSelfTest {

    @Test
    public void test1() {
        int[] res = new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4});
        assertThat(res).isEqualTo(new int[]{24,12,8,6});
    }

    @Test
    public void test2() {
        int[] res = new ProductOfArrayExceptSelf().productExceptSelf(new int[]{-1,1,0,-3,3});
        assertThat(res).isEqualTo(new int[]{0,0,9,0,0});
    }
}