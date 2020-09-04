package leetcode.editor.cn;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("aba");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 基本思想是，保留一个将字符串中的字符存储为键并将其位置存储为值的哈希表，并保留两个定义最大子字符串的指针。
         * 移动右指针以浏览字符串，同时更新哈希图。 如果字符已经在哈希图中，则将左指针移到最后找到的相同字符的右边。
         * 请注意，两个指针只能向前移动
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>();
            int max = 0;
            for (int i = 0, j = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    // 将j指针移到最后找到的相同字符的右边
                    j = Math.max(j, map.get(c) + 1);
                }
                map.put(c, i);
                max = Math.max(max, i - j + 1);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}