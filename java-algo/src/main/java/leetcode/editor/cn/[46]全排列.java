package leetcode.editor.cn;
//给定一个没有重复数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

import java.util.ArrayList;
import java.util.List;

class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = {1, 2};
        solution.permute(nums);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backTrack(res, new ArrayList<Integer>(), nums);
            return res;
        }

        private void backTrack(List<List<Integer>> res, ArrayList<Integer> tempList, int[] nums) {
            if (tempList.size() == nums.length) {
                res.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                backTrack(res, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}