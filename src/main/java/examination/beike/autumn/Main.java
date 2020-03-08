package examination.beike.autumn;

import java.util.Scanner;

/**
 * @author 孙继峰
 * @date 2019/08/10
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] numbers = new int[num];
        for (int i = 0; i < num; i++) {
            numbers[i] = scanner.nextInt();
        }

        int minCha = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int i = 0; i < num - 1; i++) {
            int temp;
            if ((temp = Math.abs(numbers[i+1]-numbers[i])) < minCha) {
                minCha = temp;
                startIndex = i;
            }
        }

        System.out.println(numbers[startIndex] + " " + numbers[startIndex + 1]);
    }
}

class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] numbers = new int[num];
        for (int i = 0; i < num; i++) {
            numbers[i] = scanner.nextInt();
        }

        int maxLength = 0;
        for (int i = 0; i < num; i++) {
            int tempMaxLength = 0;
            for (int j = i + 1, pre = i; j < num - i; j++) {
                if (numbers[j] - numbers[pre] > 0) {
                    tempMaxLength++;
                    pre = j;
                }
            }
            maxLength = Math.max(maxLength, tempMaxLength);
        }

        System.out.println(maxLength);
    }
}

class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] numbers = new int[num];
        for (int i = 0; i < num; i++) {
            numbers[i] = scanner.nextInt();
        }

        // 如果全符合标准, 比赛的总场数
        int res = num*(num -1)/2;
        for (int i = 0; i < num - 1; i++) {
            for (int j = i+1; j < num - i; j++) {
                if (numbers[i] > numbers[j]) {
                    // 如果相差低于 90%
                    if (numbers[i] * 0.9D > numbers[j]) {
                        res--;
                    }
                }
                if (numbers[i] < numbers[j]) {
                    // 如果相差低于 90%
                    if (numbers[j] * 0.9D > numbers[i]) {
                        res--;
                    }
                }
            }
        }
        System.out.println(res);
    }
}

class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] numbers = new int[num];
        for (int i = 0; i < num; i++) {
            numbers[i] = scanner.nextInt();
        }

        int result = 0;
        for (int i = 0; i < num-1; i++) {
            // 判断降序
            boolean desc = true;
            for (int j = i; j < num -i; j++) {
                if (numbers[j] < numbers[j+1]) {
                    desc = false;
                    break;
                }
            }

            // 保持升序
            int temp;
            if ((temp = numbers[i+1] - numbers[i]) < 0 && !desc) {
                numbers[i+1] += temp + 1;
                result += temp + 1;
            }
        }
        System.out.println(result);
    }
}