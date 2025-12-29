package leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PerfectSquaresTest {
    @Test
    public void test1() {
        assertThat(new PerfectSquares().numSquares1(12)).isEqualTo(3);
        assertThat(new PerfectSquares().numSquares1(13)).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(new PerfectSquares().numSquares2(12)).isEqualTo(3);
        assertThat(new PerfectSquares().numSquares2(13)).isEqualTo(2);
    }
}