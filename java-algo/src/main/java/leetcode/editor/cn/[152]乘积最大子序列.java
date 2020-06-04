package leetcode.editor.cn;
//给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划

class MaximumProductSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        int[] nums = {-2, 3, -4};
        solution.maxProduct(nums);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int max = nums[0];
            for (int i = 1, imax = max, imin = max; i < nums.length; i++) {
                if (nums[i] < 0) {
                    int temp = imax;
                    imax = imin;
                    imin = temp;
                }
                imax = Math.max(imax, nums[i] * imax);
                imin = Math.max(imin, nums[i] * imin);

                max = Math.max(max, imax);
            }
            return max;
        }


        public int maxProduct2(int[] nums) {
            // store the result that is the max we have found so far
            int r = nums[0];
            // imax/imin stores the max/min product of subarray that ends with the current number nums[i]
            for (int i = 1, imax = r, imin = r; i < nums.length; i++) {
                // multiplied by a negative makes big number smaller,small number bigger so we redefine the
                // extremums by swapping them
                if (nums[i] < 0) {
                    int temp = imax;
                    imax = imin;
                    imin = temp;
                }
                // max/min product for the current number is either the current number itself or the max/min
                // by the previous number times the current one
                imax = Math.max(nums[i], imax * nums[i]);
                imin = Math.min(nums[i], imin * nums[i]);

                // the newly computed max value is a candidate for out global result
                r = Math.max(r, imax);
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}