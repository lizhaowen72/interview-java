package leetcode.editor.cn;
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针

class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * The idea is to sweep all 0s to the left and all 2s to the right, then all 1s are left in the middle.
         * It is hard to define what is a "one-pass" solution but this algorithm is bounded by O(2n), meaning
         * that at most each element will be seen and operated twice (in the case of all 0s).
         * You may be able to write an algorithm which goes through the list only once,
         * but each step requires multiple operations, leading the total operations larger than O(2n).
         *
         * @param nums
         */
        public void sortColors(int[] nums) {
            int second = nums.length - 1, zero = 0;
            for (int i = 0; i <= second; i++) {
                while (nums[i] == 2 && i < second) {
                    swap(i, second--, nums);
                }
                while (nums[i] == 0 && i > zero) {
                    swap(i, zero++, nums);
                }
            }
        }

        private void swap(int i, int j, int[] nums) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}