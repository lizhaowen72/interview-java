package leetcode.editor.cn;
//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        int[] nums = {1, 0, -1, 0, -2, 2};
        solution.fourSum(nums, 0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int len = 0;

        public List<List<Integer>> fourSum(int[] nums, int target) {
            len = nums.length;
            Arrays.sort(nums);
            return kSum(nums, target, 4, 0);
        }

        private List<List<Integer>> kSum(int[] nums, int target, int k, int index) {
            List<List<Integer>> res = new ArrayList<>();
            if (index >= len) {
                return res;
            }
            if (k == 2) {
                int i = index, j = len - 1;
                while (i < j) {
                    // find a pair
                    if (target - nums[i] == nums[j]) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(target - nums[i]);
                        res.add(temp);
                        // skip duplication
                        while (i < j && nums[i] == nums[i + 1]) i++;
                        while (i < j && nums[j - 1] == nums[j]) j--;
                        i++;
                        j--;
                    } else if (target - nums[i] > nums[j]) {
                        i++;
                    } else {
                        j--;
                    }
                }
            } else {
                for (int i = index; i < len - k + 1; i++) {
                    List<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
                    if (temp != null) {
                        // add previous results
                        for (List<Integer> t : temp) {
                            t.add(0, nums[i]);
                        }
                        res.addAll(temp);
                    }
                    while (i < len - 1 && nums[i] == nums[i + 1]) {
                        // skip duplicated numbers
                        i++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}