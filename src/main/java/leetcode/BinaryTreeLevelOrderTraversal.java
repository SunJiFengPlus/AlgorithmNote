package leetcode;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// leetcode 102
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelTraversal(root, 0, res);
        return res;
    }
    
    public void levelTraversal(TreeNode root, int depth, List<List<Integer>> res) {
        if (Objects.isNull(root)) {
            return;
        }
        if (res.size() == depth) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        
        levelTraversal(root.left, depth+1, res);
        levelTraversal(root.right, depth+1, res);
    }
}
