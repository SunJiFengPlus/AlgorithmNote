package leetcode;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    public void test1() {
        int res = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb");
        assertThat(res).isEqualTo(3);
    }

    @Test
    public void test2() {
        int res = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb");
        assertThat(res).isEqualTo(1);
    }

    @Test
    public void test3() {
        int res = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew");
        assertThat(res).isEqualTo(3);
    }

    @Test
    public void test4() {
        int res = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba");
        assertThat(res).isEqualTo(2);
    }
}