package leetcode;

import datastruture.Array;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class ThreeSumTest {

    @Test
    public void testThreeSum1() {
        // GIVEN
        // -4 -1 -1 0 1 2
        int[] input = {-1, 0, 1, 2, -1, -4};
        // WHEN
        List<List<Integer>> res = new ThreeSum().threeSum(input);
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
        List<List<Integer>> res = new ThreeSum().threeSum(input);
        // THEN
        Assertions.assertThat(res).containsExactlyInAnyOrder(
            Arrays.asList(0, 0, 0)
        );
    }

    @Test
    public void testThreeSum3() {
        // GIVEN
        int[] input = {0, 1, 1};
        // WHEN
        List<List<Integer>> res = new ThreeSum().threeSum(input);
        // THEN
        Assertions.assertThat(res).isEmpty();
    }

    @Test
    public void testThreeSum4() {
        // GIVEN
        int[] input = {0, 0};
        // WHEN
        List<List<Integer>> res = new ThreeSum().threeSum(input);
        // THEN
        Assertions.assertThat(res).isEmpty();
    }

    @Test
    public void testThreeSum5() {
        // GIVEN
        int[] input = {-2, 0, 0, 2, 2};
        // WHEN
        List<List<Integer>> res = new ThreeSum().threeSum(input);
        // THEN
        Assertions.assertThat(res).containsExactlyInAnyOrder(
            Arrays.asList(-2, 0, 2)
        );
    }

    @Test
    public void testThreeSum6() {
        // GIVEN
        int[] input = {-2,0,1,1,2};
        // WHEN
        List<List<Integer>> res = new ThreeSum().threeSum(input);
        // THEN
        Assertions.assertThat(res).containsExactlyInAnyOrder(
            Arrays.asList(-2,0,2),
            Arrays.asList(-2,1,1)
        );
    }

    @Test
    public void testThreeSum7() {
        // GIVEN
        int[] input = {-100,-70,-60,110,120,130,160};
        // WHEN
        List<List<Integer>> res = new ThreeSum().threeSum(input);
        // THEN
        Assertions.assertThat(res).containsExactlyInAnyOrder(
            Arrays.asList(-100,-60,160),
            Arrays.asList(-70,-60,130)
        );
    }

}