package leetcode;

import leetcode.structure.ListNode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author 孙继峰
 * @date 2019/08/27
 */
public class ReverseLinkedList {
    /**
     * 遍历, 不使用额外空间
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 递归
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode realHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return realHead;
    }
}
