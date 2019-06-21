package sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 希尔排序在数组中采用跳跃式分组的策略，通过某个增量将数组元素划分为若干组，然后分组进行插入排序，随后逐步缩小增量，继续按组进行插入排序操作，直至增量为1。
 * 分治+插入排序
 */
public class ShellSort {
    static void shellSort(int[] a) {
        int n = a.length;
        for (int gap = n / 2; gap > 0; gap = gap / 2) {
            // [4,3,2,1]，第一次gap=2，分成两组[4,2]、[3,1]，此时a[gap]处为2，是第一个分组
            for (int i = gap; i < a.length; i++) {
                for (int j = i; j > gap - 1; j = j - gap) {
                    if (a[j] < a[j - gap]) {
                        int tmp = a[j];
                        a[j] = a[j - gap];
                        a[j - gap] = tmp;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 8, 0, 5, 2, 6};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
