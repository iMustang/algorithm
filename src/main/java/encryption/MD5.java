package encryption;

/**
 * MD5（Message-digest algorithm 5）是信息摘要的一种实现
 * 信息摘要把明文内容按某种规则生成一段哈希值，即使明文消息只改动一点点，生成的结果也会完全不同
 * MD5可以从任意长度的明文字符串生成128位的哈希值，也就是32位的16进制数
 *
 * https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653191642&idx=1&sn=47c6340a6664af2f62e6c580528ea6f6&chksm=8c990f00bbee861698daa51b0622e581b3279c0759a16330fe538de745cb6abed8288b0bd778&mpshare=1&scene=23&srcid=0622zKTzB57q9wvrDV5GDAjF#rd
 */
public class MD5 {
	/**
	 * MD5保证了哈希值的均匀分布、加密安全性
	 *
	 * MD5使用场景：
	 * 发送方：业务参数+秘钥拼接成字符串，假定是str，对str做MD5生成sign，发送业务参数、sign
	 * 接收方：接收的业务参数+秘钥拼接成字符串，假定是str1，对str1做MD5生成sign2，比较sign2与接收到的sign
	 *
	 * MD5算法：
	 * 处理原文，设置初始值，循环加工，拼接结果
	 * 1. 处理原文
	 * 原文长度(bit)对512求余，如果不等于448，填充原文使得对512求余的结果等于448。填充的方法是第一位填充1，其余位填充0。填充完后，信息的长度(bit)就是512*N+448。
	 * 剩余的位置（512-448=64位）记录原文的真正长度，把长度的二进制值补在最后。
	 * 处理后的信息长度就是512*(N+1)。
	 *
	 * 2. 设置初始值
	 * MD5的哈希结果长度为128位，每32位分成一组，共分成4组。这4组结果是由4个初始值A、B、C、D不断演变得到。
	 * MD5的官方实现中，A、B、C、D的初始值如下（16进制）：
	 *
	 * A=0x01234567
	 * B=0x89ABCDEF
	 * C=0xFEDCBA98
	 * D=0x76543210
	 *
	 * 3. 循环加工
	 * 上面第1步处理后的原文长度为 M = 512*(N+1)
	 * 循环加工时，主循环次数= M/512，每个主循环中包含512/32*4=64次子循环
	 * 每一个子循环的过程见MD5单次子循环.png
	 *
	 * 绿色F，代表非线性函数。官方MD5所用到的函数有四种：
	 *
	 * F(X,Y,Z) = (X&Y)|((~X)&Z)
	 * G(X,Y,Z) = (X&Z)|(Y&(~Z))
	 * H(X,Y,Z) = X^Y^Z
	 * I(X,Y,Z) = Y^(X|(~Z))
	 *
	 * 每次主循环下面64次子循环中，F、G、H、I 交替使用，第一个16次子循环使用F，第二个16次使用G，第三个16次使用H，第四个16次使用I。
	 *
	 * 红色的田字代表相加。
	 * Mi是上面第1步处理后的原文，处理后的原文长度是512的整数倍。把原文的每512位再分成16等份，命名为M0~M15，每一份长度32。在64次子循环中，每16次循环，都会交替用到M1~M16之一。
	 * Ki是一个常量，在64次子循环中，每一次用到的常量都是不同的。
	 * 黄色的<<<S是左移S位，S的值也是常量。
	 *
	 * 新ABCD的产生：
	 * 		新A = 原d
	 *		新B = b+((a+F(b,c,d)+Mj+Ki)<<<s)
	 * 		新C = 原b
	 * 		新D = 原c
	 *
	 * 下面给出每次主循环中64次子循环：
	 * 第1个16次子循环：
	 * 	   FF(a,b,c,d,M0,7,0xd76aa478)    s[0]=7,   K[0] = 0xd76aa478
	 * 　　FF(a,b,c,d,M1,12,0xe8c7b756)   s[1]=12,  K[1] = 0xe8c7b756
	 * 　　FF(a,b,c,d,M2,17,0x242070db)
	 * 　　FF(a,b,c,d,M3,22,0xc1bdceee)
	 * 　　FF(a,b,c,d,M4,7,0xf57c0faf)
	 * 　　FF(a,b,c,d,M5,12,0x4787c62a)
	 * 　　FF(a,b,c,d,M6,17,0xa8304613)
	 * 　　FF(a,b,c,d,M7,22,0xfd469501)
	 * 　　FF(a,b,c,d,M8,7,0x698098d8)
	 * 　　FF(a,b,c,d,M9,12,0x8b44f7af)
	 * 　　FF(a,b,c,d,M10,17,0xffff5bb1)
	 * 　　FF(a,b,c,d,M11,22,0x895cd7be)
	 * 　　FF(a,b,c,d,M12,7,0x6b901122)
	 * 　　FF(a,b,c,d,M13,12,0xfd987193)
	 * 　　FF(a,b,c,d,M14,17, 0xa679438e)
	 * 　　FF(a,b,c,d,M15,22,0x49b40821)
	 *
	 * 第2个16次子循环：
	 * 　　GG(a,b,c,d,M1,5,0xf61e2562)
	 * 　　GG(a,b,c,d,M6,9,0xc040b340)
	 * 　　GG(a,b,c,d,M11,14,0x265e5a51)
	 * 　　GG(a,b,c,d,M0,20,0xe9b6c7aa)
	 * 　　GG(a,b,c,d,M5,5,0xd62f105d)
	 * 　　GG(a,b,c,d,M10,9,0x02441453)
	 * 　　GG(a,b,c,d,M15,14,0xd8a1e681)
	 * 　　GG(a,b,c,d,M4,20,0xe7d3fbc8)
	 * 　　GG(a,b,c,d,M9,5,0x21e1cde6)
	 * 　　GG(a,b,c,d,M14,9,0xc33707d6)
	 * 　　GG(a,b,c,d,M3,14,0xf4d50d87)
	 * 　　GG(a,b,c,d,M8,20,0x455a14ed)
	 * 　　GG(a,b,c,d,M13,5,0xa9e3e905)
	 * 　　GG(a,b,c,d,M2,9,0xfcefa3f8)
	 * 　　GG(a,b,c,d,M7,14,0x676f02d9)
	 * 　　GG(a,b,c,d,M12,20,0x8d2a4c8a)
	 *
	 * 第3个16次子循环：
	 * 　　HH(a,b,c,d,M5,4,0xfffa3942)
	 * 　　HH(a,b,c,d,M8,11,0x8771f681)
	 * 　　HH(a,b,c,d,M11,16,0x6d9d6122)
	 * 　　HH(a,b,c,d,M14,23,0xfde5380c)
	 * 　　HH(a,b,c,d,M1,4,0xa4beea44)
	 * 　　HH(a,b,c,d,M4,11,0x4bdecfa9)
	 * 　　HH(a,b,c,d,M7,16,0xf6bb4b60)
	 * 　　HH(a,b,c,d,M10,23,0xbebfbc70)
	 * 　　HH(a,b,c,d,M13,4,0x289b7ec6)
	 * 　　HH(a,b,c,d,M0,11,0xeaa127fa)
	 * 　　HH(a,b,c,d,M3,16,0xd4ef3085)
	 * 　　HH(a,b,c,d,M6,23,0x04881d05)
	 * 　　HH(a,b,c,d,M9,4,0xd9d4d039)
	 * 　　HH(a,b,c,d,M12,11,0xe6db99e5)
	 * 　　HH(a,b,c,d,M15,16,0x1fa27cf8)
	 * 　　HH(a,b,c,d,M2,23,0xc4ac5665)
	 *
	 * 第4个16次子循环：
	 * 　　Ⅱ(a,b,c,d,M0,6,0xf4292244)
	 * 　　Ⅱ(a,b,c,d,M7,10,0x432aff97)
	 * 　　Ⅱ(a,b,c,d,M14,15,0xab9423a7)
	 * 　　Ⅱ(a,b,c,d,M5,21,0xfc93a039)
	 * 　　Ⅱ(a,b,c,d,M12,6,0x655b59c3)
	 * 　　Ⅱ(a,b,c,d,M3,10,0x8f0ccc92)
	 * 　　Ⅱ(a,b,c,d,M10,15,0xffeff47d)
	 * 　　Ⅱ(a,b,c,d,M1,21,0x85845dd1)
	 * 　　Ⅱ(a,b,c,d,M8,6,0x6fa87e4f)
	 * 　　Ⅱ(a,b,c,d,M15,10,0xfe2ce6e0)
	 * 　　Ⅱ(a,b,c,d,M6,15,0xa3014314)
	 * 　　Ⅱ(a,b,c,d,M13,21,0x4e0811a1)
	 * 　　Ⅱ(a,b,c,d,M4,6,0xf7537e82)
	 * 　　Ⅱ(a,b,c,d,M11,10,0xbd3af235)
	 * 　　Ⅱ(a,b,c,d,M2,15,0x2ad7d2bb)
	 * 　　Ⅱ(a,b,c,d,M9,21,0xeb86d391)
	 *
	 * 4. 拼接结果
	 * 把循环加工最终产生的A，B，C，D四个值拼接在一起，转换成字符串。
	 *
	 */

	/**
	 * 破解MD5
	 * https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653191598&idx=1&sn=13ef6b99b8a9a25f18b839df13cd6e31&chksm=8c990f74bbee866249af65e56a73f74b90a85b8497b9eea097f813a0b398a44fe0b8320967cd&mpshare=1&scene=23&srcid=0622YFNKjfqxzGmhdg2Rd1qm#rd
	 * 破解不是把MD5摘要还原成原文，因为128位的MD5个数是有穷的，而原文数量是无穷的，即：
	 * 设定MD5的哈希函数是H(X)，那么可能H(M1)=H(M2)=X
	 * MD5破解就是MD5的碰撞，H(M1)=H(M2)=X，M2可能等于M1，也可能不等于M1，但两者的哈希值X相同
	 * MD5碰撞的方法：
	 * 	暴力枚举法
	 * 	字典法：记录原文与对应的哈希值，获取到需要破解的哈希值，就到记录中寻找记录的原文是不是正确的结果
	 * 	彩虹表法
	 */

	/**
	 * 盐（Salt）
	 * 通过在密码任意固定位置插入特定的字符串，让散列后的结果和使用原始密码的散列结果不相符，这种过程称之为“加盐”。
	 * 如在登录中，原始密码pd+盐构成字符串str，str进行MD5得到hash1，MD5破解hash1后得到str，但是用str不能登录。
	 */
}
