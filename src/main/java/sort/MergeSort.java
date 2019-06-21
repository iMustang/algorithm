package sort;

import java.util.Arrays;

/**
 * 归并排序
 * https://www.jianshu.com/p/33cffa1ce613
 * 已知合并两个有序序列的算法，归并排序先将数列递归分成有序的序列，再递归合并相邻的有序序列
 * 时间复杂度O(NlogN)
 * 将数列递归logN次，每次都会分成有序子数列，每次分成的有序子数列进行归并，每次归并的复杂度为O(N)
 * 所以总共时间复杂度为O(N*logN)
 * 分治+归并
 */
public class MergeSort {
    // 将两个有序序列合并成一个有序序列
    // 将arr[left,mid]、arr[mid+1,right]看成两个有序序列，合并成一个有序序列（temp）
    public static void merge(int[] arr, int left, int right) {
        int[] temp = new int[right - left + 1];
        int mid = (left + right) / 2;
        int i = 0;
        int j = left;
        int k = mid + 1;
        while (j <= mid && k <= right) {
            if (arr[j] <= arr[k]) {
                temp[i++] = arr[j++];
            } else {
                temp[i++] = arr[k++];
            }
        }
        while (j <= mid) {
            temp[i++] = arr[j++];
        }
        while (k <= right) {
            temp[i++] = arr[k++];
        }
        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }

    public static void mergeSort(int[] a, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        merge(a, left, right);
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 2, 1, 4, 5, 7, 9};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
