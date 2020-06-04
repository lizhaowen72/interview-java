package leetcode.editor.cn;
//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
// 
// Related Topics 哈希表 双指针 字符串

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            if (s == null || words == null || s.length() == 0 || words.length == 0) {
                return new ArrayList<Integer>();
            }
            Map<String, Integer> counts = new HashMap<>();
            for (String word : words) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
            List<Integer> res = new ArrayList<>();
            int slen = s.length();
            int num = words.length;
            int subLen = words[0].length();
            for (int i = 0; i <= slen - num * subLen; i ++) {
                String subStr = s.substring(i, i + num * subLen);
                if (isConcat(counts, subStr, subLen)) {
                    res.add(i);
                }
            }
            return res;
        }

        private boolean isConcat(Map<String, Integer> counts, String subStr, int subLen) {
            Map<String, Integer> seen = new HashMap<>();
            for (int i = 0; i < subStr.length(); i += subLen) {
                String word = subStr.substring(i, i + subLen);
                seen.put(word, seen.getOrDefault(word, 0) + 1);
            }
            return seen.equals(counts);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}