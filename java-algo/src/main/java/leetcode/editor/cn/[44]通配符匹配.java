package leetcode.editor.cn;
//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
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
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输入: false 
// Related Topics 贪心算法 字符串 动态规划 回溯算法

//基本思想是为字符串提供一个指针，为模式提供一个指针。该算法最多迭代length（string）+ length（pattern）次，对于每次迭代，至少一个指针前进一级。


class WildcardMatching {
    public static void main(String[] args) {
        Solution solution = new WildcardMatching().new Solution();
        //solution.isMatch("aa","a");
        //solution.isMatch("aa","*");
        //solution.isMatch("cb","?b");
        //solution.isMatch("cb","?a");
        solution.isMatch("ab", "**");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            int i = 0, j = 0, iStar = -1, jStar = -1, m = s.length(), n = p.length();
            while (i < m) {
                if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                    i++;
                    j++;
                } else if (j < n && p.charAt(j) == '*') {
                    iStar = i;
                    jStar = j++;
                } else if (iStar >= 0) {
                    i = iStar++;
                    j = jStar + 1;
                } else {
                    return false;
                }
            }
            while (j < n && p.charAt(j) == '*') {
                j++;
            }
            return j == n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}