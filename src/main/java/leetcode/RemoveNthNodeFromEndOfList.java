package leetcode;

import leetcode.structure.ListNode;

import java.util.LinkedList;

// leetcode 19
public class RemoveNthNodeFromEndOfList {


    /**
     * 使用双指针技巧，快指针先走n+1步，然后快慢指针一起移动
     * 当快指针到达末尾时，慢指针正好指向要删除节点的前一个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        
        // 快指针先走 n+1 步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // 快慢指针同时移动，直到快指针到达末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // 此时slow指向要删除节点的前一个节点
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
