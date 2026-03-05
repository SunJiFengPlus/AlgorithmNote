package leetcode;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RotateArrayTest {
    @Test
    public void test1() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate2(ints, 3);
        assertThat(ints).containsExactly(5,6,7,1,2,3,4);
    }

    @Test
    public void test2() {
        int[] ints = {-1};
        new RotateArray().rotate2(ints, 2);
        assertThat(ints).containsExactly(-1);
    }

    @Test
    public void test3() {
        int[] ints = {1,2};
        new RotateArray().rotate2(ints, 7);
        assertThat(ints).containsExactly(2,1);
    }

    @Test
    public void test4() {
        int[] ints = {1,2,3};
        new RotateArray().rotate2(ints, 4);
        assertThat(ints).containsExactly(3,1,2);
    }
}