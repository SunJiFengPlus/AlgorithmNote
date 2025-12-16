package leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestConsecutiveTest {
    @Test
    public void test1() {
        int i = new LongestConsecutive().longestConsecutive2(new int[]{100, 4, 200, 1, 3, 2});
        assertThat(i).isEqualTo(4);
    }

    @Test
    public void test2() {
        int i = new LongestConsecutive().longestConsecutive2(new int[]{0,3,7,2,5,8,4,6,0,1});
        assertThat(i).isEqualTo(9);
    }

    @Test
    public void test3() {
        int i = new LongestConsecutive().longestConsecutive2(new int[]{1,0,1,2});
        assertThat(i).isEqualTo(3);
    }

    @Test
    public void test4() {
        int i = new LongestConsecutive().longestConsecutive2(new int[]{0,0});
        assertThat(i).isEqualTo(1);
    }
}