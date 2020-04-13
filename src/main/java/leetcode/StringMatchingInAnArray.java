package leetcode;

import java.util.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * https://leetcode-cn.com/contest/weekly-contest-184/problems/string-matching-in-an-array/
 *
 * @author 孙继峰
 * @since 2020/4/12
 */
public class StringMatchingInAnArray {
    public List<String> stringMatching(String[] words) {
        Set<String> res = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                if (words[i].contains(words[j])) {
                    res.add(words[j]);
                }
            }
        }
        return new ArrayList<>(res);
    }

    @Test
    public void test1() {
        String[] input = {"mass","as","hero","superhero"};
        Assertions.assertThat(stringMatching(input)).containsExactlyInAnyOrder("as","hero");
    }

    @Test
    public void test2() {
        String[] input = {"leetcode","et","code"};
        Assertions.assertThat(stringMatching(input)).containsExactlyInAnyOrder("et","code");
    }

    @Test
    public void test3() {
        String[] input = {"blue","green","bu"};
        Assertions.assertThat(stringMatching(input)).isEmpty();
    }

    @Test
    public void test4() {
        String[] input = {"leetcoder","leetcode","od","hamlet","am"};
        Assertions.assertThat(stringMatching(input)).containsExactlyInAnyOrder("leetcode","od","am");
    }
}
