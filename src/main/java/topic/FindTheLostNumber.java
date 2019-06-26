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

	/**
	 * 一个无序数组里有若干个正整数，范围从1到100，其中98个整数都出现了偶数次，只有两个整数出现了奇数次（比如1,1,2,2,3,4,5,5），如何找到这个出现奇数次的整数？
	 * <p>
	 * 遍历整个数组，依次做异或运算。由于数组存在两个出现奇数次的整数，所以最终异或的结果，等同于这两个整数的异或结果。这个结果中，至少会有一个二进制位是1（如果都是0，说明两个数相等，和题目不符）。
	 * 举个例子，如果最终异或的结果是5，转换成二进制是00000101。此时我们可以选择任意一个是1的二进制位来分析，比如末位（如果末位不为1，比如第3位为1，那么所有的数向右移动两位）。把两个奇数次出现的整数命名为A和B，如果末位是1，说明A和B转为二进制的末位不同，必定其中一个整数的末位是1，另一个整数的末位是0。
	 * 根据这个结论，我们可以把原数组按照二进制的末位不同，分成两部分，一部分的末位是1，一部分的末位是0。由于A和B的末位不同，所以A在其中一部分，B在其中一部分，绝不会出现A和B在同一部分，另一部分没有的情况。
	 */

	static void findTwoDiffrentOnlyOccurOnce(int[] arr) {
		int sum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			sum = sum ^ arr[i];
		}
		int i = 0;
		// 判断是第几位为1
		while (((sum >> i) & 1) != 1) {
			i++;
		}
		int a = 1;
		int b = 1;
		for (int j = 0; j < arr.length; j++) {
			if (((arr[j] >> i) & 1) == 1) {
				a = a ^ arr[j];
			} else {
				b = b ^ arr[j];
			}
		}
		a = a ^ 1;
		b = b ^ 1;
		System.out.println("one number: " + a);
		System.out.println("the other number: " + b);
	}

	public static void main(String[] args) {
		// 下面要输如99个数字，这里不输入了
		int[] arr = {1, 2, 3, 4};
		System.out.println(findLostNumberInNoRepeatedArray(arr));

		int[] arr1 = {1, 2, 2, 3, 4, 3, 4};
		System.out.println(findSingleNumberInThisKindArray(arr1));

		int[] arr2 = {2, 2, 3, 3, 4, 6, 6, 7, 7, 8, 8, 9, 9, 10};
		findTwoDiffrentOnlyOccurOnce(arr2);
	}
}
