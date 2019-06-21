package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 相邻两元素比较，较大的数下沉，较小的数冒起来。
 * https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653194666&idx=1&sn=69ce32870c0b981c40b1e124fbb6bba8&chksm=8c99fb70bbee72668cad223892ad362525d215e7f936458f99dd289eb82981099359310e9e54&mpshare=1&scene=23&srcid=0621v2MyKNnL9fRphFqb4yG3#rd
 * 从小到大排序时，相邻两元素比较，大的放在右边，小的放在左边，第一趟冒泡结束后，最右侧元素为最大元素。
 * 每一趟冒泡时，都能把当前子列中最大值冒泡到子列最右侧。
 * <p>
 * 稳定排序，时间复杂度O(N^2)
 * <p>
 * 以下优化冒泡排序思路中，从小到大排序时，记得：
 * 1. 每趟冒泡都会让当前子列中最大值冒泡到子列最右侧。
 * 2. 第n趟冒泡后，从右侧起数n个元素，是有序区，有序区内的元素都比有序区外的元素大。
 */
public class BubbleSort {
    static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {// i表示趟数
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化后的冒泡排序（左右两侧同时优化，先优化左侧，再优化右侧）
     */
    static void optimizedBubbleSort(int[] a) {
        int lastExchangeIndex = 0;
        // 右侧是有序区，记录下无序区的边界
        int unSortedBorder = a.length - 1;
        for (int i = 0; i < a.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < unSortedBorder; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            // 优化2，第n趟冒泡后，最右侧n个元素一定是有序的，可能因为原序列的关系，右侧的有序区会大于n。
            // 如0,3,5,6,4,7，第1（n）趟冒泡后，变成0,3,5,4,6,7（lastExchangeIndex=3），右侧2（n+1或a.length-1-lastExchangeIndex）个元素组成有序区
            // 记录下每趟冒泡时，最后交换元素的位置（lastExchangeIndex），则lastExchangeIndex右侧是有序区，后面冒泡时，不需进入这个变大后的有序区。
            unSortedBorder = lastExchangeIndex;
            // 优化1，每次冒泡都从左侧开始，如果左侧有序了，不需要再执行剩下的冒泡趟数
            // 如1,2,3,5,4，第1趟冒泡后，变成1,2,3,4,5，不需要再执行剩下的冒泡趟数
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 16, 4, 7, 3, 8, 18, 13, 19, 27, 41, 26, 5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {1, 2, 3, 5, 4, 6, 7, 8};
        optimizedBubbleSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
