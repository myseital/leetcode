package leetcode.editor.cn;

//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 853 👎 0

public class LowestCommonAncestorOfABinarySearchTree {
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    // 递归解决
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果小于等于0，说明p和q位于root的两侧，直接返回即可
        if ((root.val - p.val) * (root.val - q.val) <= 0)
            return root;
        //否则，p和q位于root的同一侧，就继续往下找
        return lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
    }

    // 非递归解决
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //如果根节点和p,q的差相乘是正数，说明这两个差值要么都是正数要么都是负数，也就是说
        //他们肯定都位于根节点的同一侧，就继续往下找
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        //如果相乘的结果是负数，说明p和q位于根节点的两侧，如果等于0，说明至少有一个就是根节点
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}