package leetcode;

import leetcode.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @author 孙继峰
 * @since 2020/3/23
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode fast = slow;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast == null ? slow : slow.next;
    }
}
