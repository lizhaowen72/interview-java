package leetcode.editor.cn;
//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
// Related Topics 字符串 动态规划 回溯算法

class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        //solution.isMatch("aa","a");
        solution.isMatch("aaa", "a*");
        solution.isMatch("ab", ".*");
        solution.isMatch("aab", "c*a*b");
        solution.isMatch("mississippi", "mis*is*p*.");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch4(String text, String pattern) {
            boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
            dp[text.length()][pattern.length()] = true;
            for (int i = text.length(); i >= 0; i--) {
                for (int j = pattern.length(); j >= 0; j--) {
                    if (i == text.length() && j == pattern.length()) continue;
                    boolean first_match = (i < text.length() && j < pattern.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                    if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                        dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                    } else {
                        dp[i][j] = first_match && dp[i + 1][j + 1];
                    }
                }
            }
            return dp[0][0];
        }

        public boolean isMatch1(String s, String p) {
            if (p.isEmpty()) {
                return s.isEmpty();
            }
            boolean first_match = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
            if (p.length() >= 2 && p.charAt(1) == '*') {
                return isMatch1(s, p.substring(2)) || first_match && isMatch1(s.substring(1), p);
            } else {
                return first_match && isMatch1(s.substring(1), p.substring(1));
            }
        }

        /**
         * This Solution use 2D DP. beat 90% solutions, very simple.
         * <p>
         * Here are some conditions to figure out, then the logic can be very straightforward.
         * <p>
         * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
         * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
         * 3, If p.charAt(j) == '*':
         * here are two sub conditions:
         * 1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
         * 2   if p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.':
         * dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
         * or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
         * or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
         *
         * @param s
         * @param p
         * @return c
         */
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return s == p;
            }
            int lenS = s.length();
            int lenP = p.length();
            boolean[][] dp = new boolean[lenS + 1][lenP + 1];
            dp[0][0] = true;
            for (int j = 0; j < lenP; j++) {
                if (p.charAt(j) == '*' && dp[0][j - 1]) {
                    dp[0][j + 1] = true;
                }
            }
            for (int i = 0; i < lenS; i++) {
                for (int j = 0; j < lenP; j++) {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                    if (p.charAt(j) == '*') {
                        if (s.charAt(i) != p.charAt(j - 1) && p.charAt(j - 1) != '.') {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        } else {
                            dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                        }
                    }
                }
            }
            return dp[lenS][lenP];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}