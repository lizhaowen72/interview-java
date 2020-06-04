package leetcode.editor.cn;
//给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。 
//
// 示例: 
//假设 words = ["practice", "makes", "perfect", "coding", "makes"] 
//
// 输入: word1 = “coding”, word2 = “practice”
//输出: 3
// 
//
// 输入: word1 = "makes", word2 = "coding"
//输出: 1
// 
//
// 注意: 
//你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。 
// Related Topics 数组

class ShortestWordDistance {
    public static void main(String[] args) {
        Solution solution = new ShortestWordDistance().new Solution();
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding", word2 = "practice";
        solution.shortestDistance(words, word1, word2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestDistance(String[] words, String word1, String word2) {
            int i1 = -1, i2 = -1;
            int minDist = words.length;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    i1 = i;
                }
                if (words[i].equals(word2)) {
                    i2 = i;
                }
                if (i1 != -1 && i2 != -1) {
                    minDist = Math.min(minDist, Math.abs(i2 - i1));
                }
            }
            return minDist;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}