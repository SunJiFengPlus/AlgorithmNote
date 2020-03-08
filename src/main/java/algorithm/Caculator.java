package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author 孙继峰
 */
public class Caculator {
    /**
     * 运算符优先级
     */
    private final Map<Character, Integer> priority = new HashMap<>();
    {
        priority.put('(', 0);
        priority.put(')', 0);
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
    }

    /**
     * 将中缀表达式转换为后缀表达式
     */
    public String infixToSuffix(String infixExp) {
        Stack<Character> s = new Stack<>();
        StringBuilder suffix = new StringBuilder();

        for (char ch : infixExp.toCharArray()) {
            if (ch >= 48 && ch <= 57) {
                suffix.append(ch);
            } else if (ch == '(') {
                s.push(ch);
            } else if (ch == ')') {
                while (s.peek().equals('(')) {
                    suffix.append(s.pop());
                }
                s.pop();
            } else {
                // 栈不为空, 且此运算符优先级是否 小于等于 栈顶的运算符
                while (!s.empty() && priority.get(ch) <= priority.get(s.peek())) {
                    suffix.append(s.pop());
                }
                s.push(ch);
            }
        }

        // 如果栈不为空，则把剩余运算符一次弹出，送至输出序列
        while (!s.empty()) {
            suffix.append(s.pop());
        }
        return suffix.toString();
    }

    /**
     * 将后缀表达式的进行计算得到运算结果
     */
    public double calSuffix(String suffixExp) {
        Stack<Integer> stack = new Stack<>();
        for (char ch : suffixExp.toCharArray()) {
            // 如果遇到了数字则直接进栈
            if (ch >= 48 && ch <= 57) {
                stack.push(Integer.valueOf(String.valueOf(ch)));
            } else {
                // 先弹出的那个数其实是第二个计算数值，这里记作 y
                int y = stack.pop();
                int x = stack.pop();
                // 将运算结果重新压栈
                stack.push(calculate(x, y, ch));
            }
        }
        // 弹出栈顶元素就是最终结果
        return stack.pop();
    }

    private int calculate(int x, int y, char ch) {
        switch (ch) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            default:
                throw new IllegalArgumentException("错误的运算符");
        }
    }
}