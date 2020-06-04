package leetcode.editor.cn;
//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 示例： 
//
// 输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
//输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"] 
//
// 注意： 
//
// 
// 单词的定义是不包含空格的一系列字符 
// 输入字符串中不会包含前置或尾随的空格 
// 单词与单词之间永远是以单个空格隔开的 
// 
//
// 进阶：使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 字符串

class ReverseWordsInAStringIi {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIi().new Solution();
        solution.reverseWords(new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseWords(char[] s) {
            // 反转整个数组
            reverseWholeArray(s, 0, s.length - 1);

            // 反转每个单词
            reverseEachWord(s, s.length);
        }

        private void reverseEachWord(char[] s, int length) {
            int i = 0, j = 0;
            while (i < length) {
                while (i < j || i < length && s[i] == ' ') {
                    i++;
                }
                while (i > j || j < length && s[j] != ' ') {
                    j++;
                }
                reverseWholeArray(s, i, j - 1);
            }
        }

        private void reverseWholeArray(char[] chars, int i, int j) {
            while (i < j) {
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}