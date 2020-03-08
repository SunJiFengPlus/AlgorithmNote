package examination.netease.autumn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author 孙继峰
 * @date 2019/08/03
 */
public class Tower {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        InnerTower[] innerTowers = new InnerTower[n];
        Queue<InnerTower> minQue = new PriorityQueue<>(n, Comparator.comparingInt(o -> o.num));
        Queue<InnerTower> maxQue = new PriorityQueue<>(n, Comparator.comparingInt(o -> -o.num));
        for (int i = 1; i <= n; i++) {
            InnerTower temp = new InnerTower(i, in.nextInt());
            minQue.add(temp);
            maxQue.add(temp);
        }

        // 最小稳定值
        int s = 0;
        // 移动次数
        int times = 0;
        // 记录移动的索引
        int[][] move = new int[k][2];
        while (times < k) {
            // 最低的塔
            InnerTower min = minQue.poll();
            // 最高的塔
            InnerTower max = maxQue.poll();
            // 如果最低塔和最高塔高度相等或者相差为1，就没必要继续了
            if (max.num - min.num <= 1) {
                break;
            }
            // 最低塔高度增加1，最高塔高度减少1
            min.num = min.num + 1;
            max.num = max.num - 1;
            move[times][0] = max.id;
            move[times][1] = min.id;
            minQue.add(min);
            maxQue.add(max);
            times++;
        }
        s = maxQue.peek().num - minQue.peek().num;
        System.out.println(s + " " + times);
        for (int i = 0; i < times; i++) {
            System.out.println(move[i][0] + " " + move[i][1]);
        }

    }

    public static class InnerTower {
        int id;
        int num;

        InnerTower(int id, int num) {
            this.id = id;
            this.num = num;
        }
    }
}
