package leetcode.editor.cn;
//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 示例 1: 
//输入: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 示例 2: 
//输入: 
//
// 
//0 0 0
//0 1 0
//1 1 1
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//1 2 1
// 
//
// 注意: 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索

import java.util.LinkedList;
import java.util.Queue;

class Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new Zero1Matrix().new Solution();
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        solution.updateMatrix(matrix);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 定义一个队列，初始时将所有 0 元素的坐标进队；0 元素位置的值为 0，其余为 Integer.MAX_VALUE。(也可以定义为其它数字，只是为了保证每个1只被便利一次)
         * 对这个队列开始进行宽度优先搜索，每次扩展上下左右四个方向，若发现新的位置为 Integer.MAX_VALUE，则更新新位置的答案为当前位置答案加 1。
         * @param matrix
         * @return
         */
        /**
         * 对于广度优先搜索，保存一个队列 q 维护下一个需要检查的点。
         * <p>
         * 我们将所有的 0 放入 q 中。
         * <p>
         * 初始地，对于每个为 0 的节点距离都是 1，对于所有的 1 都是 INT_MAX，会根据广搜的结果更新。
         * <p>
         * 弹出队列中的元素，检查它的邻居。如果对于邻居 {i,j} 新计算的距离更小，将 {i,j} 加入队列 q 中同时更新距离 dist[i][j]。
         *
         * @param matrix
         * @return
         */
        public int[][] updateMatrix(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        queue.add(new int[]{i, j});
                    } else {
                        matrix[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            while (!queue.isEmpty()) {
                int[] cells = queue.poll();
                for (int[] d : dirs) {
                    int r = cells[0] + d[0];
                    int c = cells[1] + d[1];
                    if (r < 0 || r >= row || c < 0 || c >= col || matrix[r][c] <= matrix[cells[0]][cells[1]] + 1) {
                        continue;
                    }
                    queue.add(new int[]{r, c});
                    matrix[r][c] = matrix[cells[0]][cells[1]] + 1;
                }
            }
            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}