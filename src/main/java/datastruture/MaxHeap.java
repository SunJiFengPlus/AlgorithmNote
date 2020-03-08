package datastruture;

/**
 * 二叉堆性质:
 * 1. 堆中的父节点的值总是大于等于子节点的值
 * 2. 二叉堆是一棵完全二叉树 - 把节点从上至下, 从左到右的安排
 *
 *          0
 *        /   \
 *       1     2
 *     /  \   /  \       数组形式
 *    3   4  5   6      ---------->    [0][1][2][3][4][5][6][7][8]
 *   / \
 *  7  8
 *
 * @author 孙继峰
 * @date 2019/04/06
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 返回堆中的元素个数
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 返回一个布尔值, 表示堆中是否为空
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮 O(logn)
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
//            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 看堆中的最大元素
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     * 步骤: 交换堆顶与堆底元素, 移除堆底元素, 从堆顶开始 siftDown
     */
    public E extractMax() {
        E ret = findMax();
//        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 下沉 O(logn)
     */
    private void siftDown(int k) {

        // k的左子树成为叶子节点
        while (leftChild(k) < data.getSize()) {
            // 在此轮循环中,data[k]和data[j]交换位置
            int j = leftChild(k);
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                // j + 1 < data.getSize()说明有右孩子
                j++; // j存储右孩子的索引（如果右比左大的话）
            }
            // data[j] 是 leftChild 和 rightChild 中的最大值

            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

//            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出堆顶元素, 并将 e 加入堆中
     */
    public E replace(E e) {
        E res = findMax();
        data.set(0, e);
        siftDown(0);
        return res;
    }

    /**
     * 将无序数组转为堆, O(n)
     */
    public void heapify(E[] arr) {
        data = new Array<>(arr);
        // i是倒数第一个非叶子节点
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }
}