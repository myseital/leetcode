package leetcode.editor.cn;

//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
// Related Topics 栈 链表 数学 👍 520 👎 0

import java.util.Stack;

public class AddTwoNumbersIi {
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        while (l1 != null) {
            a.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            b.push(l2.val);
            l2 = l2.next;
        }
        int count = 0;
        ListNode node = null;
        while (!a.empty() || !b.empty() || count != 0) {
            Integer ai = a.empty() ? 0 : a.pop();
            Integer bi = b.empty() ? 0 : b.pop();
            int cur = ai + bi + count;
            ListNode add = new ListNode(cur % 10);

            add.next = node;
            node = add;
            count = cur / 10;
        }

        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}