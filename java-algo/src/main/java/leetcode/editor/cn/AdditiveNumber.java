package leetcode.editor.cn;
//累加数是一个字符串，组成它的数字可以形成累加序列。
//
// 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。 
//
// 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。 
//
// 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。 
//
// 示例 1: 
//
// 输入: "112358"
//输出: true 
//解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// 
//
// 示例 2: 
//
// 输入: "199100199"
//输出: true 
//解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199 
//
// 进阶: 
//你如何处理一个溢出的过大的整数输入? 
// Related Topics 回溯算法


public class AdditiveNumber {
    public static void main(String[] args) {
        Solution solution = new AdditiveNumber().new Solution();
        solution.isAdditiveNumber("123");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAdditiveNumber(String num) {
            int n = num.length();
            for (int i = 1; i <= n / 2; i++) {
                for (int j = 1; j <= n - i - j; j++) {
                    if (isValid(i, j, num)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean isValid(int i, int j, String num) {
            if (num.charAt(0) == '0' && i > 1) {
                return false;
            }
            if (num.charAt(i) == '0' && j > 1) {
                return false;
            }
            String sum;
            Long x1 = Long.parseLong(num.substring(0, i));
            Long x2 = Long.parseLong(num.substring(i, j + i));
            for (int start = i + j; start != num.length(); start += sum.length()) {
                x2 = x1 + x2;
                x1 = x2 - x1;
                sum = x2.toString();
                if (!num.startsWith(sum, start)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}