package leetcode.editor.cn;
//给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。 
//
// 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i, j < n 。 
//
// 你能在O(n)的时间解决这个问题吗？ 
//
// 示例: 
//
// 
//输入: [3, 10, 5, 25, 2, 8]
//
//输出: 28
//
//解释: 最大的结果是 5 ^ 25 = 28.
// 
// Related Topics 位运算 字典树

import java.util.HashSet;
import java.util.Set;

class MaximumXorOfTwoNumbersInAnArray {
    public static void main(String[] args) {
        Solution solution = new MaximumXorOfTwoNumbersInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaximumXOR(int[] nums) {
            /**
             * max是迄今为止我们获得的最大XOR的记录。 如果在i = 2处为11100，
             * 则意味着在到达最后两位之前，11100是我们拥有的最大XOR，
             * 我们将探讨是否可以再获得两个“ 1”并将其放入max中。
             * 这是一个贪婪的部分，因为我们正在寻找最大的XOR，所以我们从第31个位开始
             */
            int max = 0, mask = 0;
            for (int i = 31; i >= 0; i--) {
                //The mask will grow like  100..000 , 110..000, 111..000,  then 1111...111
                //for each iteration, we only care about the left parts
                mask = mask | (1 << i);
                Set<Integer> set = new HashSet<>();
                for (int num : nums) {
                    /*
                     * we only care about the left parts, for example, if i = 2, then we have {1100, 1000, 0100, 0000} from {1110, 1011, 0111, 0010}
                     */
                    set.add(num & mask);
                }
                // if i = 1 and before this iteration, the maxResult we have now is 1100,
                // my wish is the maxResult will grow to 1110, so I will try to find a candidate
                // which can give me the greedyTry;
                int temp = max | (1 << i);
                for (Integer prefix : set) {
                    //This is the most tricky part, coming from a fact that if a ^ b = c, then a ^ c = b;
                    // now we have the 'c', which is greedyTry, and we have the 'a', which is leftPartOfNum
                    // If we hope the formula a ^ b = c to be valid, then we need the b,
                    // and to get b, we need a ^ c, if a ^ c exisited in our set, then we're good to go
                    if (set.contains(temp ^ prefix)) {
                        max = temp;
                        break;
                    }
                }
                // If unfortunately, we didn't get the greedyTry, we still have our max,
                // So after this iteration, the max will stay at 1100.
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}