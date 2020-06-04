package leetcode.editor.cn;
//给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为
//每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。 
//
// 示例 1: 
//
// 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
//输出: 16 
//解释: 这两个单词为 "abcw", "xtfn"。 
//
// 示例 2: 
//
// 输入: ["a","ab","abc","d","cd","bcd","abcd"]
//输出: 4 
//解释: 这两个单词为 "ab", "cd"。 
//
// 示例 3: 
//
// 输入: ["a","aa","aaa","aaaa"]
//输出: 0 
//解释: 不存在这样的两个单词。 
// Related Topics 位运算

class MaximumProductOfWordLengths {
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfWordLengths().new Solution();
        solution.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(String[] words) {
            if (words == null || words.length == 0) return 0;
            int len = words.length;
            int[] values = new int[len];
            for (int i = 0; i < words.length; i++) {
                String temp = words[i];
                values[i] = 0;
                for (int j = 0; j < temp.length(); j++) {
                    values[i] |= 1 << (temp.charAt(j) - 'a');
                }
            }
            int maxProduct = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if ((values[i] & values[j]) == 0 && (words[i].length() * words[j].length() > maxProduct)) {
                        maxProduct = words[i].length() * words[j].length();
                    }
                }
            }
            return maxProduct;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}