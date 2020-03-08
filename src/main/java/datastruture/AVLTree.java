package datastruture;

/**
 * 平衡二叉树特点:
 *      对于任意一个节点, 左子树与右子树的高度差不能超过 1
 *
 * @author 孙继峰
 * @date 2019/07/27
 */
public class AVLTree<K extends Comparable<K>, V> {
    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    /**
     * 获取节点的平衡因子
     */
    private int getBanlanceFactor(Node node) {
        return node == null ? 0 : Math.abs(getHeight(node.left) - getHeight(node.right));
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 向树中插入一个元素 e
     *
     * @return 返回插入新节点后, 二叉树的根
     */
    private Node add(Node root, K key, V value) {
        if (root == null) {
            size ++;
            return new Node(key, value);
        }

        if (key.compareTo(root.key) > 0) {
            root.right = add(root.right, key, value);
        } else if (key.compareTo(root.key) < 0){
            root.left = add(root.left, key, value);
        } else {
            // 相等则替换
            root.value = value;
        }

        // 更新高度
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

        // 检查平衡因子


        return root;
    }

}
