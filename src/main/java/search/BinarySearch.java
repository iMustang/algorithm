package search;

import java.util.Arrays;

/**
 * 二分查找
 * 二分查找的前提是序列是有序的
 */
public class BinarySearch {

	static int binarySearch(int[] arr, int item) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == item) {
				return mid;
			}
			if (arr[mid] < item) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 13, 19, 21, 37, 56, 64, 75, 80, 88};
		// 二分查找的前提是序列有序
		Arrays.sort(arr);
		int index = binarySearch(arr, 21);
		System.out.println(index);
	}

}
