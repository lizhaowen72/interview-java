package leetcode.editor.cn;
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        int[] candidates = {2, 5, 2, 1, 2};
        solution.combinationSum2(candidates, 5);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            combinationSum2(candidates, res, new ArrayList<Integer>(), target, 0);
            return res;
        }

        private void combinationSum2(int[] candidates, List<List<Integer>> res, ArrayList<Integer> tempList, int sum, int start) {
            if (sum < 0) {
                return;
            } else if (sum == 0) {
                res.add(new ArrayList<>(tempList));
            } else {
                for (int i = start; i <= candidates.length - 1; i++) {
                    if (i > start && candidates[i] == candidates[i - 1]) {
                        continue;
                    }
                    tempList.add(candidates[i]);
                    combinationSum2(candidates, res, tempList, sum - candidates[i], i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}