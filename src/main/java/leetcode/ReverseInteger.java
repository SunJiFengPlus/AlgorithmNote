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
        long res = 0;
        while (x != 0) {
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)res;
    }

    @ParameterizedTest
    @CsvSource({
            "123, 321",
            "-123, -321",
            "120, 21",
            "1534236469, 0"
    })
    public void test(int input, int output) {
        Assert.assertEquals(reverse(input), output);
    }
}