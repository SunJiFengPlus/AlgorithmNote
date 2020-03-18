package leetcode;

import leetcode.structure.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author 孙继峰
 * @date 2019/03/20
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        RemoveLinkedListElements r = new RemoveLinkedListElements();
//        r.removeElements(new ListNode(1), 2);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 移除链表中值为 val 的节点
     * @param head 头节点
     * @param val 要删除节点的值
     * @return 删除节点后的链表
     */
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements1(head.next, val);
        return (head.val == val) ? head.next : head;
    }
}