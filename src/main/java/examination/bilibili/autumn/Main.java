package examination.bilibili.autumn;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 孙继峰
 * @date 2019/08/20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            stringBuilder.append(words[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        System.out.println(stringBuilder.toString());
    }
}

class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] temp = scanner.nextLine().split(",");
        List<String> list = new ArrayList<>();
        for (int i = 0, length = temp.length; i < length; i++) {
            list.add(temp[i]);
        }

        StringBuilder result = new StringBuilder();
        boolean isFirst = true;

        while (list.size() > 0) {
            int minIndex = -1;
            // ascii 码比数字大
            String minValue = ":";
            for (int i = 0, length = list.size(); i < length; i++) {
                String currentValue = list.get(i);
                if (minValue.compareTo(currentValue) > 0) {
                    if (isFirst && "0".equals(currentValue)) {
                        // do nothing
                    } else {
                        minValue = currentValue;
                        minIndex = i;
                        isFirst = false;
                    }
                }
            }
            result.append(minValue);
            list.remove(minIndex);
        }
        System.out.println(result.toString());
    }
}

class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] eqWeight = new int[num];
        // 剩余承重
        int canBearing = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            eqWeight[i] = scanner.nextInt();
        }
        int[] eqValue = new int[num];
        for (int i = 0; i < num; i++) {
            eqValue[i] = scanner.nextInt();
        }
        // 性价比
        double[] rate = new double[5];
        for (int i = 0; i < num; i++) {
            rate[i] = (double) eqValue[i] / eqWeight[i];
        }
        List<Equ> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(new Equ(eqValue[i], eqWeight[i], rate[i]));
        }

        // 每次选出一个性价比最高的装备
        int value = 0;
        double maxRate = 0;
        for (int i = 0, length = list.size(); i < length; i++) {
            double currentRate = list.get(i).rate;
            if (maxRate > currentRate) {

            }
        }
    }

    static class Equ {
        int value;
        int weight;
        double rate;

        Equ(int value, int weight, double rate) {
            this.rate =rate;
            this.value=value;
            this.weight=weight;
        }
    }
}