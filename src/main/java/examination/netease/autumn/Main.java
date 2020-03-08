package examination.netease.autumn;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 孙继峰
 * @date 2019/08/03
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int personNum = scanner.nextInt();
        Student[] students = new Student[personNum];
        for (int i = 0; i < personNum; i++) {
            students[i] = new Student(i,scanner.nextInt());
        }
        int queryNum = scanner.nextInt();
        int[] querys = new int[queryNum];
        for (int i = 0; i < queryNum; i++) {
            querys[i] = scanner.nextInt();
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.######");
        Arrays.sort(students);
        for (int i = 0; i < queryNum; i++) {
            for (int j = personNum-1; j >= 0; j--) {
                int firstScoreIndex = personNum-1;
                int firstScore = students[personNum-1].score;
                if (students[j].score != firstScore ) {
                    firstScoreIndex = j;
                    firstScore = students[j].score;
                }

                if (querys[i] == students[j].index + 1) {
                    String res = decimalFormat.format((double) firstScoreIndex / personNum * 100);
                    System.out.println(res.equals("0")? "0.000000" : res);
                }
            }
        }
    }

    private static class Student implements Comparable<Student> {
        int index;
        int score;

        public Student(int index, int score) {
            this.index = index;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return this.score - o.score;
        }
    }
}
