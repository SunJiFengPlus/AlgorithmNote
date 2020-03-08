package leetcode;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author 孙继峰
 * @date 2019/05/21
 */
public class SingleNumber {
    /**
     * 异或 "^": 两个操作数的位中，相同则结果为 0，不同则结果为 1
     *      1101
     *    ^ 0011
     * -----------
     *      1110
     *
     *  a^a=0, a^0=a, a^b^c=c^a^b
     *  2^2^3^5^3 = 2^2^3^3^5 = 0^0^5 = 0^5 = 5
     */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i=1; i<nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
