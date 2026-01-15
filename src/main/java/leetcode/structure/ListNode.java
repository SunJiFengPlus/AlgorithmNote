package leetcode.structure;

/**
 * @author 孙继峰
 * @since 2020/3/15
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
    
    /**
     * 通过数组构建链表
     *
     * @param arr 整数数组
     */
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        
        this.val = arr[0];
        
        ListNode current = this;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
    }
    
    /**
     * 遍历链表并返回包含所有节点值的数组
     * 
     * @return 包含链表所有节点值的整数数组
     */
    public int[] toArray() {
        // 第一次遍历计算链表长度
        int len = 0;
        ListNode current = this;
        while (current != null) {
            len++;
            current = current.next;
        }
        
        // 创建相应大小的数组
        int[] result = new int[len];
        
        // 第二次遍历填充数组
        current = this;
        int index = 0;
        while (current != null) {
            result[index++] = current.val;
            current = current.next;
        }
        
        return result;
    }
}