package leetcode.editor.cn;
//给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。 
//
// 每个人都可能不喜欢其他人，那么他们不应该属于同一组。 
//
// 形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。 
//
// 当可以用这种方法将每个人分进两组时，返回 true；否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：N = 4, dislikes = [[1,2],[1,3],[2,4]]
//输出：true
//解释：group1 [1,4], group2 [2,3]
// 
//
// 示例 2： 
//
// 输入：N = 3, dislikes = [[1,2],[1,3],[2,3]]
//输出：false
// 
//
// 示例 3： 
//
// 输入：N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 2000 
// 0 <= dislikes.length <= 10000 
// 1 <= dislikes[i][j] <= N 
// dislikes[i][0] < dislikes[i][1] 
// 对于 dislikes[i] == dislikes[j] 不存在 i != j 
// 
// Related Topics 深度优先搜索

class PossibleBipartition {
    public static void main(String[] args) {
        Solution solution = new PossibleBipartition().new Solution();
        int[][] dislikes={{1,2},{1,3},{1,4}};
        solution.possibleBipartition(4,dislikes);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            int[][] graph = new int[N][N];
            for (int[] d : dislikes) {
                graph[d[0] - 1][d[1] - 1] = 1;
                graph[d[1] - 1][d[0] - 1] = 1;
            }
            int[] group = new int[N];
            for (int i = 0; i < N; i++) {
                if (group[i] == 0 && !dfs(graph, group, i, 1)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int[][] graph, int[] group, int index, int g) {
            group[index] = g;
            for (int i = 0; i < graph.length; i++) {
                if (graph[index][i] == 1) {
                    if (group[i] == g) {
                        return false;
                    }
                    if (group[i] == 0 && !dfs(graph, group, i, -g)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}