package leetcode;

import leetcode.structure.TreeNode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author 孙继峰
 * @since 2020/3/30
 */
public class ValidateBinarySearchTree {
    /**
     * 其核心就是利用了二分搜索数中序遍历是有序的性质
     * 另外我个人有个简单的方法由二叉树的图片快速得到中序遍历的结果, 把一个二叉树进行"降维打击"得到就是中序遍历的结果了
     */
    public boolean isValidBST(TreeNode root) {
        double cur = Double.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (cur >= root.val) {
                return false;
            }
            cur = root.val;
            root = root.right;
        }
        return true;
    }
}
