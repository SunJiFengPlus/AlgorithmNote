package leetcode;

import leetcode.structure.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最大深度 3 。
 *
 * @author 孙继峰
 * @date 2019/03/26
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    /**
     * 获取树的最大深度
     * @param root 根节点
     * @param depth 此根节点的深度
     * @return 树的最大深度
     */
    public int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
    }
}
