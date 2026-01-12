package leetcode;

import java.util.Arrays;

// leetcode 53
public class MaximumSubarray {

    /**
     * -2, 1, -3, 4, -1, 2, 1, -5, 4
     * dp数组: 
     * 以num[0]结尾的连续子数组的最大和 dp(0) = num[0]
     * 以num[1]结尾的连续子数组的最大和 dp(1) = MAX(num[1], dp(0)+num[1])
     * 以num[2]结尾的连续子数组的最大和 dp(2) = MAX(num[2], dp(1)+num[2])
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
