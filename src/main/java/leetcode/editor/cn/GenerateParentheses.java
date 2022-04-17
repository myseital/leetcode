package leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2560 👎 0

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList<String>();
//        backtrack(ans, new StringBuilder(), 0, 0, n);
//        return ans;
//    }
//
//    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
//        if (cur.length() == max * 2) {
//            ans.add(cur.toString());
//            return;
//        }
//        if (open < max) {
//            cur.append('(');
//            backtrack(ans, cur, open + 1, close, max);
//            cur.deleteCharAt(cur.length() - 1);
//        }
//        if (close < open) {
//            cur.append(')');
//            backtrack(ans, cur, open, close + 1, max);
//            cur.deleteCharAt(cur.length() - 1);
//        }
//    }

    // 做减法
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }
        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}