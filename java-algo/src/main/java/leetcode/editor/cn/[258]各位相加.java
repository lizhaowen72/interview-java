package leetcode.editor.cn;
//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。 
//
// 示例: 
//
// 输入: 38
//输出: 2 
//解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
// 
//
// 进阶: 
//你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？ 
// Related Topics 数学

class AddDigits {
    public static void main(String[] args) {
        Solution solution = new AddDigits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * I'll try to explain the math behind this:
         * <p>
         * First you should understand:
         * <p>
         * 10^k % 9 = 1
         * a*10^k % 9 = a % 9
         * Then let's use an example to help explain.
         * <p>
         * Say a number x = 23456
         * <p>
         * x = 2* 10000 + 3 * 1000 + 4 * 100 + 5 * 10 + 6
         * <p>
         * 2 * 10000 % 9 = 2 % 9
         * <p>
         * 3 * 1000 % 9 = 3 % 9
         * <p>
         * 4 * 100 % 9 = 4 % 9
         * <p>
         * 5 * 10 % 9 = 5 % 9
         * <p>
         * Then x % 9 = ( 2+ 3 + 4 + 5 + 6) % 9, note that x = 2* 10000 + 3 * 1000 + 4 * 100 + 5 * 10 + 6
         * <p>
         * So we have 23456 % 9 = (2 + 3 + 4 + 5 + 6) % 9
         *
         * @param num
         * @return
         */
        public int addDigits(int num) {
            if (num == 0) {
                return 0;
            }
            if (num % 9 == 0) {
                return 9;
            } else {
                return num % 9;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}