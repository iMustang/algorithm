package sort;

import java.util.Arrays;

/**
 * 快速排序
 * http://www.sohu.com/a/246785807_684445
 * https://www.jianshu.com/p/5f38dd54b11f
 */
public class QuickSort {
    static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = division(a, left, right);
        quickSort(a, left, pivot - 1);
        quickSort(a, pivot + 1, right);
    }

    static int division(int[] a, int left, int right) {
        int pivot = a[left];
        while (left < right) {
            while (left < right && a[right] >= pivot) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= pivot) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
