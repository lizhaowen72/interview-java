package leetcode.editor.cn;
//给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。 
//
// 示例 1: 
//
// 输入: nums = [1, 5, 1, 1, 6, 4]
//输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6] 
//
// 示例 2: 
//
// 输入: nums = [1, 3, 2, 2, 3, 1]
//输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2] 
//
// 说明: 
//你可以假设所有输入都会得到有效的结果。 
//
// 进阶: 
//你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？ 
// Related Topics 排序

import java.util.Arrays;

class WiggleSortIi {
    public static void main(String[] args) {
        Solution solution = new WiggleSortIi().new Solution();
        solution.wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wiggleSort(int[] nums) {
            int median = findMedianElement(nums, (nums.length + 1) / 2);
            int n = nums.length;
            int i = 0, left = 0, right = n - 1;
            while (i <= right) {
                int mappedCurIdx = newIndex(i, n);
                if (nums[mappedCurIdx] > median) {
                    int mappedLeftIndex = newIndex(left, n);
                    swap(nums, mappedCurIdx, mappedLeftIndex);
                    left++;
                    i++;
                } else if (nums[mappedCurIdx] < median) {
                    int mappedRightIdx = newIndex(right, n);
                    swap(nums, mappedCurIdx, mappedRightIdx);
                    right--;
                } else {
                    i++;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            if (i != j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        private int newIndex(int idx, int n) {
            return (1 + 2 * idx) % (n | 1);
        }

        private int findMedianElement(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}