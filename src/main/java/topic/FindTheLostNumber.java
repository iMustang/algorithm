package topic;

/**
 * @Title: FindTheLostNumber
 * 找出丢失的数字
 */
public class FindTheLostNumber {
	/**
	 * 长度为99的数组存储1-100的数字，数字不重复，且无序，找出未存储的数字
	 */
	static int findLostNumberInNoRepeatedArray(int[] arr) {
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			count += i;
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += i;
		}
		return count - sum;
	}

	/**
	 * 一个无序数组里有若干个正整数，范围从1到100，其中99个整数都出现了偶数次，只有一个整数出现了奇数次，找到这个出现奇数次的整数
	 * <p>
	 * 异或运算：异或在位运算时相同为0，不同为1
	 * 将这些数字异或最后得出的就是结果
	 */
	static int findSingleNumberInThisKindArray(int[] arr) {
		int result = arr[0];
		for (int i = 1; i < arr.length; i++) {
			result = result ^ arr[i];
		}
		return result;
	}

	public static void main(String[] args) {
		// 下面要输如99个数字，这里不输入了
		int[] arr = {1, 2, 3, 4};
		System.out.println(findLostNumberInNoRepeatedArray(arr));

		int[] arr1 = {1, 2, 2, 3, 4, 3, 4};
		System.out.println(findSingleNumberInThisKindArray(arr1));
	}
}
