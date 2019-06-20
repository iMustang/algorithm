package sort;

import java.util.Arrays;

/**
 * 快速排序（指针交换法）
 */
public class QuickSort2 {
    static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = division(a, left, right);
        quickSort(a, left, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, right);
    }

    static int division(int[] a, int left, int right) {
        int pivot = a[left];
        int pivotIndex = left;
        int tmp = 0;
        while (left < right) {
            while (left < right && a[right] >= pivot) {
                right--;
            }
            while (left < right && a[left] <= pivot) {
                left++;
            }
            tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
        }
        tmp = a[left];
        a[left] = pivot;
        a[pivotIndex] = tmp;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 7, 9, 0, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
