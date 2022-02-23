package leetcode.editor.cn;

//给你一个字符串 s ，根据下述规则反转字符串： 
//
// 
// 所有非英文字母保留在原有位置。 
// 所有英文字母（小写或大写）位置反转。 
// 
//
// 返回反转后的 s 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "ab-cd"
//输出："dc-ba"
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 
// 
//
// 示例 3： 
//
// 
//输入：s = "Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示 
//
// 
// 1 <= s.length <= 100 
// s 仅由 ASCII 值在范围 [33, 122] 的字符组成 
// s 不含 '\"' 或 '\\' 
// 
// Related Topics 双指针 字符串 👍 147 👎 0

public class ReverseOnlyLetters {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String s) {
            int length = s.length();
            int low = 0, high = length - 1;
            char[] chars = s.toCharArray();
            while (low <= high) {
                char aChar = chars[low];
                char bChar = chars[high];
                boolean b = bChar >= 'a' && bChar <= 'z' || bChar >= 'A' && bChar <= 'Z';
                boolean a = aChar >= 'a' && aChar <= 'z' || aChar >= 'A' && aChar <= 'Z';
                if (a && b) {
                    chars[low] = bChar;
                    chars[high] = aChar;
                    high--;
                    low++;
                }
                if (!a) {
                    chars[low] = aChar;
                    low++;
                }
                if (!b) {
                    chars[high] = bChar;
                    high--;
                }
            }

            return new String(chars);
        }

//        public String reverseOnlyLetters(String s) {
//            int n = s.length();
//            char[] arr = s.toCharArray();
//            int left = 0, right = n - 1;
//            while (true) {
//                while (left < right && !Character.isLetter(s.charAt(left))) { // 判断左边是否扫描到字母
//                    left++;
//                }
//                while (right > left && !Character.isLetter(s.charAt(right))) { // 判断右边是否扫描到字母
//                    right--;
//                }
//                if (left >= right) {
//                    break;
//                }
//                swap(arr, left, right);
//                left++;
//                right--;
//            }
//            return new String(arr);
//        }
//
//        public void swap(char[] arr, int left, int right) {
//            char temp = arr[left];
//            arr[left] = arr[right];
//            arr[right] = temp;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}