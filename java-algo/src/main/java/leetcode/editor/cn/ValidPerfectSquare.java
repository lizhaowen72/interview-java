package leetcode.editor.cn;
//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找


public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        solution.isPerfectSquare(16);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            /**
             * Newton Method
             */
            long x = num;
            while (x * x > num) {
                x = (x + num / x) >> 1;
            }
            return x * x == num;

        }

        /**
         * O(log(n))
         *
         * @param num
         * @return
         */
        public boolean isPerfectSquare2(int num) {
            int low = 1, high = num;
            while (low <= high) {
                long mid = (low + high) >>> 1;
                if (mid * mid == num) {
                    return true;
                } else if (mid * mid < num) {
                    low = (int) mid + 1;
                } else {
                    high = (int) mid - 1;
                }
            }
            return false;
        }


        /**
         * 1=1
         * 4=1+3
         * 9=1+3+5
         * 16=1+3+5+7
         * ...
         * so 1+3+5+...+(2n-1)=(1+2n-1)n/2=nn
         * time complexity is O(sqrt(n))
         *
         * @param num
         * @return
         */
        public boolean isPerfectSquare1(int num) {
            int i = 1;
            while (num > 0) {
                num -= i;
                i += 2;
            }
            return num == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}