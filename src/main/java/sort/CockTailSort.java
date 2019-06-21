package sort;

import java.util.Arrays;

/**
 * 鸡尾酒排序
 * 冒泡排序的优化版
 */
public class CockTailSort {
    static void cockTailSort(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            boolean isSorted = true;
            // 从左向右冒泡
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            isSorted = true;
            // 从右向左冒泡
            for (int j = a.length - 2 - i; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    static void optimizedCockTailSort(int[] a) {
        // 鸡尾酒排序的优化1，记录有序区的边界
        int leftUnSortBorder = 0;
        int rightUnSortBorder = a.length - 1;
        int leftLastExchangeIndex = 0;
        int RightLastExchangeIndex = 0;
        for (int i = 0; i < a.length / 2; i++) {
            boolean isSorted = true;
            // 从左向右冒泡
            for (int j = leftUnSortBorder; j < rightUnSortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    isSorted = false;
                    leftLastExchangeIndex = j;
                }
            }
            rightUnSortBorder = leftLastExchangeIndex;
            if (isSorted) {
                break;
            }
            isSorted = true;
            // 从右向左冒泡
            for (int j = rightUnSortBorder; j > leftUnSortBorder; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    isSorted = false;
                    RightLastExchangeIndex = j;
                }
            }
            leftUnSortBorder = RightLastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 1};
        cockTailSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
