package leetcode.editor.cn;
//给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。 
//
// 示例 1: 
//输入: 
//
// 
//"bbbab"
// 
//
// 输出: 
//
// 
//4
// 
//
// 一个可能的最长回文子序列为 "bbbb"。 
//
// 示例 2: 
//输入: 
//
// 
//"cbbd"
// 
//
// 输出: 
//
// 
//2
// 
//
// 一个可能的最长回文子序列为 "bb"。 
// Related Topics 动态规划

class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence().new Solution();
        solution.longestPalindromeSubseq("cbbd");
        String fileInfos = "123";
        String[] split = fileInfos.split(",");
        System.out.println(split);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * dp[i][j]: the longest palindromic subsequence's length of substring(i, j), here i, j represent left, right indexes in the string
         * State transition:
         * dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
         * otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
         * Initialization: dp[i][i] = 1
         *
         * @param s
         * @return
         */
        public int longestPalindromeSubseq1(String s) {
            int[][] dp = new int[s.length()][s.length()];
            for (int i = s.length() - 1; i >= 0; i--) {
                dp[i][i] = 1;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[0][s.length() - 1];
        }

        public int longestPalindromeSubseq(String s) {
            return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
        }

        private int helper(String s, int i, int j, Integer[][] memo) {
            if (memo[i][j] != null) {
                return memo[i][j];
            }
            if (i > j) return 0;
            if (i == j) return 1;
            if (s.charAt(i) == s.charAt(j)) {
                memo[i][j] = helper(s, i + 1, j - 1, memo) + 2;
            } else {
                memo[i][j] = Math.max(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
            }
            return memo[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}