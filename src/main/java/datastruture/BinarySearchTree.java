package datastruture;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 不存放重复元素
 * @author 孙继峰
 * @date 2019/03/21
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;

    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向二分搜索树中插入一个元素 e
     *
     * @return 返回插入新节点后, 二叉树的根
     */
    private Node add(Node root, E e) {
        if (root == null) {
            return new Node(e);
        }

        if (e.compareTo(root.e) > 0) {
            root.right = add(root.right, e);
        } else if (e.compareTo(root.e) < 0){
            root.left = add(root.left, e);
        }
        return root;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 以 root 为根的树是否包含元素 e
     */
    private boolean contains(Node root, E e) {
        if (root == null) {
            return false;
        }

        if (e.compareTo(root.e) > 0) {
            return contains(root.right, e);
        } else if (e.compareTo(root.e) < 0) {
            return contains(root.left, e);
        }
        return true;
    }

    /**
     * 前序遍历
     */
    public void preTraverse() {
        preTraverse(root);
    }

    private void preTraverse(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.e);
        preTraverse(root.left);
        preTraverse(root.right);
    }

    /**
     * 中序遍历
     */
    public void inTraverse() {
        inTraverse(root);
    }

    private void inTraverse(Node root) {
        if (root == null) {
            return;
        }

        inTraverse(root.left);
        System.out.println(root.e);
        inTraverse(root.right);
    }

    /**
     * 后序遍历
     */
    public void postTraversing() {
        postTraversing(root);
    }

    private void postTraversing(Node root) {
        if (root == null) {
            return;
        }

        postTraversing(root.left);
        postTraversing(root.right);
        System.out.println(root.e);
    }

    /**
     * 层序遍历
     */
    public void levelTraversal() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小元素
     */
    public E minimum(){
        if(root == null) {
            throw new IllegalArgumentException("BST is empty");
        }

        Node minNode = minimum(root);
        return minNode.e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     */
    private Node minimum(Node node){
        if( node.left == null ) {
            return node;
        }

        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     */
    public E maximum(){
        if(root == null) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     */
    private Node maximum(Node node){
        if( node.right == null ) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点, 返回删除节点后新的二分搜索树的根
     */
    private Node removeMin(Node node){
        // 处理递归到底的情况。
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除掉以node为根的二分搜索树中值为e的节点, 返回删除节点后新的二分搜索树的根
     */
    private Node remove(Node node, E e){

        if( node == null ) {
            return null;
        }

        if( e.compareTo(node.e) < 0 ){
            node.left = remove(node.left , e);
            return node;
        }
        else if(e.compareTo(node.e) > 0 ){
            node.right = remove(node.right, e);
            return node;
        }
        else{   // e.compareTo(node.e) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    /**
     * 从二分搜索树中删除最大值所在节点
     */
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点, 返回删除节点后新的二分搜索树的根
     */
    private Node removeMax(Node node){

        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public E remove(E e) {
        root = remove(root, e);
        return e;
    }
}