package leetcode.editor.cn;
//给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
//
// word1 和 word2 是有可能相同的，并且它们将分别表示为列表中两个独立的单词。 
//
// 示例: 
//假设 words = ["practice", "makes", "perfect", "coding", "makes"]. 
//
// 输入: word1 = “makes”, word2 = “coding”
//输出: 1
// 
//
// 输入: word1 = "makes", word2 = "makes"
//输出: 3
// 
//
// 注意: 
//你可以假设 word1 和 word2 都在列表里。 
// Related Topics 数组


public class ShortestWordDistanceIii {
    public static void main(String[] args) {
        Solution solution = new ShortestWordDistanceIii().new Solution();
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        solution.shortestWordDistance(words, "makes", "makes");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestWordDistance(String[] words, String word1, String word2) {
            int res = words.length;
            int first = -1;
            int second = -1;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    first = i;
                }
                if (words[i].equals(word2)) {
                    if (words[i].equals(word1)) {
                        first = second;
                    }
                    second = i;
                }
                if (first != -1 && second != -1) {
                    res = Math.min(res, Math.abs(second - first));
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}