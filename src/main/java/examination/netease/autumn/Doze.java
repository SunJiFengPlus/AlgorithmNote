package examination.netease.autumn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author 孙继峰
 * @date 2019/08/02
 */
public class Doze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        int stayAwake = scanner.nextInt();
        int[] interest = new int[min];
        int[] awake = new int[min];
        for (int i = 0; i < min; i++) {
            interest[i] = scanner.nextInt();
        }
        for (int i = 0; i < min; i++) {
            awake[i] = scanner.nextInt();
        }
        System.out.println(score(min, stayAwake, interest, awake));
    }

    /**
     * 90%, timeout, 我的提交
     */
    public static int score(int min, int stayAwake, int[] interest, int[] awake) {
        int score = 0;
        List<Integer> extraScores = new ArrayList<>();
        for (int i = 0; i < min; i++) {
            if (awake[i] != 0) {
                score += interest[i];
            } else {
                int extraScore = 0;
                for (int j = i; j < i + stayAwake && j < min; j++) {
                    if (awake[j] == 0) {
                        extraScore += interest[j];
                    }
                }
                extraScores.add(extraScore);
            }
        }
        return Collections.max(extraScores) + score;
    }
}
