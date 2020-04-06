package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Matcher matcher = Pattern.compile("^[+-]?\\d+").matcher(str.trim());
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        return 0;
    }

    @ParameterizedTest
    @CsvSource({
            "42, 42",
            "'   -42', -42",
            "4193 with words, 4193",
            "words and 987, 0"
    })
    public void test(String input, int output) {
        Assert.assertEquals(myAtoi(input), output);
    }
}
