package leetcode.editor.cn;

//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。 
//
// 请你找出并返回只出现一次的那个数。 
//
// 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 二分查找 👍 395 👎 0

import java.util.HashMap;
import java.util.Map;

public class SingleElementInASortedArray {
    public static void main(String[] args) {
        Solution solution = new SingleElementInASortedArray().new Solution();
        System.out.println(7 / 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNonDuplicate1(int[] nums) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int length = nums.length;
            for (int i = 0; i < length / 2 + 1; i++) {
                Integer a = map.get(nums[i]);
                if (a == null) {
                    map.put(nums[i], nums[i]);
                } else {
                    map.remove(nums[i]);
                }
                if (i != length - 1 - i) {
                    Integer b = map.get(nums[length - 1 - i]);
                    if (b == null) {
                        map.put(nums[length - 1 - i], nums[length - 1 - i]);
                    } else {
                        map.remove(nums[length - 1 - i]);
                    }
                }
            }

            return map.keySet().iterator().next();
        }

        public int singleNonDuplicate2(int[] nums) {
            int index = 0, length = nums.length;
            for (int i = 0; i < length - 1 / 2; i++) {
                if (i * 2 + 1 >= length) {
                    index = i * 2;
                    break;
                }
                if (nums[i * 2] == nums[i * 2 + 1]) {
                    continue;
                } else {
                    index = i * 2;
                    break;
                }
            }
            return nums[index];
        }

        public int singleNonDuplicate(int[] nums) {
            int low = 0, high = nums.length - 1;
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (nums[mid] == nums[mid ^ 1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            return nums[low];

//            int low = 0, high = nums.length - 1;
//            while (low < high) {
//                int mid = (high - low) / 2 + low;
//                mid -= mid & 1;
//                if (nums[mid] == nums[mid + 1]) {
//                    low = mid + 2;
//                } else {
//                    high = mid;
//                }
//            }
//            return nums[low];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}