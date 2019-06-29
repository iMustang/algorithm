package search;

/**
 * @title: SequencialSearch
 * @description: 顺序查找带哨兵
 */
public class SequencialSearch {
	/**
	 * 顺序查找，使用哨兵优化操作。
	 * 在数据量小时，顺序查找可以使用
	 */
	static int sequencialSearch(int[] arr, int key) {
		if (arr[0] == key) {
			return 0;
		}
		arr[0] = key;
		int i = arr.length - 1;
		while (arr[i--] != key) ;// 减少了使用for时的一次比较操作（i<=arr.length）
		if (++i >= 2) return i;
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(sequencialSearch(arr, 3));
		System.out.println(sequencialSearch(arr, 5));
		System.out.println(sequencialSearch(arr, 0));
	}
}
