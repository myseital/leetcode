package leetcode.editor.cn;

//有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。 
//
// 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 
//所表示星型图的中心节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：edges = [[1,2],[2,3],[4,2]]
//输出：2
//解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
// 
//
// 示例 2： 
//
// 
//输入：edges = [[1,2],[5,1],[1,3],[1,4]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n <= 10⁵ 
// edges.length == n - 1 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// ui != vi 
// 题目数据给出的 edges 表示一个有效的星型图 
// 
// Related Topics 图 👍 32 👎 0

public class FindCenterOfStarGraph {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCenter(int[][] edges) {
            int fir = edges[0][0], sec = edges[0][1];
            if (fir == edges[1][0] || sec == edges[1][0]) {
                return edges[1][0];
            } else {
                return edges[1][1];
            }
        }

        // 由 n 个节点组成的星型图中，有一个中心节点，有 n−1 条边分别连接中心节点和其余的每个节点。
        // 因此，中心节点的度是 n−1，其余每个节点的度都是 1。一个节点的度的含义是与该节点相连的边数。
        // 遍历 edges 中的每条边并计算每个节点的度，度为 n−1 的节点即为中心节点。
        public int findCenter2(int[][] edges) {
            int n = edges.length + 1;
            int[] degrees = new int[n + 1];
            for (int[] edge : edges) {
                degrees[edge[0]]++;
                degrees[edge[1]]++;
            }
            for (int i = 1; i <= n; i++) {
                if (degrees[i] == n - 1) {
                    return i;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}