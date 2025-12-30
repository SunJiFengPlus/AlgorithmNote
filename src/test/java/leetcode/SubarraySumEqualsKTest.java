package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubarraySumEqualsKTest {

    @Test
    public void test() {
        assertThat(new SubarraySumEqualsK().subarraySum(new int[]{1,1,1}, 2))
            .isEqualTo(2);
        assertThat(new SubarraySumEqualsK().subarraySum(new int[]{1,2,3}, 3))
            .isEqualTo(2);
    }

}