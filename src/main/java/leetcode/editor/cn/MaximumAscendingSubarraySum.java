package leetcode.editor.cn;

//给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。 
//
// 子数组是数组中的一个连续数字序列。 
//
// 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < 
//numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,20,30,5,10,50]
//输出：65
//解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [10,20,30,40,50]
//输出：150
//解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。 
// 
//
// 示例 3： 
//
// 
//输入：nums = [12,17,15,13,10,11,12]
//输出：33
//解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。 
// 
//
// 示例 4： 
//
// 
//输入：nums = [100,10,1]
//输出：100
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 👍 27 👎 0

public class MaximumAscendingSubarraySum {
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = nums[0]; // 先选取数组第一个值作为答案，可应对当数组仅有1个元素的情况
        int cur = nums[0]; // 用cur记录本次持续升序的所有元素的累积和

        for (int i = 1; i < nums.length; i++) { // 从索引1开始遍历
            if (nums[i] > nums[i - 1]) { // 当前元素比前一个大，说明当前是升序状态
                cur += nums[i]; // 升序状态就让cur累加当前的值
            } else {
                // 遇到降序之后，就让 刚才累加的cur的值 与 当前值nums[i] 做个大小比较，选取最大的作为当前位置的最大值
                // 然后再与总的结果ans进行判断，留下最大值
                ans = Math.max(ans, Math.max(cur, nums[i]));
                cur = nums[i]; // 把累积的cur的值清空，换成当前值，表示从头开始累积
            }
        }
        ans = Math.max(ans, cur); // 把数组最后一组升序元素累积的值拿出来进行判断
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}