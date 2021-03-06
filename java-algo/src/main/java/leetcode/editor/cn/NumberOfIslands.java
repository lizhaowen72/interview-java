package leetcode.editor.cn;
//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 时间复杂度 : O(M\times N)O(M×N)，其中 MM 和 NN 分别为行数和列数。
         *
         * 空间复杂度 : 最坏情况下为 O(M×N)，此时整个网格均为陆地，深度优先搜索的深度达到 NM×N。
         * @param grid
         * @return
         */
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int nr = grid.length;
            int nc = grid[0].length;
            int num_islands = 0;
            for (int r = 0; r < nr; r++) {
                for (int c = 0; c < nc; c++) {
                    if (grid[r][c] == '1') {
                        ++num_islands;
                        dfs(grid, r, c);
                    }
                }
            }
            return num_islands;
        }

        private void dfs(char[][] grid, int r, int c) {
            if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
                return;
            }
            grid[r][c] = '0';
            dfs(grid, r - 1, c);
            dfs(grid, r + 1, c);
            dfs(grid, r, c - 1);
            dfs(grid, r, c + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}