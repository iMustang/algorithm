package search;

import java.util.Arrays;

/**
 * @title: InterpolationSearch
 * @description: 插值查找
 */
public class InterpolationSearch {
	/**
	 * 同样是对有序集合查找，二分查找是mid=(low+high)/2=low+(high-low)/2
	 * 插值查找是：mid=low+(key-a[low])*(high-low)/(a[high]-a[low])
	 *
	 * 插值查找对于表长较大，数据分布比较均匀的情况比较合适。
	 */
	static int interpolationSearch(int[] arr, int key) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = low + (key - arr[low]) * (high - low) / (arr[high] - arr[low]);
			if (arr[mid] == key) {
				return mid;
			}
			if (arr[mid] < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {5, 13, 19, 21, 37, 56, 64, 75, 80, 88};
		// 二分查找的前提是序列有序
		Arrays.sort(arr);
		int index = interpolationSearch(arr, 21);
		System.out.println(index);
		System.out.println(interpolationSearch(arr, 80));
	}
}
