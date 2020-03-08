package examination.netease.autumn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 孙继峰
 * @date 2019/08/02
 */
public class Bumper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int heapNum = scanner.nextInt();
        int[] numPerHeap = new int[heapNum];
        for (int i = 0; i < heapNum; i++) {
            numPerHeap[i] = scanner.nextInt();
        }
        int answerNum = scanner.nextInt();
        int[] index = new int[answerNum];
        for (int i = 0; i < answerNum; i++) {
            index[i] = scanner.nextInt();
        }

        int[] answers = answer2(heapNum, numPerHeap, answerNum, index);
        for (int answer : answers) {
            System.out.println(answer);
        }
    }

    /**
     * 30.00%, timeout, 我的提交
     */
    public static int[] answer(int heapNum, int[] numPerHeap, int answerNum, int[] index) {
        int[] answer = new int[answerNum];
        for (int i = 0; i < answerNum; i++) {
            int j = 0, count = numPerHeap[j];
            while (count < index[i]) {
                count += numPerHeap[++j];
            }
            answer[i] = j + 1;
        }
        return answer;
    }

    /**
     * 100%
     */
    public static int[] answer2(int heapNum, int[] numPerHeap, int answerNum, int[] index) {
        int[] answer = new int[answerNum];
        int[] sum = new int[heapNum];

        sum[0] = numPerHeap[0];
        for (int i = 1; i < heapNum; i++) {
            sum[i] = sum[i-1] + numPerHeap[i];
        }

        for (int i = 0; i < answerNum; i++) {
            answer[i] = Arrays.binarySearch(sum, index[i]);
            answer[i] = answer[i] < 0? -answer[i]: answer[i] +1;
        }
        return answer;
    }
}
