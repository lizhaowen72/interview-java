package leetcode.editor.cn;
//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组

class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int left = 0, right = n - 1, on = 0, down = n - 1;
            int[][] mat = new int[n][n];
            int num = 1, tar = n * n;
            while (num <= tar) {
                for (int i = left; i <= right; i++) {
                    mat[on][i] = num++;
                }
                on++;
                for (int i = on; i <= down; i++) {
                    mat[i][right] = num++;
                }
                right--;
                for (int i = right; i >= left; i--) {
                    mat[down][i] = num++;
                }
                down--;
                for (int i = down; i >= on; i--) {
                    mat[i][left] = num++;
                }
                left++;
            }
            return mat;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}