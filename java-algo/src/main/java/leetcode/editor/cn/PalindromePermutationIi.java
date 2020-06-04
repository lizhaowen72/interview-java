package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//给定一个字符串 s ，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。
//
// 如不能形成任何回文排列时，则返回一个空列表。 
//
// 示例 1： 
//
// 输入: "aabb"
//输出: ["abba", "baab"] 
//
// 示例 2： 
//
// 输入: "abc"
//输出: [] 
// Related Topics 回溯算法
public class PalindromePermutationIi {
    public static void main(String[] args) {
        Solution solution = new PalindromePermutationIi().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> set = new HashSet<>();

        public List<String> generatePalindromes(String s) {
            int[] map = new int[128];
            char[] st = new char[s.length() / 2];
            if (!canPermutePalindrome(s, map)) {
                return new ArrayList<>();
            }
            char ch = 0;
            int k = 0;
            for (int i = 0; i < map.length; i++) {
                if (map[i] % 2 == 1) {
                    ch = (char) i;
                }
                for (int j = 0; j < map[i] / 2; j++) {
                    st[k++] = (char) i;
                }
            }
            permute(st, 0, ch);
            return new ArrayList<String>(set);
        }

        private void permute(char[] st, int l, char ch) {
            if (l == st.length) {
                set.add(new String(st) + (ch == 0 ? "" : ch) + new StringBuffer(new String(st)).reverse());
            } else {
                for (int i = l; i < st.length; i++) {
                    if (st[l] != st[i] || l == i) {
                        swap(st, l, i);
                        permute(st, l + 1, ch);
                        swap(st, l, i);
                    }
                }
            }
        }

        private void swap(char[] st, int i, int j) {
            char temp = st[i];
            st[i] = st[j];
            st[j] = temp;
        }

        private boolean canPermutePalindrome(String s, int[] map) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i)]++;
                if (map[s.charAt(i)] % 2 == 0) {
                    count--;
                } else {
                    count++;
                }
            }
            return count <= 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}