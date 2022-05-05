package leetcode.editor.cn;

//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
// Related Topics 位运算 哈希表 字符串 👍 80 👎 0

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutationLcci {
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            //set的add方法如果返回false，表示已经有了，
            //我们就把他删除
            if (!set.add(ch)) {
                set.remove(ch);
            }
        }
        //最后判断set的长度是否小于等于1，如果等于1说明
        //只有一个字符的个数是奇数，其他的都是偶数。如果
        //等于0说明每个字符都是偶数，否则不可能构成回文字符串
        return set.size() <= 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}