package leetcode.editor.cn;

//Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。 
//
// 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，
//返回 false 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
//输出：true
//解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。 
//
// 示例 2： 
//
// 
//输入：hand = [1,2,3,4,5], groupSize = 4
//输出：false
//解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。 
//
// 
//
// 提示： 
//
// 
// 1 <= hand.length <= 10⁴ 
// 0 <= hand[i] <= 10⁹ 
// 1 <= groupSize <= hand.length 
// 
//
// 
//
// 注意：此题目与 1296 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-
//consecutive-numbers/ 
// Related Topics 贪心 数组 哈希表 排序 👍 206 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : hand) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        for (int x : hand) {
            if (!cnt.containsKey(x)) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int num = x + j;
                if (!cnt.containsKey(num)) {
                    return false;
                }
                cnt.put(num, cnt.get(num) - 1);
                if (cnt.get(num) == 0) {
                    cnt.remove(num);
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}