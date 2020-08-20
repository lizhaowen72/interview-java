package leetcode.editor.cn;
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。 
//
// 注意你不能在买入股票前卖出股票。 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划

class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        int[] prices = {7, 1, 5, -3, 6, 4};
        int i = solution.maxProfit2(prices);
        System.out.println(i);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm.
         * Since no body has mentioned this so far, I thought it's a good thing for everybody to know.
         * <p>
         * All the straight forward solution should work, but if the interviewer twists the question slightly by giving
         * the difference array of prices, Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}, you might end up being confused.
         * <p>
         * Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, and
         * find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.
         * <p>
         * maxCur = current maximum value
         * <p>
         * maxSoFar = maximum value found so far
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
           int maxCurr=0;
           int maxSoFar=0;
            for (int i = 1; i < prices.length; i++) {
                maxCurr+=prices[i]-prices[i-1];
                maxCurr=Math.max(maxCurr,0);
                maxSoFar=Math.max(maxCurr,maxSoFar);
            }
            return maxSoFar;
        }

        /**
         * 时间复杂度：O(n)，只需要遍历一次。
         * 空间复杂度：O(1)，只使用了两个变量。
         *
         * @param prices
         * @return
         */
        public int maxProfit2(int prices[]) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (minPrice > prices[i]) {
                    minPrice = prices[i];
                }
                if (prices[i] - minPrice > maxProfit) {
                    maxProfit = prices[i] - minPrice;
                }
            }
            return maxProfit;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}