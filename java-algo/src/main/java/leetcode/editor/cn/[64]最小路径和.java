package leetcode.editor.cn;
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划

class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    } else if (i == 0) {
                        grid[0][j] = grid[0][j - 1] + grid[0][j];
                    } else if (j == 0) {
                        grid[i][0] = grid[i - 1][0] + grid[i][0];
                    } else {
                        grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                    }
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }


        public int minPathSum2(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    } else if (i == 0) {
                        grid[0][j] = grid[0][j - 1] + grid[0][j];
                    } else if (j == 0) {
                        grid[i][0] = grid[i][0] + grid[i - 1][0];
                    } else {
                        grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                    }
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}