package examination.liulishuo.autumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 孙继峰
 * @date 2019/08/19
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        int size = list.size();
        List<Integer> arrive = list.subList(0, (size / 2) - 1);
        List<Integer> left = list.subList(size / 2, size - 1);

        List<Integer> res = new ArrayList<>();
        res.add(Integer.MIN_VALUE);
        for (int i = 0; i < arrive.size(); i++) {
            for (int j = 0; j < res.size(); j++) {
                if (res.get(j) <= arrive.get(i)) {
                    res.set(j, left.get(i));
                } else {
                    list.add(left.get(i));
                }
            }
        }
        System.out.println(res.size());
    }
}
