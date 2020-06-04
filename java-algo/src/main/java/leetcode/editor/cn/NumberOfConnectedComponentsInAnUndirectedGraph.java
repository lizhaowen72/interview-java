package leetcode.editor.cn;

import java.util.Arrays;

//给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
//
// 示例 1: 
//
// 输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
//
//     0          3
//     |          |
//     1 --- 2    4 
//
//输出: 2
// 
//
// 示例 2: 
//
// 输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
//
//     0           4
//     |           |
//     1 --- 2 --- 3
//
//输出:  1
// 
//
// 注意: 
//你可以假设在 edges 中不会出现重复的边。而且由于所以的边都是无向边，[0, 1] 与 [1, 0] 相同，所以它们不会同时在 edges 中出现。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public static void main(String[] args) {
        Solution solution = new NumberOfConnectedComponentsInAnUndirectedGraph().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countComponents(int n, int[][] edges) {
            DisjoinSet disjoinSet = new DisjoinSet(n);
            for (int[] edge : edges) {
                disjoinSet.union(edge[0], edge[1]);
            }
            return disjoinSet.getCount();
        }
    }

    class DisjoinSet {
        private int n;
        private int count;// 记录连通分量个数
        private int[] parent;// 父亲
        private int[] rank;// 树的高度

        public DisjoinSet(int n) {
            this.n = n;
            parent = new int[n];
            Arrays.fill(parent, -1);
            rank = new int[n];
            count = n;
        }

        private int findRoot(int x) {
            int root = x;
            while (parent[root] != -1) {
                root = parent[root];
            }
            return root;
        }

        public void union(int x, int y) {
            int xRoot = findRoot(x);
            int yRoot = findRoot(y);
            if (xRoot == yRoot) return;
            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[xRoot] = yRoot;
                rank[yRoot]++;
            }
            count--;
        }

        public int getCount() {
            return count;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}