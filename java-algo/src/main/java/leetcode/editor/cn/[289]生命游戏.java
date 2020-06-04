package leetcode.editor.cn;
//根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。 
//
// 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞
//。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律： 
//
// 
// 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡； 
// 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活； 
// 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡； 
// 如果死细胞周围正好有三个活细胞，则该位置死细胞复活； 
// 
//
// 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死
//亡是同时发生的。 
//
// 示例: 
//
// 输入: 
//[
//  [0,1,0],
//  [0,0,1],
//  [1,1,1],
//  [0,0,0]
//]
//输出: 
//[
//  [0,0,0],
//  [1,0,1],
//  [0,1,1],
//  [0,1,0]
//] 
//
// 进阶: 
//
// 
// 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。 
// 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？ 
// 
// Related Topics 数组

class GameOfLife {
    public static void main(String[] args) {
        Solution solution = new GameOfLife().new Solution();
        int[][] board = {{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 1, 0}};
        solution.gameOfLife(board);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * To solve it in place, we use 2 bits to store 2 states:
         *
         * [2nd bit, 1st bit] = [next state, current state]
         *
         * - 00  dead (next) <- dead (current)
         * - 01  dead (next) <- live (current)
         * - 10  live (next) <- dead (current)
         * - 11  live (next) <- live (current)
         * In the beginning, every cell is either 00 or 01.
         * Notice that 1st state is independent of 2nd state.
         * Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
         * Let's count # of neighbors from 1st state and set 2nd state bit.
         * Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
         * In the end, delete every cell's 1st state by doing >> 1.
         * For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.
         *
         * Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
         * Transition 00 -> 10: when board == 0 and lives == 3.
         * To get the current state, simply do
         *
         * board[i][j] & 1
         * To get the next state, simply do
         *
         * board[i][j] >> 1
         * @param board
         */
        public void gameOfLife(int[][] board) {
            if (board.length == 0 || board[0].length == 0) return;
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int lives = liveNeighbours(board, m, n, i, j);
                    if (board[i][j]==1&&lives>=2&&lives<=3){
                        board[i][j]=3;
                    }
                    if (board[i][j]==0&&lives==3){
                        board[i][j]=2;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j]>>=1;
                }
            }
        }

        private int liveNeighbours(int[][] board, int m, int n, int i, int j) {
            int lives = 0;
            for (int k = Math.max(i - 1, 0); k <= Math.min(i+1, m - 1); k++) {
                for (int l = Math.max(j - 1, 0); l <= Math.min(j+1, n - 1); l++) {
                    lives += board[k][l] & 1;
                }
            }
            lives -= board[i][j] & 1;
            return lives;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}