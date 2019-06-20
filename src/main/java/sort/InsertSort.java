package sort;

import java.util.Arrays;

/**
 * 直接插入排序
 * 与打扑克时整理牌原理相同：将新的牌与已有的牌从后向前一张张比较，插入合适位置
 */
public class InsertSort {
    static void sort(int[] a) {
        int n = a.length;
        int temp = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6, 9, 0, 8, 5, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
