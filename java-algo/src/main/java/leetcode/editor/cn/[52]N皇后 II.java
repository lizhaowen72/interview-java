package leetcode.editor.cn;
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 回溯算法

import java.util.ArrayList;
import java.util.List;

class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalNQueens(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }
            List<List<String>> res = new ArrayList<>();
            dfs(board, 0, res);
            return res.size();
        }

        private void dfs(char[][] board, int colIndex, List<List<String>> res) {
            if (colIndex == board[0].length) {
                res.add(construct(board));
                return;
            }
            for (int i = 0; i < board.length; i++) {
                if (isValid(board, i, colIndex)) {
                    board[i][colIndex] = 'Q';
                    dfs(board, colIndex + 1, res);
                    board[i][colIndex] = '.';
                }
            }
        }

        private boolean isValid(char[][] board, int x, int y) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < y; j++) {
                    if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private List<String> construct(char[][] board) {
            List<String> queenList = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                queenList.add(new String(board[i]));
            }
            return queenList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}