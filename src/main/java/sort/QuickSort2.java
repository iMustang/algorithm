package sort;

import java.util.Arrays;

/**
 * 快速排序(挖坑法）
 * http://www.sohu.com/a/246785807_684445
 * https://www.jianshu.com/p/5f38dd54b11f
 */
public class QuickSort2 {
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

    /**
     * 挖坑法另一种表达
     */
    static int division2(int[] a, int left, int right) {
        int pivot = a[left];
        while (left < right) {
            // 从右向左找比pivot小的元素
            while (left < right && a[right] >= pivot) {
                right--;
            }
            if (left < right) {
                a[left] = a[right];
                left++;
            }
            // 从左向右找比pivot大的元素
            while (left < right && a[left] <= pivot) {
                left++;
            }
            if (left < right) {
                a[right] = a[left];
                right--;
            }
        }
        // left==right
        a[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 7, 9, 0, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
