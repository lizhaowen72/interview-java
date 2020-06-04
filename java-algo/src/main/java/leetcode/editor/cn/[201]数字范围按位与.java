package leetcode.editor.cn;
//给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。 
//
// 示例 1: 
//
// 输入: [5,7]
//输出: 4 
//
// 示例 2: 
//
// 输入: [0,1]
//输出: 0 
// Related Topics 位运算

class BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        Solution solution = new BitwiseAndOfNumbersRange().new Solution();
        solution.rangeBitwiseAnd(5, 7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * The hardest part of this problem is to find the regular pattern.
         * For example, for number 26 to 30
         * Their binary form are:
         * 11010
         * 11011
         * 11100　　
         * 11101　　
         * 11110
         *
         * Because we are trying to find bitwise AND, so if any bit there are at least one 0 and one 1, it always 0. In this case, it is 11000.
         * So we are go to cut all these bit that they are different. In this case we cut the right 3 bit.
         * @param m
         * @param n
         * @return
         */
        public int rangeBitwiseAnd(int m, int n) {
            int i = 0;
            while (m != n) {
                m >>= 1;
                n >>= 1;
                i++;
            }
            return m << i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}