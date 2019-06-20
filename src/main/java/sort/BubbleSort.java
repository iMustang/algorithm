package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 相邻两个数比较大小，较大的数下沉，较小的数冒起来。
 */
public class BubbleSort {
    static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {// i表示趟数
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 16, 4, 7, 3, 8, 18, 13, 19, 27, 41, 26, 5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
