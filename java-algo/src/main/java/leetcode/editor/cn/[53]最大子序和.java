package leetcode.editor.cn;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划

class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < len; i++) {
                dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
                max = Math.max(max, dp[i]);
            }
            return max;
        }

        /**
         * 采用分治算法
         *
         * @param nums
         * @return
         */
        public int maxSubArray3(int[] nums) {
            return maxSubArrayHelper2(nums, 0, nums.length - 1);
        }

        public int maxSubArrayHelper2(int[] nums, int left, int right) {
            if (left == right) {
                return nums[left];
            }
            int mid = left + ((right - left) >> 1);
            int leftSum = maxSubArrayHelper2(nums, left, mid);
            int rightSum = maxSubArrayHelper2(nums, mid + 1, right);
            int crossSum = crossSubArray2(nums, left, right);
            if (leftSum >= rightSum && leftSum >= crossSum) {
                return leftSum;
            }
            if (rightSum >= leftSum && rightSum >= crossSum) {
                return rightSum;
            }
            return crossSum;
        }

        public int crossSubArray2(int[] nums, int left, int right) {
            int leftSum = Integer.MIN_VALUE;
            int rightSum = Integer.MIN_VALUE;
            int sum = 0;
            int mid = left + (right - left) / 2;
            for (int i = mid; i >= left; i--) {
                sum += nums[i];
                if (leftSum < sum) {
                    leftSum = sum;
                }
            }
            sum = 0;
            for (int j = mid + 1; j <= right; j++) {
                sum += nums[j];
                if (rightSum < sum) {
                    rightSum = sum;
                }
            }
            return leftSum + rightSum;
        }

        public int maxSubArrayHelper(int[] nums, int left, int right) {
            if (left == right) {
                return nums[left];
            }
            int mid = left + ((right - left) >> 1);
            int leftSum = maxSubArrayHelper(nums, left, mid);// left part
            int rightSum = maxSubArrayHelper(nums, mid + 1, right);// right part
            int crossSum = crossSubArray(nums, left, right);// cross part
            if (leftSum >= rightSum && leftSum >= crossSum) {// left part is max
                return leftSum;
            }
            if (rightSum >= leftSum && rightSum >= crossSum) {// right part is max
                return rightSum;
            }
            return crossSum;
        }

        public int crossSubArray(int[] nums, int left, int right) {
            int leftSum = Integer.MIN_VALUE;
            int rightSum = Integer.MIN_VALUE;
            int sum = 0;
            int mid = left + (right - left) / 2;
            for (int i = mid; i >= left; i--) {
                sum += nums[i];
                if (leftSum < sum) {
                    leftSum = sum;
                }
            }
            sum = 0;
            for (int j = mid + 1; j <= right; j++) {
                sum = sum + nums[j];
                if (rightSum < sum) {
                    rightSum = sum;
                }
            }
            return leftSum + rightSum;
        }

        public int maxSubArray2(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < len; i++) {
                dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}