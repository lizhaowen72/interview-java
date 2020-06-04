package leetcode.editor.cn;
//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。 
//
// 示例 1: 
//
// 输入: "aacecaaa"
//输出: "aaacecaaa"
// 
//
// 示例 2: 
//
// 输入: "abcd"
//输出: "dcbabcd" 
// Related Topics 字符串

class ShortestPalindrome {
    public static void main(String[] args) {
        Solution solution = new ShortestPalindrome().new Solution();
        solution.shortestPalindrome("abc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shortestPalindrome(String s) {
            String ss = s + '#' + new StringBuilder(s).reverse();
            int max = magetLastNext(ss);
            return new StringBuilder(s.substring(max)).reverse() + s;
        }

        // 返回next 数组的最后一个值
        private int magetLastNext(String s) {
            int n = s.length();
            char[] c = s.toCharArray();
            int[] next = new int[n + 1];
            next[0] = -1;
            next[1] = 0;
            int k = 0;
            int i = 2;
            while (i <= n) {
                if (k == -1 || c[i - 1] == c[k]) {
                    next[i] = k + 1;
                    k++;
                    i++;
                } else {
                    k = next[k];
                }
            }
            return next[n];
        }

        public String shortestPalindrome2(String s) {
            String r = new StringBuilder(s).reverse().toString();
            int n = s.length();
            int i = 0;
            for (; i < n; i++) {
                if (s.substring(0, n - i).equals(r.substring(i))) {
                    break;
                }
            }
            return new StringBuilder(s.substring(n - i)).reverse() + s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}