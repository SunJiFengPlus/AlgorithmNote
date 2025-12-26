package leetcode;

/**
 * leetcode 198 打家劫舍
 */
public class HouseRobber {

    /**
     * 子问题: 偷k个房子最多能偷多少钱 (k < nums.length)
     * 而 "偷k个房子最多能偷多少钱" 取决于 "偷k-1个房子最多能偷多少钱"
     * k-1 就带来一个约束, 偷或者不偷最后一间房子
     * - 偷1个房子最多就是1个房子的钱, f(1) = 1
     * - 偷2个房子最多最多就是最多其中的最大值, f(1,2) = 2
     * - 偷3个房子能偷到最多的是: max(f(偷第3个房子后的收入), f(不偷第3个房子后的收入))
     */
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        
        // dp数组为偷第n间房子获得的最大收入, n从0开始
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        
        return dp[dp.length-1];
    }
}
