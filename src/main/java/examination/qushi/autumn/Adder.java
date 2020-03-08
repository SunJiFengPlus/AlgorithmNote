package examination.qushi.autumn;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 1234567890123456789012345678901234567890.1234567890123456789012345678901234567890
 * 1000000000100000000010000000001000000000.1000000000100000000010000000001000000000
 *
 * 2234567890223456789022345678902234567890.223456789022345678902234567890223456789
 *
 * @author 孙继峰
 * @date 2019/08/08
 */
public class Adder {
    private static String add(String one, String another) {
        char[] oneNum = one.toCharArray();
        char[] anotherNum = another.toCharArray();

        // 整数栈
        Stack<Character> oneIntegerStack = new Stack<>();
        Stack<Character> anotherIntegerStack = new Stack<>();
        // 填充整数栈

        for (int i = 0, temp = one.indexOf('.'), oneIndexOf = temp == -1? one.length() : temp;  i < oneIndexOf; i++) {
            oneIntegerStack.push(oneNum[i]);
        }
        for (int i = 0, temp = another.indexOf('.'), anotherIndexOf = temp == -1? another.length() : temp;  i < anotherIndexOf; i++) {
            anotherIntegerStack.push(anotherNum[i]);
        }
        // 小数队列
        Queue<Character> oneFloatQueue = new ArrayDeque<>();
        Queue<Character> anotherFloatQueue = new ArrayDeque<>();
        // 填充小数队列

return "";



    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        String sum = add(num1, num2);
        System.out.println(sum);
    }
}