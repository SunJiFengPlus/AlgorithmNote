package leetcode;

// leetcode5
public class LongestPalindromicSubstring {

    // 中心扩散法
    public String longestPalindrome(String s) {
        int maxLengthLeft = 0, maxLengthRight = 0, maxLength = 0;
        char[] charArray = s.toCharArray();

        // 固定中间值
        for (int mid = 0; mid < charArray.length; mid++) {
            int left = mid - 1, right = mid + 1, length = 1;

            // 向左扩散, 找相同的字符
            while (left >= 0 && charArray[left] == charArray[mid]) {
                left--;
                length++;
            }

            // 向右扩散, 找相同的字符
            while (right < charArray.length && charArray[right] == charArray[mid]) {
                right++;
                length++;
            }

            // 向两边扩散, 找相同的字符
            while (left >= 0 && right < charArray.length && charArray[left] == charArray[right]) {
                left--;
                right++;
                length += 2;
            }
            
            if (length > maxLength) {
                maxLength = length;
                // 
                maxLengthLeft = ++left;
                maxLengthRight = --right;
            }
        }

        return s.substring(maxLengthLeft, maxLengthRight + 1);
    }
}
