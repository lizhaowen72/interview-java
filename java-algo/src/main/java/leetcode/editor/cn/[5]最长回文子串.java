package leetcode.editor.cn;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

class LongestPalindromicSubstring{
    public static void main(String[] args) {
         Solution solution = new LongestPalindromicSubstring().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            int len = s.length();
            String res = null;
            boolean[][] dp = new boolean[len][len];
            for (int i = len - 1; i >= 0; i--) {
                for (int j = i; j < len; j++) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                    if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
            return res;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}