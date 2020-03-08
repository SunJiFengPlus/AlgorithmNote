package leetcode;

/**
 * @author 孙继峰
 * @date 2019/03/24
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            if (q != null) {
                return false;
            } else {
                return true;
            }
        }
        if (q == null) {
            if (p != null) {
                return false;
            } else {
                return true;
            }
        }

        boolean flag = p.val == q.val;
        if (flag == false) {
            return false;
        }
        flag = isSameTree(p.left, q.left);
        if (flag == false) {
            return false;
        }
        return isSameTree(p.right, q.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}