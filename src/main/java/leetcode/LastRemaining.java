package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/
 *
 * @author 孙继峰
 * @since 2020/3/30
 */
public class LastRemaining {
    public int lastRemaining(int n, int m) {
        int result = 0;
        for (int i = 2; i <= n; ++i) {
            result = (result + m) % i;
        }
        return result;
    }

    @ParameterizedTest
    @CsvSource({
            "1, 3, 0", // 0                     0
            "2, 3, 1", // (0 + 3) % 2 = 1       (0 + 3) % 2 = 1
            "3, 3, 1", // (1 + 3) % 3 = 1       ((0 + 3) % 2 + 3) % 3 = 1
            "4, 3, 0", // (1 + 3) % 4 = 0       (((0 + 3) % 2 + 3) % 3 + 3) % 4 = 0
            "5, 3, 3"  // (0 + 3) % 5 = 3       ((((0 + 3) % 2 + 3) % 3 + 3) % 4 + 3) % 5 = 3
    })
    public void testLastRemaining1(int n, int m, int output) {
        assertThat(lastRemaining(n, m)).isEqualTo(output);
    }
}
