package leetcode.editor.cn;
//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
//请注意，它是排序后的第k小元素，而不是第k个元素。 
//
// 示例: 
//
// 
//matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
// 
//
// 说明: 
//你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。 
// Related Topics 堆 二分查找


import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        solution.kthSmallest2(matrix, 8);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(k + 1, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    queue.add(matrix[i][j]);
                    if (queue.size() > k) {
                        queue.remove();
                    }
                }
            }
            return queue.remove();
        }

        public int kthSmallest2(int[][] matrix, int k) {
            int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1];
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                int count = 0;
                int j = matrix[0].length - 1;
                for (int i = 0; i < matrix.length; i++) {
                    while (j >= 0 && matrix[i][j] > mid) {
                        j--;
                    }
                    count += (j + 1);
                }
                if (count < k) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}