package leetcode.editor.cn;
//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] nums = {1, 2, 2};
        solution.permuteUnique(nums);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            backTrack(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
            return res;
        }

        private void backTrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, boolean[] used) {
            if (tempList.size() == nums.length) {
                res.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                backTrack(res, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}