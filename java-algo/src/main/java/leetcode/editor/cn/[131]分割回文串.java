package leetcode.editor.cn;
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法

import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning{
    public static void main(String[] args) {
         Solution solution = new PalindromePartitioning().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            if (s == null || s.length() == 0) {
                return res;
            }
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                        dp[j][i] = true;
                    }
                }
            }
            helper(res, new ArrayList<String>(), dp, s, 0);
            return res;
        }

        private void helper(List<List<String>> res, ArrayList<String> tempList, boolean[][] dp, String s, int start) {
            if (start == s.length()) {
                res.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = start; i < s.length(); i++) {
                if (dp[start][i]) {
                    tempList.add(s.substring(start, i + 1));
                    helper(res, tempList, dp, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}