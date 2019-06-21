package datastructure;

import java.util.Arrays;

/**
 * Heap
 * https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653195207&idx=2&sn=12689c6c1a92e7ec3cce4d423019ec2a&chksm=8c99f91dbbee700b8e760d06b27582037ab0713295dacf2b5a7a7f954c0032fe860aa0bf8b74&scene=21#wechat_redirect
 */
public class Heap {
    private int[] heapArr;

    int[] insertElement(int[] arr, int tmp) {
        heapArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            heapArr[i] = arr[i];
        }
        heapArr[heapArr.length - 1] = tmp;
        int childIndex = heapArr.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0 && tmp < heapArr[parentIndex]) {
            heapArr[childIndex] = heapArr[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        heapArr[childIndex] = tmp;
        return this.heapArr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 5, 7, 8, 9, 10};
        Heap heap = new Heap();
        int[] heapArr = heap.insertElement(arr, 0);
        System.out.println(Arrays.toString(heapArr));
    }
}
