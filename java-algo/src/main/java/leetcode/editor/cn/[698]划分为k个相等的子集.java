package leetcode.editor.cn;
//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 
//
// 注意: 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 
// Related Topics 递归 动态规划

import java.util.Arrays;

class PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        Solution solution = new PartitionToKEqualSumSubsets().new Solution();
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        solution.canPartitionKSubsets(nums, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Time Complexity : 0(N*2^N)
         * Space COmplexity: 0(2^N)
         *
         * @param nums
         * @param k
         * @return
         */
        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (nums == null || nums.length == 0) return false;

            int n = nums.length;
            // dp [i]指示长度i的数组是否可以划分为相等总和的k个子集
            boolean[] dp = new boolean[1 << n];
            // total [i]存储总和小于等于目标总和的子集总和
            int[] total = new int[1 << n];
            dp[0] = true;

            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            Arrays.sort(nums);
            if (sum % k != 0) {
                return false;
            }
            sum /= k;
            if (nums[n - 1] > sum) {
                return false;
            }
            for (int i = 0; i < (1 << n); i++) {
                if (dp[i]) {
                    for (int j = 0; j < n; j++) {
                        int temp = i | (1 << j);
                        if (temp != i) {
                            if (nums[j] <= (sum - (total[i] % sum))) {
                                dp[temp] = true;
                                total[temp] = nums[j] + total[i];
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            return dp[(1 << n) - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}