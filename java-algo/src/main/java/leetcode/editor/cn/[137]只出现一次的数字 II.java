package leetcode.editor.cn;
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,3,2]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [0,1,0,1,0,1,99]
//输出: 99 
// Related Topics 位运算

class SingleNumberIi {
    public static void main(String[] args) {
        Solution solution = new SingleNumberIi().new Solution();
        solution.singleNumber(new int[]{2,2,3,2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int ones = 0, twos = 0;
            for (int i = 0; i < nums.length; i++) {
                ones = (ones ^ nums[i]) & ~twos;
                twos = (twos ^ nums[i]) & ~ones;
            }
            return ones;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}