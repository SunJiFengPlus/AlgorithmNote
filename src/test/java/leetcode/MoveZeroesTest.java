package leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MoveZeroesTest {
    @Test
    public void test1() {
        int[] input = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(input);
        assertThat(input).containsExactly(1,3,12,0,0);
    }

    @Test
    public void test2() {
        int[] input = {0};
        new MoveZeroes().moveZeroes(input);
        assertThat(input).containsExactly(0);
    }

    @Test
    public void test3() {
        int[] input = {0, 1, 3, 12};
        new MoveZeroes().moveBack(input, 0, 1);
        assertThat(input).containsExactly(1,0,3,12);
    }

    @Test
    public void test4() {
        int[] input = {0, 0, 1, 3, 12};
        new MoveZeroes().moveBack(input, 0, 2);
        assertThat(input).containsExactly(1,3,0,0,12);
    }

    @Test
    public void test5() {
        int[] input = {0, 0, 0, 0, 3, 12};
        new MoveZeroes().moveBack(input, 0, 4);
        assertThat(input).containsExactly(3,12,0,0,0,0);
    }

    @Test
    public void test6() {
        int[] input = {1, 1, 3, 12};
        new MoveZeroes().moveBack(input, 0, 0);
        assertThat(input).containsExactly(1, 1, 3, 12);
    }

    @Test
    public void test7() {
        int[] input = {1, 0, 0, 3, 12};
        new MoveZeroes().moveBack(input, 1, 3);
        assertThat(input).containsExactly(1,3,12,0,0);
    }

    @Test
    public void test8() {
        int[] input = {4,2,4,0,0,3,0,5,1,0};
        new MoveZeroes().moveZeroes(input);
        assertThat(input).containsExactly(4,2,4,3,5,1,0,0,0,0);
    }
}
