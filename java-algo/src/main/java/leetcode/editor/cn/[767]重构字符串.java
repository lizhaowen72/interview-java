package leetcode.editor.cn;
//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串

import java.util.Arrays;

class ReorganizeString {
    public static void main(String[] args) {
        Solution solution = new ReorganizeString().new Solution();
        solution.reorganizeString("aabba");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reorganizeString(String S) {
            int N = S.length();
            int[] counts = new int[26];
            for (char c : S.toCharArray()) {
                counts[c - 'a'] += 100;
            }
            for (int i = 0; i < 26; i++) {
                counts[i] += i;
            }
            Arrays.sort(counts);
            char[] res = new char[N];
            int t = 1;
            for (int i = 0; i < 26; i++) {
                int count = counts[i] / 100;
                if (count == 0) continue;
                char ch = (char) ('a' + counts[i] % 100);
                if (count > (N + 1) / 2) return "";
                for (int j = 0; j < count; j++) {
                    if (t >= N) t = 0;
                    res[t] = ch;
                    t += 2;
                }
            }
            return String.valueOf(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}