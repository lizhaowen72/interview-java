package leetcode.editor.cn;
//给定一个未排序的整数数组，找出最长连续序列的长度。 
//
// 要求算法的时间复杂度为 O(n)。 
//
// 示例: 
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。 
// Related Topics 并查集 数组

import java.util.HashMap;
import java.util.Map;

class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            int res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (!map.containsKey(num)) {
                    int left = (map.containsKey(num - 1)) ? map.get(num - 1) : 0;
                    int right = (map.containsKey(num + 1)) ? map.get(num + 1) : 0;
                    int sum = left + right + 1;
                    map.put(num, sum);

                    res = Math.max(res, sum);
                    map.put(num - left, sum);
                    map.put(num + right, sum);
                } else {
                    continue;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}