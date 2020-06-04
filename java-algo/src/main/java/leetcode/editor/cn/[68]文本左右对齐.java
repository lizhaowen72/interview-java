package leetcode.editor.cn;
//给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 说明: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 示例: 
//
// 输入:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 输入:
//words = ["What","must","be","acknowledgment","shall","be"]
//maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 输入:
//words = ["Science","is","what","we","understand","well","enough","to","explain
//",
//         "to","a","computer.","Art","is","everything","else","we","do"]
//maxWidth = 20
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
// Related Topics 字符串

import java.util.ArrayList;
import java.util.List;

class TextJustification {
    public static void main(String[] args) {
        Solution solution = new TextJustification().new Solution();
        solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            int left = 0;
            List<String> res = new ArrayList<>();
            while (left < words.length) {
                int right = findRight(left, words, maxWidth);
                res.add(justify(left, right, words, maxWidth));
                left = right + 1;
            }
            return res;
        }

        private String justify(int left, int right, String[] words, int maxWidth) {
            if (right - left == 0) {
                return padResult(words[left], maxWidth);
            }
            boolean isLastLine = right == words.length - 1;
            int numSpaces = right - left;
            int totalSpaces = maxWidth - wordsLength(left, right, words);
            String space = isLastLine ? " " : blank(totalSpaces / numSpaces);
            int remainder = isLastLine ? 0 : totalSpaces % numSpaces;

            StringBuilder res = new StringBuilder();
            for (int i = left; i <= right; i++) {
                res.append(words[i]).append(space).append(remainder-- > 0 ? " " : "");
            }
            return padResult(res.toString().trim(), maxWidth);
        }

        private String padResult(String res, int maxWidth) {
            return res + blank(maxWidth - res.length());
        }

        private String blank(int len) {
            return new String(new char[len]).replace('\0', ' ');
        }

        private int wordsLength(int left, int right, String[] words) {
            int wordsLength = 0;
            for (int i = left; i <= right; i++) {
                wordsLength += words[i].length();
            }
            return wordsLength;
        }

        private int findRight(int left, String[] words, int maxWidth) {
            int right = left;
            int sum = words[right++].length();
            while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth) {
                sum += 1 + words[right++].length();
            }
            return right - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}