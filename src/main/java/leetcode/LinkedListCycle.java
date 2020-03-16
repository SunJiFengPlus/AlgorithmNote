package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * 面试时不要一上来就给出最最优解
 * 1. 等待
 * 2. Set
 * 3. 快慢指针
 *
 * @author 孙继峰
 * @date 2019/08/27
 */
public class LinkedListCycle {

    public boolean hasCycle1(ListNode head) {
        FutureTask<Boolean> task = new FutureTask<>(() -> {
            ListNode h = head;
            while (h != null) {
                h = h.next;
            }
            return true;
        });

        try {
            task.get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            return true;
        }
        return false;
    }

    /**
     * Set
     */
    public boolean hasCycle2(ListNode head) {
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
    public boolean hasCycle3(ListNode head) {
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