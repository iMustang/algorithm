package sort;

import java.util.Arrays;

/**
 * 快速排序（指针交换法）
 * 先从序列中选出一个数作为基准值（pivot）
 * 将比pivot小的数全部放在pivot的左边，大于或等于pivot的数全部放在pivot的右边
 * 对pivot两侧两个子序列重复上面步骤，直到各区间只有1个数
 * 分治
 * <p>
 * 时间复杂度：
 * 平均情况O(n)*O(logn)
 * 最坏情况O(n)*O(n)
 * <p>
 * 快速排序时间复杂度（c*O(n*logn)）常量比归并排序小的多。
 */
public class QuickSort {
	static void quickSort(int[] a, int left, int right) {
		// 控制递归结束条件
		if (left >= right) {
			return;
		}
		int pivotIndex = division(a, left, right);
		quickSort(a, left, pivotIndex - 1);
		quickSort(a, pivotIndex + 1, right);
	}

	static int division(int[] a, int left, int right) {
		int pivot = a[left];
		int pivotIndex = left;
		int tmp;
		while (left < right) {
			// 从右向左找比pivot小的元素
			while (left < right && a[right] >= pivot) {
				right--;
			}
			// 从左向右找比pivot大的元素
			while (left < right && a[left] <= pivot) {
				left++;
			}
			tmp = a[left];
			a[left] = a[right];
			a[right] = tmp;
		}
		tmp = a[left];
		a[left] = pivot;
		a[pivotIndex] = tmp;
		return left;
	}

	public static void main(String[] args) {
		int[] arr = {3, 5, 2, 1, 7, 9, 0, 4};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
