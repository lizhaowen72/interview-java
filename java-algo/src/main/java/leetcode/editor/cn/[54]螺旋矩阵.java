package leetcode.editor.cn;
//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        int[][] matrix = {{1, 2, 3, 4}};
        int[][] matrix2 = {{1}, {2}, {3}, {4}};
        solution.spiralOrder(matrix2);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix == null || matrix.length == 0) {
                return res;
            }
            int colBegin = 0, colEnd = matrix[0].length - 1;
            int rowBegin = 0, rowEnd = matrix.length - 1;
            while (colBegin <= colEnd && rowBegin <= rowEnd) {
                for (int i = colBegin; i <= colEnd; i++) {
                    res.add(matrix[rowBegin][i]);
                }
                rowBegin++;
                for (int i = rowBegin; i <= rowEnd; i++) {
                    res.add(matrix[i][colEnd]);
                }
                colEnd--;
                if (rowBegin <= rowEnd) {
                    for (int i = colEnd; i >= colBegin; i--) {
                        res.add(matrix[rowEnd][i]);
                    }
                }
                rowEnd--;
                if (colBegin <= colEnd) {
                    for (int i = rowEnd; i >= rowBegin; i--) {
                        res.add(matrix[i][colBegin]);
                    }
                }
                colBegin++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}