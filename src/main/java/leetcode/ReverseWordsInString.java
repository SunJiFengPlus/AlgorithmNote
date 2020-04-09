package leetcode;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * @author 孙继峰
 * @date 2019/08/24
 */
public class ReverseWordsInString {
    /**
     * "the sky  is  blue" -> "eulb  si  yks eht" 全部反转
     * "eulb  si  yks eht" -> "blue is sky the  " 局部反转
     *
     * 每次只隔一个空格, 反转第一个空格后的, 就慢慢的把多余的空格移到数组的尾部了
     * "blue" + "  si  yks eht"
     * "blue is" + "   yks eht"
     * "blue is sky" + "   eht"
     * "blue is sky the  "
     */
    public String reverseWords(String s) {
        // 去掉前后的空格
        s = s.replaceAll("^ +| +$", "");
        // 去掉中间多余的空格
        s = s.replaceAll(" {2,}(?<= )", " ");

        int length = s.length();
        char[] result = s.toCharArray();
        // 全部反转
        reverse(result, 0, length - 1);
        // 局部反转
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (result[i] == ' ') {
                reverse(result, start, i - 1);
                start = i + 1;
            }
            if (i == length - 1) {
                reverse(result, start, i);
            }
        }
        return new String(result).replaceFirst(" +$", "");
    }

    public void reverse(char[] s, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            char temp = s[startIndex];
            s[startIndex++] = s[endIndex];
            s[endIndex--] = temp;
        }
    }

    public String reverseWords2(String s) {
        String[] array = s.trim().split(" ");
        int le = 0, ri = array.length - 1;
        while (le < ri) {
            String temp = array[le];
            array[le++] = array[ri];
            array[ri--] = temp;
        }
        StringBuilder builder = new StringBuilder();
        Arrays.stream(array).forEach(str -> builder.append(str).append(" "));
        return builder.toString().trim();
    }

    @ParameterizedTest
    @CsvSource({
            "the sky is blue, blue is sky the"
    })
    public void test(String input, String output) {
        Assertions.assertThat(reverseWords2(input)).isEqualTo(output);
    }
}
