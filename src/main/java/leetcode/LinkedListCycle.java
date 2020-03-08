package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * @author 孙继峰
 * @date 2019/08/27
 */
public class LinkedListCycle {
    /**
     * 下策
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fastNode = head.next;
        while (fastNode != head) {
            if (fastNode != null && fastNode.next != null) {
                head = head.next;
                fastNode = fastNode.next.next;
            } else {
                return false;
            }
        }
        return true;
    }
}