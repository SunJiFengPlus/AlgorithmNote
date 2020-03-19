package leetcode;

import java.util.Stack;

/**
 * @author 孙继峰
 * @since 2020/3/19
 */
public class ImplementQueueUsingStacks {
    static class MyQueue {
        Stack<Integer> input;
        Stack<Integer> output;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            input.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            move();
            return output.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            move();
            return output.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            move();
            return output.isEmpty();
        }

        public void move() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
        }
    }
}
