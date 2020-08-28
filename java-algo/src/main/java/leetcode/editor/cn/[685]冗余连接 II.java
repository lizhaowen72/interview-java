package leetcode.editor.cn;
//在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。 
//
// 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边
//不属于树中已存在的边。 
//
// 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。 
//
//
// 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。 
//
// 示例 1: 
//
// 输入: [[1,2], [1,3], [2,3]]
//输出: [2,3]
//解释: 给定的有向图如下:
//  1
// / \
//v   v
//2-->3
// 
//
// 示例 2: 
//
// 输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
//输出: [4,1]
//解释: 给定的有向图如下:
//5 <- 1 -> 2
//     ^    |
//     |    v
//     4 <- 3
// 
//
// 注意: 
//
// 
// 二维数组大小的在3到1000范围内。 
// 二维数组中的每个整数在1到N之间，其中 N 是二维数组的大小。 
// 
// Related Topics 树 深度优先搜索 并查集 图 
// 👍 87 👎 0

class RedundantConnectionIi {
    public static void main(String[] args) {
        Solution solution = new RedundantConnectionIi().new Solution();
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        solution.findRedundantDirectedConnection(edges);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] anc;// 并查集
        int[] parent;// 记录每个点的父亲,为了找到双入度点

        public int[] findRedundantDirectedConnection(int[][] edges) {
            anc = new int[edges.length + 1];
            parent = new int[edges.length + 1];
            int[] edge1 = null;
            int[] edge2 = null;
            int[] lastEdgeCauseCircle = null;
            for (int[] pair : edges) {
                int u = pair[0];
                int v = pair[1];

                // 初始化并查集
                if (anc[u] == 0) {
                    anc[u] = u;
                }
                if (anc[v] == 0) {
                    anc[v] = v;
                }
                // node v already has a father, so we just skip the union of this edge and check if there will be a circle ，跳过 edge2,并记下 edge1,edge2
                if (parent[v] != 0) {
                    edge1 = new int[]{parent[v], v};
                    edge2 = pair;
                } else {
                    parent[v] = u;
                    int ancU = find(u);
                    int ancV = find(v);
                    if (ancU != ancV) {
                        anc[ancV] = ancU;
                    } else {// 碰到了环
                        lastEdgeCauseCircle = pair;
                    }
                }
            }
            if (edge1 != null && edge2 != null) {//如果是情况2、3，则根据有没有碰到环返回 edge1 或 edge2
                return lastEdgeCauseCircle == null ? edge2 : edge1;
            } else {
                return lastEdgeCauseCircle;//否则就是情况1，返回那个导致环的最后出现的边。
            }
        }

        private int find(int node) {
            if (anc[node] == node) {
                return node;
            }
            anc[node] = find(anc[node]);
            return anc[node];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}