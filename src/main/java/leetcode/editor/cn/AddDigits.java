package leetcode.editor.cn;

//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 38
//输出: 2 
//解释: 各位相加的过程为：
//38 --> 3 + 8 --> 11
//11 --> 1 + 1 --> 2
//由于 2 是一位数，所以返回 2。
// 
//
// 示例 1: 
//
// 
//输入: num = 0
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？ 
// Related Topics 数学 数论 模拟 👍 429 👎 0

public class AddDigits {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 递归
        public int addDigits(int num) {
            if (num < 10) {
                return num;
            }
            int next = 0;
            while (num != 0) {
                next = next + num % 10;
                num /= 10;
            }

            return addDigits(next);
        }

        // 循环
        public int addDigits2(int num) {
            while (num >= 10) {
                int sum = 0;
                while (num > 0) {
                    sum += num % 10;
                    num /= 10;
                }
                num = sum;
            }

            return num;
        }

        // 能够被9整除的整数，各位上的数字加起来也必然能被9整除，所以，连续累加起来，最终必然就是9。
        // 不能被9整除的整数，各位上的数字加起来，结果对9取模，和初始数对9取摸，是一样的，所以，连续累加起来，最终必然就是初始数对9取摸。
        public int addDigits3(int num) {
//            if (0 == num % 9) {
//                return 9;
//            }
//            return num % 9;
            return (num - 1) % 9 + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}