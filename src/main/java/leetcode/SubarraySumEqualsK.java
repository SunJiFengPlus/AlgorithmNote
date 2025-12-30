package leetcode;

// leetcode 560
public class SubarraySumEqualsK {

    // 暴力, 跑的结果给我干笑了(还好没超时
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int startIndex = 0; startIndex < nums.length; startIndex++) {
            int sum = 0;
            for (int endIndex = startIndex; endIndex < nums.length; endIndex++) {
                sum += nums[endIndex];
                if (sum==k) {
                    res++;
                }
            }
        }

        return res;
    }
}
