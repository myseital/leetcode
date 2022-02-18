package leetcode.editor.cn;

//给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。 
//
// 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：text = "nlaebolko"
//输出：1
// 
//
// 示例 2： 
//
// 
//
// 输入：text = "loonbalxballpoon"
//输出：2
// 
//
// 示例 3： 
//
// 输入：text = "leetcode"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 10^4 
// text 全部由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 👍 107 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxNumberOfBalloons(String text) {
            int[] cnt = new int[5];
            for (int i = 0; i < text.length(); ++i) {
                char ch = text.charAt(i);
                if (ch == 'b') {
                    cnt[0]++;
                } else if (ch == 'a') {
                    cnt[1]++;
                } else if (ch == 'l') {
                    cnt[2]++;
                } else if (ch == 'o') {
                    cnt[3]++;
                } else if (ch == 'n') {
                    cnt[4]++;
                }
            }
            cnt[2] /= 2;
            cnt[3] /= 2;

            return Arrays.stream(cnt).min().getAsInt();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}