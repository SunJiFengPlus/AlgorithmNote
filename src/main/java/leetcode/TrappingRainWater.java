package leetcode;

import java.util.LinkedList;

// leetcode 42
public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        // 单调递减栈, 一旦元素比栈顶元素大, 那就说明有积水
        LinkedList<Integer> stack = new LinkedList<>();
        
        for (int right = 0; right < height.length; right++) {
            // 有积水
            while (!stack.isEmpty() && height[stack.getFirst()] < height[right]) {
                Integer cur = stack.removeFirst();
                if (stack.isEmpty()) {
                    // 没有左边的墙就不计算积水
                    break;
                }
                Integer left = stack.getFirst();
                int length = right - left - 1;
                // height[cur] 作为地面高度
                int h = Math.min(height[left], height[right]) - height[cur];
                res += length * h; 
            }
            
            stack.addFirst(right);
        }
        
        return res;
    }
}
