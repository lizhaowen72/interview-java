package leetcode.editor.cn;
//给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符
//串。如果答案不存在，则返回空字符串。 
//
// 示例 1: 
//
// 
//输入:
//s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//输出: 
//"apple"
// 
//
// 示例 2: 
//
// 
//输入:
//s = "abpcplea", d = ["a","b","c"]
//
//输出: 
//"a"
// 
//
// 说明: 
//
// 
// 所有输入的字符串只包含小写字母。 
// 字典的大小不会超过 1000。 
// 所有输入的字符串长度不会超过 1000。 
// 
// Related Topics 排序 双指针

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
        List<String> list = Arrays.asList("ale", "apple", "monkey", "plea");
        solution.findLongestWord("abpcplea", list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> d) {
            Collections.sort(d, (a, b) -> a.length() == b.length() ? a.compareTo(b) : -Integer.compare(a.length(), b.length()));
            for (String dictWord : d) {
                int i = 0;
                for (char c : s.toCharArray()) {
                    if (i < dictWord.length() && c == dictWord.charAt(i)) {
                        i++;
                    }
                }
                if (i == dictWord.length()) {
                    return dictWord;
                }
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}