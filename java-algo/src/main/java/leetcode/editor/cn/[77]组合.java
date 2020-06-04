package leetcode.editor.cn;
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Combinations{
    public static void main(String[] args) {
         Solution solution = new Combinations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            if (n <= 0 || k <= 0 || n < k) {
                return res;
            }
            // 从1开始就是题目的设定
            findCombinations(n, k, 1, new Stack<>());
            return res;
        }

        private void findCombinations(int n, int k, int begin, Stack<Integer> stack) {
            if (stack.size() == k) {
                // 够数了,就添加到结果集中
                res.add(new ArrayList<>(stack));
                return;
            }
            // 关键在于分析出i的上界
            for (int i = begin; i <= n - (k - stack.size()) + 1; i++) {
                stack.add(i);
                findCombinations(n, k, i + 1, stack);
                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}