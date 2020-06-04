package leetcode.editor.cn;
//给定一个未排序的整数数组，找出其中没有出现的最小的正整数。 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 说明: 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。 
// Related Topics 数组


class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        solution.firstMissingPositive(new int[]{-1, 2, 1, -3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int i = 0;
            while (i < nums.length) {
                if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] >= nums.length) {
                    i++;
                } else if (nums[nums[i]-1] != nums[i]) {
                    swap(nums,i,nums[i]-1);
                } else {
                    i++;
                }
            }
            i = 0;
            while (i < nums.length && nums[i] == i + 1) {
                i++;
            }
            return i + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}