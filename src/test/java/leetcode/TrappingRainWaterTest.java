package leetcode;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrappingRainWaterTest {
    @Test
    public void test1() {
        int trap = new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        assertThat(trap).isEqualTo(6);
    }

    @Test
    public void test2() {
        int trap = new TrappingRainWater().trap(new int[]{4,2,0,3,2,5});
        assertThat(trap).isEqualTo(9);
    }
}