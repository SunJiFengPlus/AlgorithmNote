package examination.kuaishou.autumn;

import java.util.Scanner;

/**
 * 版本号比较
 *
 * @author 孙继峰
 * @date 2019/08/25
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        String[] inputs = new String[num];
        for (int i = 0; i < num; i++) {
            inputs[i] = scanner.nextLine();
            System.out.println(compareVersion(inputs[i]));
        }
    }

    private static boolean compareVersion(String line) {
        int spaceIndex = line.indexOf(' ');
        for (int i = 0; i < spaceIndex; i++) {
            if (spaceIndex + i + 1 > line.length()) {
                return false;
            }
            if (line.charAt(i) < line.charAt(i + spaceIndex + 1)) {
                return true;
            }
        }
        return false;
    }
}

class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int number = scanner.nextInt();
            while (number > 0) {
                
            }
        }
    }
}