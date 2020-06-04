package leetcode.editor.cn;
//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。 
//
// 示例 1: 
//
// 输入: [3,0,1]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
// 
//
// 说明: 
//你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现? 
// Related Topics 位运算 数组 数学

public class MissingNumber {
    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
        int[] nums = {0, 1, 2, 4};
        int ret = solution.missingNumber(nums);
        System.out.println(ret);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * The basic idea is to use XOR operation.
         * We all know that a^b^b =a, which means two xor operations with
         * the same number will eliminate the number and reveal the original number.
         * In this solution, I apply XOR operation to both the index and value of the array.
         * In a complete array with no missing numbers, the index and value
         * should be perfectly corresponding( nums[index] = index), so in a missing array, what left finally is the missing number.
         *
         * @param nums
         * @return
         */
        public int missingNumber(int[] nums) {
            int xor = 0, i = 0;
            for (; i < nums.length; i++) {
                xor = xor ^ i ^ nums[i];
            }
            return xor ^ i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}