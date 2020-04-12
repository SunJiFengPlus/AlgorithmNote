package leetcode;

import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * https://leetcode-cn.com/contest/weekly-contest-184/problems/html-entity-parser/
 *
 * @author 孙继峰
 * @since 2020/4/12
 */
public class HTMLEntityParser {
    public String entityParser(String text) {
        return text.replaceAll("&quot;", "\"")
                .replaceAll("&apos;", "'")
                .replaceAll("&amp;", "&")
                .replaceAll("&gt;", ">")
                .replaceAll("&lt;", "<")
                .replaceAll("&frasl;", "/");
    }

    @ParameterizedTest
    @CsvSource({
            "&amp; is an HTML entity but &ambassador; is not., & is an HTML entity but &ambassador; is not.",
            "and I quote: &quot;...&quot;, and I quote: \"...\"",
            "Stay home! Practice on Leetcode :), Stay home! Practice on Leetcode :)",
            "x &gt; y &amp;&amp; x &lt; y is always false, x > y && x < y is always false",
            "leetcode.com&frasl;problemset&frasl;all, leetcode.com/problemset/all"
    })
    public void test(String input, String output) {
        Assertions.assertThat(entityParser(input)).isEqualTo(output);
    }
}
