package sort;

import java.util.Arrays;

/**
 * 选择排序
 * 首先找到数组中最小的那个元素，然后将它和数组的第一个元素交换位置（如果第一个元素就是最小元素，那么它就和自己交换）；
 * 再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置；如此往复，直到将整个数组有序
 */
public class SelectSort {
    static void sort(int[] a) {
        int minIndex = 0;
        for (int i = 0; i < a.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 2, 5, 2, 6, 7};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
