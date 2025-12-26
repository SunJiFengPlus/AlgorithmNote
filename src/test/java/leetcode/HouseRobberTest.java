package leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HouseRobberTest {
    @Test
    public void test() {
        assertThat(new HouseRobber().rob(new int[]{1,2,3,1})).isEqualTo(4);
        assertThat(new HouseRobber().rob(new int[]{2,7,9,3,1})).isEqualTo(12);
        assertThat(new HouseRobber().rob(new int[]{0})).isEqualTo(0);
    }
}