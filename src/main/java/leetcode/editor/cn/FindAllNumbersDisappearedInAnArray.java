package leetcode.editor.cn;

//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
// Related Topics 数组 哈希表 👍 954 👎 0

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            //得到num值对应的下标
            int x = (num - 1) % n;
            //num-1下标位置的数+n放入nums数组中
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            //因为值是[1,n]而第一个for循环经过if判断后筛选得到
            //的是有问题的下标即从0开始但值从1，所以下面用i+1
            if (nums[i] <= n) {
                //i位置上的值i+1未曾出现过
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}