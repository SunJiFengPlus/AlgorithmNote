package leetcode;

/**
 * 反转字符串
 *
 * @author 孙继峰
 * @date 2019/03/17
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int start = 0, length = s.length, end = length - 1;
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        new ReverseString().reverseString(s);
        for (char c : s) {
            System.out.print(c);
        }
    }
}
