package leetcode.editor.cn;
//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2 
//
// 说明: 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 数学 二分查找

class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
        solution.divide(10, 2);
        System.out.println(1 << 31);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int A, int B) {
            if (A == 1 << 31 && B == -1) {
                return (1 << 31) - 1;
            }
            int a = Math.abs(A), b = Math.abs(B), res = 0;
            for (int x = 31; x >= 0; x--) {
                if ((a >>> x) - b >= 0) {
                    res += 1 << x;
                    a -= b << x;
                }
            }
            return (A > 0) == (B > 0) ? res : -res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}