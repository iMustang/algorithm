package programmingpearl.str;

/**
 * FindLongestRepeatSubstring
 * description: 找出文本中最长的重复子字符串
 */
public class FindLongestRepeatSubstring {
	public static void main(String[] args) {
		String str = "Ask not what your country can do for you, but what you can do for your country";
//		String str = "banana";
//		String str = "ba";
		int length = str.length();

		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = i;
		}
		quickSort(arr, 0, arr.length - 1, str);

		// 重复子串的长度
		int maxRepeatLength = 0;
		// 重复子串在字符串中的起始位置
		int pos = 0;
		for (int i = 1; i < arr.length; i++) {
			int tmp = getLongSameSubstringFromBegining(arr[i - 1], arr[i], str);
			if (tmp > maxRepeatLength) {
				maxRepeatLength = tmp;
				pos = arr[i - 1];
			}
		}
		System.out.println(str.substring(pos, pos + maxRepeatLength));
	}

	static void quickSort(int[] a, int left, int right, String str) {
		if (left >= right) {
			return;
		}
		int pivotIndex = division(a, left, right, str);
		quickSort(a, left, pivotIndex - 1, str);
		quickSort(a, pivotIndex + 1, right, str);
	}

	static int division(int[] a, int left, int right, String str) {
		int pivot = a[left];
		int pivotIndex = left;
		int tmp = 0;
		while (left < right) {
			while (left < right && compareStr(a[right], pivot, str) == 1) {
				right--;
			}
			while (left < right && compareStr(a[left], pivot, str) == -1) {
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

	/**
	 * 比较两个子串的大小
	 *
	 * @param a   第一个子串的起始位置
	 * @param b   第二个子串的起始位置
	 * @param str
	 * @return
	 */
	static int compareStr(int a, int b, String str) {
		int length = str.length();
		int from = a > b ? a : b;
		for (; from < length; from++) {
			if (str.charAt(a) > str.charAt(b)) {
				return 1;
			}
			if (str.charAt(a) < str.charAt(b)) {
				return -1;
			}
		}
		// 实现搜索最长子串时，使用后缀数组，因此此处a，b永远不相等，不需要判断是否返回0
		return (length - a) > (length - b) ? 1 : -1;
	}

	/**
	 * 两个子串左对齐后，从左侧开始比较相同字符出现的长度
	 *
	 * @param a   第一个子串的起始位置，结束位置为str.length
	 * @param b   第二个子串的起始位置，结束位置为str.length
	 * @param str
	 * @return
	 */
	static int getLongSameSubstringFromBegining(int a, int b, String str) {
		int max = a > b ? a : b;
		int length = 0;
		for (; max < str.length(); max++) {
			if (str.charAt(a++) != str.charAt(b++))
				break;
			length++;
		}
		return length;
	}
}
