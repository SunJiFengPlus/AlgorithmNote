package algorithm.sort;


/**
 * 希尔排序算法
 * @author Zhang Peng
 */
public class ShellSort {
    public <T extends Comparable<T>> void sort(T[] list) {
        int gap = list.length / 2;

        while (1 <= gap) {
            // 把距离为 gap 的元素编为一个组，扫描所有组
            for (int i = gap; i < list.length; i++) {
                int j = 0;
                T temp = list[i];

                // 对距离为 gap 的元素组进行排序
                for (j = i - gap; j >= 0 && temp.compareTo(list[j]) < 0; j = j - gap) {
                    list[j + gap] = list[j];
                }
                list[j + gap] = temp;
            }

            // 减小增量
            gap = gap / 2;
        }
    }
}
