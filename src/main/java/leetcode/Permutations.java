package leetcode;


import java.util.ArrayList;
import java.util.List;

public class Permutations {
    
    /**
     * 全排列问题 - 递归实现
     * 思路：1234 的全排列等于：
     * - 1 与 234 的全排列
     * - 2 与 134 的全排列
     * - 3 与 124 的全排列
     * - 4 与 123 的全排列
     *
     * 递归分解：
     * 123 的全排列 = 1 与 23 的全排列，2 与 13 的全排列，3 与 12 的全排列
     * 12 的全排列 = 12, 21
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // 基础情况：如果只有一个元素，直接返回
        if (nums.length == 1) {
            List<Integer> single = new ArrayList<>();
            single.add(nums[0]);
            res.add(single);
            return res;
        }

        // 遍历每个元素作为第一个元素
        for (int i = 0; i < nums.length; i++) {
            // 当前选择的元素
            int current = nums[i];

            // 构建剩余元素数组
            int[] remaining = new int[nums.length - 1];
            int index = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    remaining[index++] = nums[j];
                }
            }

            // 递归计算剩余元素的全排列
            List<List<Integer>> subPermutations = permute(remaining);

            // 将当前元素添加到每个子排列的开头
            for (List<Integer> subPerm : subPermutations) {
                List<Integer> permutation = new ArrayList<>();
                permutation.add(current);
                permutation.addAll(subPerm);
                res.add(permutation);
            }
        }

        return res;
    }
}
