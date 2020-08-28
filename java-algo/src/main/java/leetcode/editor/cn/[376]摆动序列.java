package leetcode.editor.cn;
//如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。 
//
// 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,
//4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。 
//
// 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。 
//
// 示例 1: 
//
// 输入: [1,7,4,9,2,5]
//输出: 6 
//解释: 整个序列均为摆动序列。
// 
//
// 示例 2: 
//
// 输入: [1,17,5,10,13,15,10,5,16,8]
//输出: 7
//解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。 
//
// 示例 3: 
//
// 输入: [1,2,3,4,5,6,7,8,9]
//输出: 2 
//
// 进阶: 
//你能否用 O(n) 时间复杂度完成此题? 
// Related Topics 贪心算法 动态规划 
// 👍 229 👎 0

class WiggleSubsequence {
    public static void main(String[] args) {
        Solution solution = new WiggleSubsequence().new Solution();
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        solution.wiggleMaxLength(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * For every position in the array, there are only three possible statuses for it.
         * <p>
         * up position, it means nums[i] > nums[i-1]
         * down position, it means nums[i] < nums[i-1]
         * equals to position, nums[i] == nums[i-1]
         * So we can use two arrays up[] and down[] to record the max wiggle sequence length so far at index i.
         * If nums[i] > nums[i-1], that means it wiggles up. the element before it must be a down position. so up[i] = down[i-1] + 1; down[i] keeps the same with before.
         * If nums[i] < nums[i-1], that means it wiggles down. the element before it must be a up position. so down[i] = up[i-1] + 1; up[i] keeps the same with before.
         * If nums[i] == nums[i-1], that means it will not change anything becasue it didn't wiggle at all. so both down[i] and up[i] keep the same.
         * <p>
         * In fact, we can reduce the space complexity to O(1), but current way is more easy to understanding.
         *
         * @param nums
         * @return
         */
        public int wiggleMaxLength(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int len = nums.length;
            int[] up = new int[len];
            int[] down = new int[len];
            up[0] = 1;
            down[0] = 1;
            for (int i = 1; i < len; i++) {
                if (nums[i] > nums[i - 1]) {
                    up[i] = down[i - 1] + 1;
                    down[i] = down[i - 1];
                } else if (nums[i] < nums[i - 1]) {
                    down[i] = up[i - 1] + 1;
                    up[i] = up[i - 1];
                } else {
                    down[i] = down[i - 1];
                    up[i] = up[i - 1];
                }
            }
            return Math.max(down[len - 1], up[len - 1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}