package leetcode;

// leetcode 238
public class ProductOfArrayExceptSelf {
    
    // 准备前缀之积的数组与后缀之积的数组, 然后向乘, 即为本体的解
    // 1,2,3,4
    // 前缀: 1,1,2,6
    // 后缀: 24,12,4,1
    public int[] productExceptSelf(int[] nums) {
        // 准备前缀之积, 第i个元素(不包含i)之前所有元素的积
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1]; 
        }

        // 准备后缀之积, 第i个元素(不包含i)之后所有元素的积
        int[] suffix = new int[nums.length];
        suffix[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        
        int[] res = new int[nums.length];
        for (int i = 0; i < prefix.length; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }
}
