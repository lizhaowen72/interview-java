package leetcode.editor.cn;
//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划

class UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
        int i = solution.nthUglyNumber(10);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] ugly = new int[n];
            ugly[0] = 1;
            int index2 = 0, index3 = 0, index5 = 0;
            int factor2 = 2, factor3 = 3, factor5 = 5;
            for (int i = 1; i < n; i++) {
                int min = Math.min(Math.min(factor2, factor3), factor5);
                ugly[i] = min;
                if (factor2 == min) {
                    factor2 = 2 * ugly[++index2];
                }
                if (factor3 == min) {
                    factor3 = 3 * ugly[++index3];
                }
                if (factor5 == min) {
                    factor5 = 5 * ugly[++index5];
                }
            }
            return ugly[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}