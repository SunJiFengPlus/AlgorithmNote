package leetcode;

import leetcode.structure.ListNode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 *
 * @author 孙继峰
 * @since 2020/4/14
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 使用 Stack 将链表逆序
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummyHead = new ListNode(0);
        int flag = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || flag != 0) {
            int sum = (stack1.isEmpty() ? 0 : stack1.pop()) + (stack2.isEmpty() ? 0 : stack2.pop()) + flag;
            if (sum >= 10) {
                sum -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            // 头插法再逆序
            ListNode node = new ListNode(sum);
            node.next = dummyHead.next;
            dummyHead.next = node;
        }
        return dummyHead.next;
    }
}
