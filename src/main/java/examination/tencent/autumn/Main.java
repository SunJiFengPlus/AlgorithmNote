package examination.tencent.autumn;


import java.util.Scanner;
import java.util.Stack;

/**
 * @author 孙继峰
 * @date 2019/08/17
 */
public class Main {
    public static void main(String[] args) {
//        int lastLeft = -1;
//        int lastDelmeterIndex = -1;
//        for (int i = 0, length = input.length(); i < length - 1 ; i++) {
//            char currentChar;
//            list.add(String.valueOf(currentChar = input.charAt(i)));
//
//            if (currentChar == '|') {
//                lastDelmeterIndex = i;
//                stack.push(new Pre(lastLeft, i))
//            } else if (currentChar == '[') {
//                lastLeft = i;
//            } else if (currentChar == ']') {
//                int number = Integer.valueOf(input.substring(lastLeft + 1, lastDelmeterIndex));
//                String s = input.substring(lastDelmeterIndex + 1, i);
//                for (int j = 0; j < i - lastLeft + 1; j++) {
//                    list.remove(list.size() -1);
//                }
//                for (int j = 0; j < number; j++) {
//                    list.add(s);
//                }
//            }
//        }
//
//        list.forEach(System.out::print);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack<String> stack = new Stack<>();

        for (int i = 0, length = input.length(); i < length - 1; i++) {
            char currentChar = input.charAt(i);
            stack.push(String.valueOf(currentChar));
        }

    }

    static class Pre {
        int left;
        int delemeter;

        Pre(int left, int delemeter) {
            this.left = left;
            this.delemeter = delemeter;
        }
    }
}
