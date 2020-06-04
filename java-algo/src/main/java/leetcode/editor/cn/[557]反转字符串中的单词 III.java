package leetcode.editor.cn;
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 示例 1: 
//
// 
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
// 
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// Related Topics 字符串

class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            if (s == null) return null;
            int len = s.length();
            char[] chars = s.toCharArray();
            // reverse the whole world
            //reverseWholeWorld(chars, 0, len - 1);

            // reverse s'each world
            reverEachWorld(chars, len);
            return String.valueOf(chars);
        }

        private void reverEachWorld(char[] chars, int len) {
            int i = 0, j = 0;
            while (i < len) {
                while (i < j || i < len && chars[i] == ' ') {
                    i++;
                }
                while (i > j || j < len && chars[j] != ' ') {
                    j++;
                }
                reverseWholeWorld(chars, i, j - 1);
            }
        }

        private void reverseWholeWorld(char[] chars, int i, int j) {
            while (i < j) {
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}