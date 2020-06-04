package leetcode.editor.cn;
//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 108] 
// 
// Related Topics 数组 数学


import java.util.Arrays;

public class MaximumSwap {
    public static void main(String[] args) {
        Solution solution = new MaximumSwap().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            // 1.排序数组
            char[] orderNum = String.valueOf(num).toCharArray();
            char[] oldNum = orderNum;
            Arrays.sort(orderNum);

            int diff = -1;
            for (int i = 0; i < orderNum.length; i++) {
                if (oldNum[i] != orderNum[orderNum.length - 1 - i]) {
                    diff = i;
                    break;
                }
            }
            if (diff == -1) {
                return num;
            }
            for (int i = oldNum.length - 1; i >= diff; i++) {
                if (oldNum[i] == orderNum[orderNum.length - 1 - diff]) {
                    swap(oldNum, diff, i);
                }
            }
            return 0;
        }

        private void swap(char[] oldNum, int diff, int i) {

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}