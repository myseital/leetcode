package leetcode.editor.cn;

//给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右轮转 1 步: [7,1,2,3,4,5,6]
//向右轮转 2 步: [6,7,1,2,3,4,5]
//向右轮转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右轮转 1 步: [99,-1,-100,3]
//向右轮转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// 
// 
//
// 
// 
// Related Topics 数组 数学 双指针 👍 1495 👎 0

public class RotateArray {
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] data = new int[length];
        for (int i = 0; i < length; i++) {
            data[(i + k) % length] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            nums[i] = data[i];
        }
    }

    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        int[] data = new int[length];
        for (int i = 0; i < length; i++) {
            data[(i + k) % length] = nums[i];
        }
        System.arraycopy(data, 0, nums, 0, length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}