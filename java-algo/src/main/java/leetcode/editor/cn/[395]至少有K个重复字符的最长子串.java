package leetcode.editor.cn;
//找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。 
//
// 示例 1: 
//
// 
//输入:
//s = "aaabb", k = 3
//
//输出:
//3
//
//最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2: 
//
// 
//输入:
//s = "ababbc", k = 2
//
//输出:
//5
//
//最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
// 
//

import java.util.Arrays;

class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        String s = "ababbca";
        int k = 2;
        solution.longestSubstring(s, k);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解题思路：递归拆分子串，分治。先统计出每个字符出现的频次，维护一对双指针，从首尾开始统计，从首尾往中间排除，
         * 如果出现次数小于k则不可能出现在最终子串中，排除并挪动指针，然后得到临时子串，依次从头遍历，
         * 一旦发现出现频次小于k的字符，以该字符为分割线，分别递归求其最大值返回
         *
         * @param s
         * @param k
         * @return
         */
        public int longestSubstring(String s, int k) {
            int len = s.length();
            if (len == 0 || len < k) return 0;
            if (k < 2) return len;
            return count(s.toCharArray(), 0, len-1, k);
        }

        private int count(char[] chars, int p1, int p2, int k) {
            if (p2 - p1 + 1 < k) return 0;
            int[] times = new int[26];
            for (int i = p1; i <= p2; i++) {
                times[chars[i] - 'a']++;
            }
            while (p2 - p1 + 1 > k && times[chars[p1] - 'a'] < k) {
                p1++;
            }
            while (p2 - p1 + 1 > k && times[chars[p2] - 'a'] < k) {
                p2--;
            }
            if (p2 - p1 + 1 < k) return 0;
            for (int i = p1; i <= p2; i++) {
                if (times[chars[i] - 'a'] < k) {
                    return Math.max(count(chars, p1, i - 1, k), count(chars, i + 1, p2, k));
                }
            }
            return p2 - p1 + 1;
        }

        public int longestSubstring2(String s, int k) {
            char[] str = s.toCharArray();
            int[] counts = new int[26];
            int h, left, right, idx, max = 0, unique, noLessThanK;
            for (h = 1; h <= 26; h++) {
                Arrays.fill(counts, 0);
                left = 0;
                right = 0;
                unique = 0;
                noLessThanK = 0;
                while (right < str.length) {
                    if (unique <= h) {
                        idx = str[right] - 'a';
                        if (counts[idx] == 0) {
                            unique++;
                        }
                        counts[idx]++;
                        if (counts[idx] == k) {
                            noLessThanK++;
                        }
                        right++;
                    } else {
                        idx = str[left] - 'a';
                        if (counts[idx] == k) {
                            noLessThanK--;
                        }
                        counts[idx]--;
                        if (counts[idx] == 0) {
                            unique--;
                        }
                        left++;
                    }
                    if (unique == h && unique == noLessThanK) {
                        max = Math.max(right - left, max);
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}