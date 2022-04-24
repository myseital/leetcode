package leetcode.editor.cn;

//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 
//
// 示例 1： 
//
// 输入: s = "leetcode"
//输出: false 
// 
//
// 示例 2： 
//
// 输入: s = "abc"
//输出: true
// 
//
// 限制： 
// 
// 0 <= len(s) <= 100 
// 如果你不使用额外的数据结构，会很加分。 
// 
// Related Topics 位运算 哈希表 字符串 排序 👍 205 👎 0

public class IsUniqueLcci {
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isUnique(String astr) {
        char[] ch = new char[26];
        for (char c : astr.toCharArray()) {
            if (ch[c - 'a'] != 0) {
                return false;
            }
            ch[c - 'a']++;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}