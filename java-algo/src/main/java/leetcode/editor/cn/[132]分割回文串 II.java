package leetcode.editor.cn;
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回符合要求的最少分割次数。 
//
// 示例: 
//
// 输入: "aab"
//输出: 1
//解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
// Related Topics 动态规划

import java.util.stream.IntStream;

class PalindromePartitioningIi{
    public static void main(String[] args) {
         Solution solution = new PalindromePartitioningIi().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int n = s.length();
        int[] dp = IntStream.range(0, n).toArray();
        for (int mid = 1; mid < n; mid++) {
            for (int start = mid, end = mid; start >= 0 && end < n && s.charAt(start) == s.charAt(end); start--, end++) {
                int newCutAtEnd = start == 0 ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }
            for (int start = mid - 1, end = mid; start >= 0 && end < n && s.charAt(start) == s.charAt(end); start--, end++) {
                int newCutAtEnd = start == 0 ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }
        }
        return dp[n - 1];
    }

    /**
     * This can be solved by two points:
     * <p>
     * cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
     * If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].
     * The 2nd point reminds us of using dp (caching).
     * <p>
     * a   b   a   |   c  c
     * j  i
     * j-1  |  [j, i] is palindrome
     * cut(j-1) +  1
     *
     * @param s
     * @return
     */
    public int minCut1(String s) {
        char[] c = s.toCharArray();
        int n = s.length();
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}