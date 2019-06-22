package basic;

/**
 * 求最大公约数
 * 后续补充辗转相除法、更相减损术的原理证明
 */
public class GreatestCommonDivisor {
    /**
     * 辗转相除法
     * 欧几里得发明
     * 基于定理：两个正整数a、b（a>b），那么它们的最大公约数等于 c、b的最大公约数，其中c=a%b
     * 缺点：当两个整数较大时，取模运算性能比较低
     */
    static int successiveDivision(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int remainder = a % b;
        if (remainder == 0)
            return b;
        return successiveDivision(b, remainder);
    }

    /**
     * 更相减损术
     * 出自《九章算术》
     * 基于定理：两个正整数a、b（a>b），那么它们的最大公约数等于 c、b的最大公约数，其中c=a-b
     * 缺点：在计算1000与1的最大公约数时，需要多次减法计算
     */
    static int mutualReduce(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int difference = a - b;
        if (difference == 0)
            return b;
        return mutualReduce(b, difference);
    }

    /**
     * 移位与更相减损术结合
     * 移位运算的性能非常快
     * 对于两个正整数a、b，定义gcd(a,b)为a、b的最大公约数函数
     * 1. 当a、b均为偶数时，gcd(a,b) = 2*gcd(a/2,b/2) = 2*gcd(a>>1,b>>1)
     * 2. 当a为偶数，b为奇数时，gcd(a,b) = gcd(a/2,b) = gcd(a>>1,b)
     * 3. 当a为奇数，b为偶数时，gcd(a,b) = gcd(a,b/2) = gcd(a,b>>1)
     * 4. 当a、b均为偶数时，利用更相减损术运算一次，假设a>b，gcd(a,b) = gcd(b,a-b)，此时a-b是偶数，可继续利用上面第3条规则
     */
    static int shiftWithMutualReduce(int a, int b) {
        if (a == b) {
            return a;
        }

        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if ((a & 1) == 0 && (b & 1) == 0) { // a、b都为偶数
            return shiftWithMutualReduce(a >> 1, b >> 1) << 1;
        }
        if ((a & 1) == 0 && (b & 1) == 1) {// a为偶数、b为奇数
            return shiftWithMutualReduce(a >> 1, b);
        }
        if ((a & 1) == 1 && (b & 1) == 0) {// a为奇数、b为偶数
            return shiftWithMutualReduce(a, b >> 1);
        }
        if ((a & 1) == 1 && (b & 1) == 1) {// a、b都为奇数
            return shiftWithMutualReduce(b, a - b);
        }
        return 1;
    }

    public static void main(String[] args) {
        int a = 200;
        int b = 160;
        System.out.println("辗转相除法计算最大公约数是：" + successiveDivision(a, b));
        System.out.println("更相减损术计算最大公约数是：" + mutualReduce(a, b));
        System.out.println("移位与更相减损术结合计算最大公约数是：" + shiftWithMutualReduce(a, b));
    }

}
