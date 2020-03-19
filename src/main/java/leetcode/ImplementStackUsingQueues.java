package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 孙继峰
 * @since 2020/3/19
 */
public class ImplementStackUsingQueues {
    static class MyStack {
        Queue<Integer> base;
        Queue<Integer> copy;
        int top;

        /** Initialize your data structure here. */
        public MyStack() {
            base = new LinkedList<>();
            copy = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            top = x;
            base.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int last = base.peek(), lastPrev = 0;
            while (base.size() != 1) {
                lastPrev = last;
                copy.add(base.remove());
                last = base.peek();
            }
            base.remove();
            top = lastPrev;
            Queue<Integer> temp = base;
            base = copy;
            copy = temp;
            return last;
        }

        /** Get the top element. */
        public int top() {
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return base.isEmpty();
        }
    }
}
