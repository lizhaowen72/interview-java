package leetcode.editor.cn;
//给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。 
//
// 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是） 
//
// 示例 1: 
//
// 输入: S = "rabbbit", T = "rabbit"
//输出: 3
//解释:
//
//如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
// 
//
// 示例 2: 
//
// 输入: S = "babgbag", T = "bag"
//输出: 5
//解释:
//
//如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 
//(上箭头符号 ^ 表示选取的字母)
//
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^ 
// Related Topics 字符串 动态规划

class DistinctSubsequences {
    public static void main(String[] args) {
        Solution solution = new DistinctSubsequences().new Solution();
        String S = "babag", T = "bag";
        solution.numDistinct(S, T);
    }

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {
            int[][] res = new int[s.length() + 1][t.length() + 1];
            for (int i = 0; i <= s.length(); i++) {
                res[i][0] = 1;
            }
            for (int i = 0; i < t.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    if (t.charAt(i) == s.charAt(j)) {
                        res[i + 1][j + 1] = res[i][j] + res[i + 1][j];
                    } else {
                        res[i + 1][j + 1] = res[i + 1][j];
                    }
                }
            }
            return res[t.length()][s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}