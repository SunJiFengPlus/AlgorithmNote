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
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        ListNode dummyHead = new ListNode(0);
        boolean add = false;
        while (!stack1.isEmpty() || !stack2.isEmpty() || add) {
            if (!stack1.isEmpty() && !stack2.isEmpty()) {
                int sum = stack1.pop().val + stack2.pop().val;
                if (add) {
                    sum++;
                    add = false;
                }
                if (sum >= 10) {
                    sum -= 10;
                    add = true;
                }
                ListNode listNode = new ListNode(sum);
                listNode.next = dummyHead.next;
                dummyHead.next = listNode;
            } else if (!stack1.isEmpty()) {
                ListNode listNode = new ListNode(stack1.pop().val);
                listNode.next = dummyHead.next;
                dummyHead.next = listNode;
            } else if (!stack2.isEmpty()){
                ListNode listNode = new ListNode(stack2.pop().val);
                listNode.next = dummyHead.next;
                dummyHead.next = listNode;
            } else {
                ListNode listNode = new ListNode(1);
                listNode.next = dummyHead.next;
                dummyHead.next = listNode;
                add = false;
            }
        }

        return dummyHead.next;
    }
}
