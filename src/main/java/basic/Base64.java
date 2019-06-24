package basic;

import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Base64编码
 * https://www.choupangxia.com/topic/detail/61
 */
public class Base64 {
	/**
	 * Base64只支持64个可打印字符，见Base64字符.png
	 * ASCII编码0-31、127属于控制字符，32-126属于可打印字符
	 * <p>
	 * 传输图片时，图片的二进制数据，如果用ASCII编码，编码后会有控制字符。早期的一些网络传输协议，只能传输ASCII码中的可打印字符。
	 * <p>
	 * 网络传输协议传输可打印字符的理解：
	 * 传输协议也有自己的编码，只能传输可打印字符，编码不一定与ASCII编码相同。
	 * 假设传输协议的编码表为：a（00）、b（01）、c（10）、d（11）
	 * 如果要传输字符e，传输协议是办不到的。那么可以设计编码表，如将d设计成010010，就对应到传输协议的bac，传输协议发送端发送bac，接收端就收到bac，之后再利用设计的编码表解码成e
	 * <p>
	 * Base64编码一个字符占6bit。将要传输的二进制数据每6bit编码成Base64字符，之后就可以用早期的网络传输协议传输了。
	 * 对于最后不足6bit的数据，单独处理，补0、=，见Base64不足3个字符.png
	 */
	public static void main(String[] args) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		String str = "A";
		String encode = base64Encoder.encode(str.getBytes());
		System.out.println(encode);

		System.out.println(Arrays.toString("A".getBytes()));
		System.out.println(Charset.defaultCharset());

		System.out.println("0X" + new BigInteger("A".getBytes()).toString(16));
	}
}
