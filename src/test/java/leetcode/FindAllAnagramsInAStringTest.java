package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllAnagramsInAStringTest {
    @Test
    public void test1() {
        List<Integer> res = new FindAllAnagramsInAString().findAnagrams("cbaebabacd", "abc");
        assertThat(res).containsExactlyInAnyOrder(0,6);
    }

    @Test
    public void test2() {
        List<Integer> res = new FindAllAnagramsInAString().findAnagrams("abab", "ab");
        assertThat(res).containsExactlyInAnyOrder(0,1,2);
    }

    @Test
    public void test3() {
        List<Integer> res = new FindAllAnagramsInAString().findAnagrams("ababababab", "aab");
        assertThat(res).containsExactlyInAnyOrder(0,2,4,6);
    }
}