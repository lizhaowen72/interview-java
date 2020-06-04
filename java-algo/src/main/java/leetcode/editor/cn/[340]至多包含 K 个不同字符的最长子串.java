package leetcode.editor.cn;
//给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。 
//
// 示例 1: 
//
// 输入: s = "eceba", k = 2
//输出: 3
//解释: 则 T 为 "ece"，所以长度为 3。 
//
// 示例 2: 
//
// 输入: s = "aa", k = 1
//输出: 2
//解释: 则 T 为 "aa"，所以长度为 2。
// 
// Related Topics 哈希表 字符串 Sliding Window

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtMostKDistinctCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 对于最好情况，如果字符串不超过 k 个不同字符，答案是肯定的。因为只需要一次遍历就可以得到结果，时间复杂度是 O(N)
         *
         * 对于最坏情况，当输入字符串包含 n 个不同字符，答案是不能。因为每一步都需要花费 O(k) 时间找到哈希表中的最小值，所以总的复杂度是 O(Nk)。
         *
         * 时间复杂度：最好情况下是 O(N)O(N)，最坏情况下是 O(Nk)O(Nk)。
         * 空间复杂度：哈希表的空间开销：O(k)O(k)。
         *
         * @param k
         * @return
         */
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int n = s.length();
            if (n * k == 0) return 0;

            int left = 0;
            int right = 0;
            Map<Character, Integer> map = new HashMap<>();
            int max_len = 1;
            while (right < n) {
                map.put(s.charAt(right), right++);
                if (map.size() == k + 1) {
                    Integer del_idx = Collections.min(map.values());
                    map.remove(s.charAt(del_idx));
                    left = del_idx + 1;
                }
                max_len = Math.max(max_len, right - left);
            }
            return max_len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}