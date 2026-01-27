package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestPalindromicSubstringTest {
    @Test
    public void test1() {
        String res = new LongestPalindromicSubstring().longestPalindrome("babad");
        assertThat(res).isIn("aba", "bab");
    }

    @Test
    public void test2() {
        String res = new LongestPalindromicSubstring().longestPalindrome("cbbd");
        assertThat(res).isEqualTo("bb");
    }

    @Test
    public void test3() {
        String res = new LongestPalindromicSubstring().longestPalindrome("caba");
        assertThat(res).isEqualTo("aba");
    }
}