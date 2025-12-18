package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ContainerWithMostWaterTest {

    @Test
    public void test1() {
        assertThat(new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}))
            .isEqualTo(49);
    }

}