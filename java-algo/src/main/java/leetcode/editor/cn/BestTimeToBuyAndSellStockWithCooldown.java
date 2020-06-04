package leetcode.editor.cn;
//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划


public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
        int[] prices={1,2,3,0,2};
        solution.maxProfit(prices);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //sell表示第i天不持有股票的最大利润，hold表示第i天持有股票的最大利润，股票可以保留、买入和卖出
        //这里注意有冷冻期，即第i天持有股票的最大利润依靠的是冷冻期前一天的不持有股票的最大利润
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n == 0) {
                return 0;
            }
            int sell = 0, hold = -prices[0], preDay = sell;
            for (int i = 1; i < prices.length; i++) {
                int tmp = sell;
                // 保留或者卖出第i-1天的股票
                sell = Math.max(sell, hold + prices[i]);
                // 保留或者经历冷冻期,通过第i-2天不持有股票的利润买入股票
                hold = Math.max(hold, preDay - prices[i]);
                // 更新冷冻期前一天的利润
                preDay = tmp;
            }
            return sell;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}