package leetcode;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author 孙继峰
 * @since  2020/04/21
 */
public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    @ParameterizedTest
    @CsvSource({
            "123, 321",
            "-123, -321"
    })
    public void test(int input, int output) {
        Assert.assertEquals(reverse(input), output);
    }
}