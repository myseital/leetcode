package leetcode.editor.cn;

//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 676 👎 0

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                return 1;
            }

            int minDepth = Integer.MAX_VALUE;
            if (root.left != null) {
                minDepth = Math.min(minDepth(root.left), minDepth);
            }
            if (root.right != null) {
                minDepth = Math.min(minDepth(root.right), minDepth);
            }

            return minDepth + 1;
        }

//        class QueueNode {
//            TreeNode node;
//            int depth;
//
//            public QueueNode(TreeNode node, int depth) {
//                this.node = node;
//                this.depth = depth;
//            }
//        }
//
//        public int minDepth(TreeNode root) {
//            if (root == null) {
//                return 0;
//            }
//
//            Queue<QueueNode> queue = new LinkedList<QueueNode>();
//            queue.offer(new QueueNode(root, 1));
//            while (!queue.isEmpty()) {
//                QueueNode nodeDepth = queue.poll();
//                TreeNode node = nodeDepth.node;
//                int depth = nodeDepth.depth;
//                if (node.left == null && node.right == null) {
//                    return depth;
//                }
//                if (node.left != null) {
//                    queue.offer(new QueueNode(node.left, depth + 1));
//                }
//                if (node.right != null) {
//                    queue.offer(new QueueNode(node.right, depth + 1));
//                }
//            }
//
//            return 0;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}