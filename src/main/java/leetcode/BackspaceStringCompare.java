package leetcode;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 * @author 孙继峰
 * @date 2019/03/28
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        return trim(S).equals(trim(T));
    }

    public String trim(String s) {
        int index = s.indexOf('#');
        if (index == -1) {
            return s;
        }
        String pre = s.substring(0, index - 1 >= 0 ? index - 1 : 0);
        String suf = s.substring(index + 1);
        return trim(pre + suf);
    }
}
