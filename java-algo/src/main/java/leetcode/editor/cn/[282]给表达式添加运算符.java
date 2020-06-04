package leetcode.editor.cn;
//给定一个仅包含数字 0-9 的字符串和一个目标值，在数字之间添加二元运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。 
//
// 示例 1: 
//
// 输入: num = "123", target = 6
//输出: ["1+2+3", "1*2*3"] 
// 
//
// 示例 2: 
//
// 输入: num = "232", target = 8
//输出: ["2*3+2", "2+3*2"] 
//
// 示例 3: 
//
// 输入: num = "105", target = 5
//输出: ["1*0+5","10-5"] 
//
// 示例 4: 
//
// 输入: num = "00", target = 0
//输出: ["0+0", "0-0", "0*0"]
// 
//
// 示例 5: 
//
// 输入: num = "3456237490", target = 9191
//输出: []
// 
// Related Topics 分治算法

import java.util.ArrayList;
import java.util.List;

class ExpressionAddOperators {
    public static void main(String[] args) {
        Solution solution = new ExpressionAddOperators().new Solution();
        String num = "232";
        int target = 8;
        solution.addOperators(num, target);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> addOperators(String num, int target) {
            List<String> rst = new ArrayList<>();
            if (num == null || num.length() == 0) return rst;
            helper(rst, "", num, target, 0, 0, 0);
            return rst;
        }

        private void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
            if (pos == num.length()) {
                if (target == eval) {
                    rst.add(path);
                }
                return;
            }
            for (int i = pos; i < num.length(); i++) {
                if (i != pos && num.charAt(pos) == '0') break;
                long cur = Long.parseLong(num.substring(pos, i + 1));
                if (pos == 0) {
                    helper(rst, path + cur, num, target, i + 1, cur, cur);
                } else {
                    helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                    helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                    helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}