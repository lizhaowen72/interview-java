package leetcode.editor.cn;
//给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t 。 
//
// 示例 1: 
//
// 输入: "eceba"
//输出: 3
//解释: t 是 "ece"，长度为3。
// 
//
// 示例 2: 
//
// 输入: "ccaabbb"
//输出: 5
//解释: t 是 "aabbb"，长度为5。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtMostTwoDistinctCharacters().new Solution();
        solution.lengthOfLongestSubstringTwoDistinct("eceba");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int len = s.length();
            if (len < 3) return len;
            int max_len = 2;
            int left = 0, right = 0;
            Map<Character, Integer> map = new HashMap<>();
            while (right < len) {
                if (map.size() < 3) {
                    map.put(s.charAt(right), right++);
                }
                if (map.size() == 3) {
                    int del_index = Collections.min(map.values());
                    map.remove(s.charAt(del_index));
                    left = del_index + 1;
                }
                max_len = Math.max(max_len, right - left);
            }
            return max_len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}