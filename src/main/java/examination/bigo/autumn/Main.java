package examination.bigo.autumn;

/**
 * @author 孙继峰
 * @date 2019/08/27
 */
public class Main {

    StringBuilder s1 = new StringBuilder();
    StringBuilder s2 = new StringBuilder();

    /**
     * 判断 a 是否为 b 的子树
     * 概要: 中序遍历 a 与 b, 得到 s1 与 s2, 判断 s1 是不是 s2 的子串
     */
    public boolean isSubTree(TreeNode a, TreeNode b) {
        inTraverse(a, true);
        inTraverse(a, false);
        return s2.toString().contains(s1.toString());
    }

    private void inTraverse(TreeNode root, boolean flag) {
        if (root == null) {
            return;
        }

        inTraverse(root.left, flag);
        if (flag) {
            s1.append(root.val);
        } else {
            s2.append(root.val);
        }
        inTraverse(root.right, flag);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static double distance(double h, int n) {
        double result = 0;
        for (int i = 0; i < n; i++) {
            result += h * (Math.pow(2, -i) + Math.pow(2, -i - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(distance(10, 3));
    }
}