package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。
//
// 示例 1： 
//
// 输入: n = 5, 边列表 edges = [[0,1], [0,2], [0,3], [1,4]]
//输出: true 
//
// 示例 2: 
//
// 输入: n = 5, 边列表 edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
//输出: false 
//
// 注意：你可以假定边列表 edges 中不会出现重复的边。由于所有的边是无向边，边 [0,1] 和边 [1,0] 是相同的，因此不会同时出现在边列表 edges 中。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图
public class GraphValidTree {
    public static void main(String[] args) {
        Solution solution = new GraphValidTree().new Solution();
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        //int[][] edges = {{1, 0}};
        solution.validTree(5, edges);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validTree1(int n, int[][] edges) {
            DisitsJoinSet set = new DisitsJoinSet(n);
            for (int[] edge : edges) {
                if (!set.union(edge[0], edge[1])) {
                    return false;
                }
            }
            return set.getCount() == 1;
        }

        class DisitsJoinSet {
            int n;
            int[] parent; // 父亲
            int[] rank;// 树的高度
            int count;// 连同分量

            public DisitsJoinSet(int n) {
                this.n = n;
                parent = new int[n];
                Arrays.fill(parent, -1);
                rank = new int[n];
                count = n;
            }

            public int findRoot(int x) {
                int root = x;
                while (parent[root] != -1) {
                    root = parent[root];
                }
                return root;
            }

            public boolean union(int x, int y) {
                int xRoot = findRoot(x);
                int yRoot = findRoot(y);
                if (xRoot == yRoot) {
                    return false;
                }
                // 压缩路径
                if (rank[xRoot] > rank[yRoot]) {
                    parent[yRoot] = xRoot;
                } else if (rank[xRoot] < rank[yRoot]) {
                    parent[xRoot] = yRoot;
                } else {
                    parent[yRoot] = xRoot;
                    rank[xRoot]++;
                }
                --count;
                return true;
            }

            public int getCount() {
                return count;
            }
        }

        // 方法2 :BFS
        public boolean validTree2(int n, int[][] edges) {
            int[][] graph = new int[n][n];
            for (int[] edge : edges) {
                graph[edge[0]][edge[1]] = 1;
                graph[edge[1]][edge[0]] = 1;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            boolean[] visited = new boolean[n];
            while (!queue.isEmpty()) {
                Integer curr = queue.poll();
                visited[curr] = true;
                for (int i = 0; i < n; i++) {
                    if (graph[curr][i] == 1) {
                        if (visited[i]) {
                            return false;
                        }
                        visited[i] = true;
                        graph[curr][i] = 0;
                        graph[i][curr] = 0;
                        queue.add(i);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    return false;
                }
            }
            return true;
        }

        // 方法3:DFS
        public boolean validTree(int n, int[][] edges) {
            int[][] graph = new int[n][n];
            for (int[] edge : edges) {
                graph[edge[0]][edge[1]] = 1;
                graph[edge[1]][edge[0]] = 1;
            }
            Stack<Integer> stack = new Stack<>();
            stack.add(0);
            boolean[] visited = new boolean[n];
            while (!stack.isEmpty()) {
                Integer curr = stack.pop();
                visited[curr] = true;
                for (int i = 0; i < n; i++) {
                    if (graph[curr][i] == 1) {
                        if (visited[i]) {
                            return false;
                        }
                        visited[i] = true;
                        graph[curr][i] = 0;
                        graph[i][curr] = 0;
                        stack.add(i);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}