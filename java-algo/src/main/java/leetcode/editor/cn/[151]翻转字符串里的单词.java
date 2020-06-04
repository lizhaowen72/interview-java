package leetcode.editor.cn;
//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 进阶： 
//
// 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 字符串

class ReverseWordsInAString{
    public static void main(String[] args) {
         Solution solution = new ReverseWordsInAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;
        int len = s.length();
        char[] chars = s.toCharArray();
        // reverse the whole world
        reverseWholeWorld(chars, 0, len - 1);

        // reverse s'each world
        reverEachWorld(chars, len);

        // clean over space
        return cleanOverSpace(chars, len);
    }

        private String cleanOverSpace(char[] chars, int len) {
            int i = 0, j = 0;
            while (j < len) {
                while (j < len && chars[j] == ' ') {
                    j++;
                }
                while (j < len && chars[j] != ' ') {
                    chars[i++] = chars[j++];
                }
                while (j < len && chars[j] == ' ') {
                    j++;
                }
                if (j < len) {
                    chars[i++] = ' ';
                }
            }
            return new String(chars).substring(0, i);
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