package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法
public class CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> ans = new ArrayList<>();
            combination(ans, new ArrayList<Integer>(), k, 1, n);
            return ans;
        }

        private void combination(List<List<Integer>> ans, ArrayList<Integer> temp, int k, int start, int n) {
            if (temp.size() == k && n == 0) {
                ans.add(new ArrayList<>(temp));
                return;
            }
            for (int i = start; i <= 9; i++) {
                temp.add(i);
                combination(ans, temp, k, i + 1, n - i);
                temp.remove(temp.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}