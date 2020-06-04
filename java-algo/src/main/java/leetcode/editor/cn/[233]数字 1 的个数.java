package leetcode.editor.cn;
//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 示例: 
//
// 输入: 13
//输出: 6 
//解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。 
// Related Topics 数学

class NumberOfDigitOne {
    public static void main(String[] args) {
        Solution solution = new NumberOfDigitOne().new Solution();
        solution.countDigitOne(10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            int ones = 0;
            for (long m = 1; m <= n; m *= 10) {
                ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
            }
            return ones;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}