package leetcode;

import org.junit.Test;

import java.util.List;

public class GroupAnagramsTest {

    @Test
    public void test1() {
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }

    @Test
    public void test2() {
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(new String[]{"a"});
        System.out.println(lists);
    }

    @Test
    public void test3() {
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(new String[]{});
        System.out.println(lists);
    }

}