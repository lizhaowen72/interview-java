package leetcode.editor.cn;
//不使用运算符 + 和 - ，计算两整数 a 、b 之和。
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算


public class SumOfTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new SumOfTwoIntegers().new Solution();
        solution.getSum(3, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getSum(int a, int b) {
            if (a == 0) return b;
            if (b == 0) return a;
            while (b != 0) {
                int carry = a & b;
                a = a ^ b;
                b = carry << 1;
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}