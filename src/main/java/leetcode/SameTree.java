package leetcode;

/**
 * @author 孙继峰
 * @since 2019/03/24
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        if (q == null) {
            return false;
        }

        boolean flag = p.val == q.val;
        if (!flag) {
            return false;
        }
        flag = isSameTree(p.left, q.left);
        if (!flag) {
            return false;
        }
        return isSameTree(p.right, q.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}