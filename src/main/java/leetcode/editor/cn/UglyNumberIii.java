package leetcode.editor.cn;

//给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。 
//
// 丑数是可以被 a 或 b 或 c 整除的 正整数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, a = 2, b = 3, c = 5
//输出：4
//解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。 
//
// 示例 2： 
//
// 
//输入：n = 4, a = 2, b = 3, c = 4
//输出：6
//解释：丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
// 
//
// 示例 3： 
//
// 
//输入：n = 5, a = 2, b = 11, c = 13
//输出：10
//解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
// 
//
// 示例 4： 
//
// 
//输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
//输出：1999999984
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n, a, b, c <= 10^9 
// 1 <= a * b * c <= 10^18 
// 本题结果在 [1, 2 * 10^9] 的范围内 
// 
// Related Topics 数学 二分查找 数论 👍 108 👎 0

import static java.lang.Math.min;

public class UglyNumberIii {
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ans = 0;
        long l = 0, r = (long) Math.min(a, Math.min(b, c)) * n;
        long ab = this.lcm(a, b);
        long ac = this.lcm(a, c);
        long bc = this.lcm(b, c);
        long abc = this.lcm(b, ac);
        while (l <= r) {
            long m = l + ((r - l) >> 1);
            long N = m / a + m / b + m / c - m / ab - m / ac - m / bc + m / abc;
            if (N < n) {
                l = m + 1;
                ans = l;
            } else {
                r = m - 1;
            }
        }
        return (int) ans;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 最小公倍数
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}