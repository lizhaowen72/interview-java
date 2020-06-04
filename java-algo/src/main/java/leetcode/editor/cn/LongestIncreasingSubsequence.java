package leetcode.editor.cn;
//给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划


public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        int[] nums = {4, 5, 6, 3};
        solution.lengthOfLIS(nums);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length];
            int size = 0;
            for (int x : nums) {
                int i = 0, j = size;
                while (i != j) {
                    int mid = i + (j - i) / 2;
                    if (tails[mid] < x) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }
                tails[i] = x;
                if (i == size) {
                    ++size;
                }
            }
            return size;
        }

        public int lengthOfLIS2(int[] nums) {
            if (nums.length == 0) return 0;
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int maxAns = 1;
            for (int i = 1; i < dp.length; i++) {
                int maxVal = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        maxVal = Math.max(maxVal, dp[j]);
                    }
                }
                dp[i] = maxVal + 1;
                maxAns = Math.max(maxAns, dp[i]);
            }
            return maxAns;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}