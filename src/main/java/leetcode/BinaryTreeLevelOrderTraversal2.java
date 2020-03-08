package leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 *
 * @author 孙继峰
 * @date 2019/03/26
 */
public class BinaryTreeLevelOrderTraversal2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        levelTraversal(root, 0);
        Collections.reverse(res);
        return res;
    }

    public void levelTraversal(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (res.size() == depth) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);

        levelTraversal(root.left, depth + 1);
        levelTraversal(root.right, depth + 1);
    }
}
