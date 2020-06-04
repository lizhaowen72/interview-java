package leetcode.editor.cn;

//给定一个整数 n，返回 n! 结果尾数中零的数量。
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new FactorialTrailingZeroes().new Solution();
        solution.trailingZeroes(5);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            int cnt = 0;
            while (n > 0) {
                cnt += n / 5;
                n /= 5;
            }
            return cnt;
        }

        /**
         * This question is pretty straightforward.
         * <p>
         * Because all trailing 0 is from factors 5 * 2.
         * <p>
         * But sometimes one number may have several 5 factors,
         * <p>
         * for example, 25 have two 5 factors, 125 have three 5 factors.
         * <p>
         * In the n! operation, factors 2 is always ample. So we just count how many 5 factors in all number from 1 to n.
         *
         * @param n
         * @return
         */
        public int trailingZeroes2(int n) {
            return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}