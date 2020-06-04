package leetcode.editor.cn;
//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        solution.minWindow("FABECBAC", "ABC");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int[] map = new int[128];
            for (char c : t.toCharArray()) {
                map[c]++;
            }
            int start = 0, end = 0, minLen = Integer.MAX_VALUE, minStart = 0, counter = t.length();
            while (end < s.length()) {
                char c1 = s.charAt(end);
                if (map[c1] > 0) {
                    counter--;
                }
                map[c1]--;
                end++;
                while (counter == 0) {
                    if (minLen > end - start) {
                        minLen = end - start;
                        minStart = start;
                    }
                    char c2 = s.charAt(start);
                    map[c2]++;
                    if (map[c2] > 0) {
                        counter++;
                    }
                    start++;
                }
            }
            return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}