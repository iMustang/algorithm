package sort;

import java.util.Arrays;

/**
 * 计数排序
 * https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653195533&idx=1&sn=02918dc51b07837ce1119f00d7900dbc&chksm=8c99ffd7bbee76c1d2e2e9b198259795285ec2c305d3613a5e39622195fd1c32bb6dbe52fa08&mpshare=1&scene=23&srcid=0621Le71ExinA8A14lY1tnuE%23rd
 */
public class CountSort {
    static int[] countSort(int[] a) {
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        int[] countArr = new int[max - min + 1];
        for (int i = 0; i < a.length; i++) {
            countArr[a[i] - min]++;
        }
        int[] sortedArr = new int[a.length];
        int k = 0;
        for (int i = 0; i < countArr.length; i++) {
            for (int j = countArr[i]; j > 0; j--) {
                sortedArr[k++] = min + i;
            }
        }
        return sortedArr;
    }

    /**
     * 稳定的计数排序
     */
    static int[] stableCountSort(int[] a) {
        int min = a[0];
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        int[] countArr = new int[max - min + 1];
        for (int i = 0; i < a.length; i++) {
            countArr[a[i] - min]++;
        }
        for (int i = 0; i < countArr.length - 1; i++) {
            countArr[i + 1] = countArr[i + 1] + countArr[i];
        }
        int[] sortedArr = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            // 要联系上面的countArr[i + 1] = countArr[i + 1] + countArr[i];理解
            // countArr元素相加后，会得出a中相应元素的排序位置。
            sortedArr[countArr[a[i] - min] - 1] = a[i];
            countArr[a[i] - min]--;
        }
        return sortedArr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 8, 6, -1};
        int[] sortedArr = stableCountSort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }
}
