package leetcode.editor.cn;

import java.util.Arrays;

//给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
//
// 如果数组元素个数小于 2，则返回 0。 
//
// 示例 1: 
//
// 输入: [3,6,9,1]
//输出: 3
//解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。 
//
// 示例 2: 
//
// 输入: [10]
//输出: 0
//解释: 数组元素个数小于 2，因此返回 0。 
//
// 说明: 
//
// 
// 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。 
// 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。 
// 
// Related Topics 排序
public class MaximumGap {
    public static void main(String[] args) {
        Solution solution = new MaximumGap().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Suppose there are N elements in the array, the min value is min and the max value is max. Then the maximum gap will be no smaller than ceiling[(max - min ) / (N - 1)].
         * <p>
         * Let gap = ceiling[(max - min ) / (N - 1)]. We divide all numbers in the array into n-1 buckets, where k-th bucket contains all numbers in [min + (k-1)gap, min + k*gap).
         * <p>
         * Since there are n-2 numbers that are not equal min or max and there are n-1 buckets, at least one of the buckets are empty. We only need to store the largest number and
         * <p>
         * the smallest number in each bucket.
         * <p>
         * After we put all the numbers into the buckets. We can scan the buckets sequentially and get the max gap
         *
         * @param nums
         * @return
         */
        public int maximumGap(int[] nums) {
            if (nums == null || nums.length < 2) {
                return 0;
            }
            // get the max and min value of the array
            int min = nums[0];
            int max = nums[1];
            for (int i = 0; i < nums.length; i++) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }
            int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
            int[] bucketMIN = new int[nums.length - 1];
            int[] bucketMAX = new int[nums.length - 1];
            Arrays.fill(bucketMIN, Integer.MAX_VALUE);
            Arrays.fill(bucketMAX, Integer.MIN_VALUE);
            for (int num : nums) {
                if (num == min || num == max) {
                    continue;
                }
                int idx = (num - min) / gap;
                bucketMIN[idx] = Math.min(num, bucketMIN[idx]);
                bucketMAX[idx] = Math.max(num, bucketMAX[idx]);
            }
            int maxGap = Integer.MIN_VALUE;
            int previos = min;
            for (int i = 0; i < nums.length - 1; i++) {
                if (bucketMIN[i] == Integer.MAX_VALUE && bucketMAX[i] == Integer.MIN_VALUE) {
                    continue;
                }
                maxGap = Math.max(maxGap, bucketMIN[i] - previos);
                previos = bucketMAX[i];
            }
            maxGap = Math.max(maxGap, max - previos);
            return maxGap;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}