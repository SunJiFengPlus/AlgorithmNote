package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ClimbingStairsTest {
    
    @ParameterizedTest
    @CsvSource({
        "2, 2",
        "3, 3"
    })
    public void test(int input, int output) {
        int res = new ClimbingStairs().climbStairs(input);
        assertThat(res).isEqualTo(output);
    }
}