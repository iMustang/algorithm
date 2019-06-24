package topic;

/**
 * @Title: Pow2
 * 判断一个数是不是2的幂
 */
public class Pow2 {
	/**
	 * 2的幂满足一个规律：如果N=2^x，那么N&(N-1)=0
	 */
	static boolean isPowerOf2(int input) {
		return (input & (input - 1)) == 0;
	}

	/**
	 * 求一个正整数转换成二进制后的数字1的个数，要求性能尽可能高
	 * <p>
	 * 一个数N，N&1 要么是0，要么是1。结果为1，说明最低位是1。为0，说明最低位是0。
	 * <p>
	 * 因此，每次&后，都右移一位，再次&，直到N右移变为0为止。
	 */
	static int computeCountOfOneInBit(int input) {
		int count = 0;
		while (input > 0) {
			if ((input & 1) == 1) {
				count++;
			}
			input = input >> 1;
		}
		return count;
	}

	public static void main(String[] args) {
		int a = 1024;
		System.out.println(isPowerOf2(a));
//		1 0101 0010 1111
		System.out.println(computeCountOfOneInBit(5423));
	}


}
