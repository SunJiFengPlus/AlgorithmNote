package leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumTest {
    @Test
    public void test1() {
        int[] ints = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
        assertThat(ints).containsExactlyInAnyOrder(0,1);
    }

    @Test
    public void test2() {
        int[] ints = new TwoSum().twoSum(new int[]{3,2,4}, 6);
        assertThat(ints).containsExactlyInAnyOrder(1,2);
    }

    @Test
    public void test3() {
        int[] ints = new TwoSum().twoSum(new int[]{3,3}, 6);
        assertThat(ints).containsExactlyInAnyOrder(0,1);
    }

}