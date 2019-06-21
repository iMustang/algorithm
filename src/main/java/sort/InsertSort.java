package sort;

import java.util.Arrays;

/**
 * 直接插入排序
 * 与打扑克时整理牌原理相同：将新的牌与已有的牌从后向前一张张比较，插入合适位置
 * 因为前面序列是有序的，如1,3,4,6，再插入5时，5<6，需要继续往前比较，5>4，不需要再比较，要break
 */
public class InsertSort {
    static void insertSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6, 9, 0, 8, 5, 3};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
