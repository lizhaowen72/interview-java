package leetcode.editor.cn;
//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            backTrace(res, "", 0, 0, n);
            return res;
        }

        private void backTrace(List<String> res, String s, int open, int close, int n) {
            // 递归结束条件
            if (s.length() == n * 2) {
                res.add(s);
                return;
            }
            if (open < n) {
                backTrace(res, s + "(", open + 1, close, n);
            }
            if (close < open) {
                backTrace(res, s + ")", open, close + 1, n);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}