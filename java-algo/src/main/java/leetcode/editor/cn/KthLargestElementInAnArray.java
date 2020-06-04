package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        solution.findKthLargest(nums, 2);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            k = nums.length - k;
            int lo = 0;
            int hi = nums.length - 1;
            while (lo < hi) {
                final int j = partition(nums, lo, hi);
                if (j < k) {
                    lo = j + 1;
                } else if (j > k) {
                    hi = j - 1;
                } else {
                    break;
                }
            }
            return nums[k];
        }

        private int partition(int[] nums, int lo, int hi) {
            int i = lo;
            int j = hi + 1;
            while (true) {
                while (i < hi && less(nums[++i], nums[lo])) ;
                while (j > lo && less(nums[lo], nums[--j])) ;
                if (i >= j) {
                    break;
                }
                exch(nums, i, j);
            }
            exch(nums, lo, j);
            return j;
        }

        private void exch(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private boolean less(int n, int m) {
            return n < m;
        }


        /**
         * O(N) best case / O(N^2) worst case running time + O(1) memory
         *
         * @param nums
         * @param k
         * @return
         */
        public int findKthLargest3(int[] nums, int k) {
            final PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.offer(num);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            return queue.peek();
        }

        /**
         * O(NlgK) running time + O(K) memory
         *
         * @param nums
         * @param k
         * @return
         */
        public int findKthLargest4(int[] nums, int k) {
            final int N = nums.length;
            Arrays.sort(nums);
            return nums[N - k];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
}