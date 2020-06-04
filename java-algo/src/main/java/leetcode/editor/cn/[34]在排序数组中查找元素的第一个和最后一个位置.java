package leetcode.editor.cn;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找

class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
         Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] searchRange(int[] nums, int target) {
            int low = 0;
            int hight = nums.length - 1;
            int[] res = new int[2];

            res[0] = helper(nums, low, hight, target, "first");
            res[1] = helper(nums, low, hight, target, "last");

            return res;
        }
        public  int helper(int[] nums, int low, int hight, int target, String flag) {
            while (low <= hight) {
                int mid = low + ((hight - low) >> 1);
                if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    hight = mid - 1;
                } else {
                    if ("first".equals(flag)) {
                        if (mid == 0 || nums[mid - 1] != target) {
                            return mid;
                        } else {
                            hight = mid - 1;
                        }
                    } else if ("last".equals(flag)) {
                        if (mid == nums.length - 1 || nums[mid + 1] != target) {
                            return mid;
                        } else {
                            low = mid + 1;
                        }
                    }
                }
            }
            return -1;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}