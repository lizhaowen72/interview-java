package leetcode.editor.cn;
//给定一个整数矩阵，找出最长递增路径的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。 
//
// 示例 1: 
//
// 输入: nums = 
//[
//  [9,9,4],
//  [6,6,8],
//  [2,1,1]
//] 
//输出: 4 
//解释: 最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2: 
//
// 输入: nums = 
//[
//  [3,4,5],
//  [3,2,6],
//  [2,2,1]
//] 
//输出: 4 
//解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
// Related Topics 深度优先搜索 拓扑排序 记忆化

class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingPathInAMatrix().new Solution();
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        solution.longestIncreasingPath(matrix);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return 0;
            int m = matrix.length, n = matrix[0].length;
            int max = 1;
            int[][] visited = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int len = dfs(matrix, m, n, i, j, visited);
                    max = Math.max(max, len);
                }
            }
            return max;
        }

        private int dfs(int[][] matrix, int m, int n, int i, int j, int[][] visited) {
            if (visited[i][j] != 0) {
                return visited[i][j];
            }
            int max = 1;
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {
                    continue;
                }
                int len = 1 + dfs(matrix, m, n, x, y, visited);
                max = Math.max(max, len);
            }
            visited[i][j] = max;
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}