package leetcode.editor.cn;

import java.util.Stack;

//实现一个基本的计算器来计算一个简单的字符串表达式的值。
//
// 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格 。 
//
// 示例 1: 
//
// 输入: "1 + 1"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: " 2-1 + 2 "
//输出: 3 
//
// 示例 3: 
//
// 输入: "(1+(4+5+2)-3)+(6+8)"
//输出: 23 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 数学
public class BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
        int calculate = solution.calculate("1+(1+2)");
        System.out.println(calculate);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int res = 0;
            int number = 0;
            int sign = 1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    number = number * 10 + (int) (c - '0');
                } else if (c == '+') {
                    res += sign * number;
                    number = 0;
                    sign = 1;
                } else if (c == '-') {
                    res += sign * number;
                    number = 0;
                    sign = -1;
                } else if (c == '(') {
                    stack.push(res);
                    stack.push(sign);
                    res = 0;
                    sign = 1;
                } else if (c == ')') {
                    res += sign * number;
                    number = 0;
                    res *= stack.pop();
                    res += stack.pop();
                }
            }
            if (number != 0) {
                res += sign * number;
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
}