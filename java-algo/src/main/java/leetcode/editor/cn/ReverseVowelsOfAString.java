package leetcode.editor.cn;
//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 示例 1: 
//
// 输入: "hello"
//输出: "holle"
// 
//
// 示例 2: 
//
// 输入: "leetcode"
//输出: "leotcede" 
//
// 说明: 
//元音字母不包含字母"y"。 
// Related Topics 双指针 字符串

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            if (s == null || s.length() == 0) return s;
            String vowels = "aeiouAEIOU";
            char[] chars = s.toCharArray();
            int start = 0, end = s.length() - 1;
            while (start < end) {
                while (start < end && !vowels.contains(chars[start] + "")) {
                    start++;
                }
                while (start < end && !vowels.contains(chars[end] + "")) {
                    end--;
                }
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}