package leetcode.editor.cn;
//删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
//
// 说明: 输入可能包含了除 ( 和 ) 以外的字符。 
//
// 示例 1: 
//
// 输入: "()())()"
//输出: ["()()()", "(())()"]
// 
//
// 示例 2: 
//
// 输入: "(a)())()"
//输出: ["(a)()()", "(a())()"]
// 
//
// 示例 3: 
//
// 输入: ")("
//输出: [""] 
// Related Topics 深度优先搜索 广度优先搜索


import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        Solution solution = new RemoveInvalidParentheses().new Solution();
        solution.removeInvalidParentheses("()())()");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> ans = new ArrayList<>();
            remove(s, ans, 0, 0, new char[]{'(', ')'});
            return ans;
        }

        private void remove(String s, List<String> ans, int last_i, int last_j, char[] chars) {
            for (int stack = 0, i = last_i; i < s.length(); i++) {
                if (s.charAt(i) == chars[0]) stack++;
                if (s.charAt(i) == chars[1]) stack--;
                if (stack >= 0) continue;
                for (int j = last_j; j <= i; j++) {
                    if (s.charAt(j) == chars[1] && (j == last_j || s.charAt(j - 1) != chars[1])) {
                        remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, chars);
                    }
                }
                return;
            }
            String reversed = new StringBuilder(s).reverse().toString();
            if (chars[0] == '(') {
                remove(reversed, ans, 0, 0, new char[]{')', '('});
            } else {
                ans.add(reversed);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}