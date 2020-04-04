package leetcode;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * @author 孙继峰
 * @since 2020/4/3
 */
public class StringToInteger {
    public int myAtoi(String str) {
        for (int i = 0; i < str.length(); i++) {

        }
        return Integer.parseInt(str.trim());
    }

    @ParameterizedTest
    @CsvSource({
            "42, 42",
            "'   -42', -42",
            "4193 with words, 4193"
    })
    public void test(String input, int output) {
        Assert.assertEquals(myAtoi(input), output);
    }
}
