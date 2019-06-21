package sort;

import java.util.*;

/**
 * 桶排序
 * https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653195582&idx=1&sn=1e7ece4e48c20fb994e2cefdcbdce4c5&chksm=8c99ffe4bbee76f23d16ac1e0c7feeb16654ebb75e40d92c911bffa113059f52ce4508281a55&mpshare=1&scene=23&srcid=0621OKXo9yLPHIMpOrt2XPy8#rd
 */
public class BucketSort {
    static double[] bucketSort(double[] a) {
        double min = a[0];
        double max = a[0];
        for (double value : a) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }

        double d = max - min;
        int bucketNum = a.length;
        List<LinkedList<Double>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }
        // 遍历原始数组，将每个元素放入桶中
        for (int i = 0; i < a.length; i++) {
            int num = (int) ((a[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(a[i]);
        }

        // 对每个桶进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }

        double[] sortedArr = new double[a.length];
        int index = 0;
        for (LinkedList<Double> tmp : bucketList) {
            for (Double element : tmp) {
                sortedArr[index++] = element;
            }
        }
        return sortedArr;
    }

    public static void main(String[] args) {
        double[] arr = {10.65, 5.23, 6.58, 4.98, 13.5, 23.8, 16.9};
        double[] sorted = bucketSort(arr);
        System.out.println(Arrays.toString(sorted));
    }
}
