package leetcode.editor.cn;

//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划
public class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        solution.maximalSquare(matrix);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // https://leetcode-cn.com/problems/maximal-square/solution/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/
        public int maximalSquare(char[][] matrix) {
            if (matrix.length == 0) return 0;
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] dp = new int[row + 1][col + 1];
            int maxSquare = 0;
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                        maxSquare = Math.max(dp[i][j], maxSquare);
                    }
                }
            }
            return maxSquare * maxSquare;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}