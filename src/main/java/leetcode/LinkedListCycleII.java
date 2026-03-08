package leetcode;

import leetcode.structure.ListNode;

// leetcode 142
public class LinkedListCycleII {
    //  1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 ->
    //                      ↑                      |
    //                      -----------------------|
    // 
    // 环外节点数量设为a, 环内节点设为b 
    // 现象1:
    //    快指针(f)每次走2, 快慢指针(s)走1, 第一次相遇的时候
    //    快指针的路程的是慢指针的二倍, f = 2s
    //    快指针的路程比慢指针的路程多出n个环的周长, f = s + nb
    // 推论: s = nb, 也即第一次相遇的时候慢指针的总路程是环周长的n倍
    // 
    // 现象2: 走到环入口处时经过的路程为: a + nb
    // 结合现象1推论: 在快慢指针第一次相遇后, 再向前走 a 步就是环入口
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        // 第一次相遇
        while (true) {
            // 无环
            if (fast == null || fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // 构造第二次相遇, 另外一个指针从链表头出发, 一起走到相遇就是环入口
        ListNode cycleEntrant = head;
        while (slow != cycleEntrant) {
            slow = slow.next;
            cycleEntrant = cycleEntrant.next;
        }

        return cycleEntrant;
    }
}
