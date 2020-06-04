package leetcode.editor.cn;
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true.
//给定 word = "SEE", 返回 true.
//给定 word = "ABCB", 返回 false. 
// Related Topics 数组 回溯算法

class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            char[] w = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (exist(board, i, j, w, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * board [y] [x] ^ = 256这是标记，指示位置x，y的字母是我们搜索的单词的一部分。
         * 在board [y] [x] ^ = 256之后，字符变为无效字母。在第二局之后[y] [x] ^ = 256 它再次成为有效的信件。
         *
         * @param board
         * @param y
         * @param x
         * @param word
         * @param i
         * @return
         */
        private boolean exist(char[][] board, int i, int j, char[] word, int len) {
            if (len == word.length) {
                return true;
            }
            if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
                return false;
            }
            if (board[i][j] != word[len]) {
                return false;
            }
            board[i][j] ^= 256;
            boolean exist = exist(board, i, j - 1, word, len + 1)
                    || exist(board, i, j + 1, word, len + 1)
                    || exist(board, i - 1, j, word, len + 1)
                    || exist(board, i + 1, j, word, len + 1);
            board[i][j] ^= 256;
            return exist;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}