package leetcode.editor.cn;
//给你一个无序的数组 nums, 将该数字 原地 重排后使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。 
//
// 示例: 
//
// 输入: nums = [3,5,2,1,6,4]
//输出: 一个可能的解答是 [3,5,1,6,2,4] 
// Related Topics 排序 数组

import java.util.Arrays;

class WiggleSort {
    public static void main(String[] args) {
        Solution solution = new WiggleSort().new Solution();
        solution.wiggleSort(new int[]{3, 5, 2, 1, 6, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wiggleSort(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if ((i % 2 == 1) == (nums[i] < nums[i + 1])) {
                    swap(nums, i, i + 1);
                }
            }
        }

        public void wiggleSort3(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (((i % 2 == 0) && nums[i] > nums[i + 1]) || ((i % 2 == 1) && nums[i] < nums[i + 1])) {
                    swap(nums, i, i + 1);
                }
            }
        }

        public void wiggleSort2(int[] nums) {
            boolean flag = true;
            for (int i = 0; i < nums.length - 1; i++) {
                if (flag) {
                    if (nums[i] > nums[i + 1]) {
                        swap(nums, i, i + 1);
                    }
                } else {
                    if (nums[i] < nums[i + 1]) {
                        swap(nums, i, i + 1);
                    }
                }
                flag = !flag;
            }
        }

        public void wiggleSort1(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length - 1; i += 2) {
                swap(nums, i, i + 1);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}