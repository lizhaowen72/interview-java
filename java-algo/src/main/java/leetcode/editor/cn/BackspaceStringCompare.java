package leetcode.editor.cn;
//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
// 
//
// 示例 2： 
//
// 输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
// 
//
// 示例 3： 
//
// 输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
// 
//
// 示例 4： 
//
// 输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S 和 T 只含有小写字母以及字符 '#'。 
// 
//
// 
// Related Topics 栈 双指针

public class BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompare().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean backspaceCompare2(String S, String T) {
            for (int i = S.length() - 1, j = T.length() - 1; ; i--, j--) {
                for (int b = 0; i >= 0 && (b > 0 || S.charAt(i) == '#'); --i) {
                    b += S.charAt(i) == '#' ? 1 : -1;
                }
                for (int b = 0; j >= 0 && (b > 0 || T.charAt(j) == '#'); j--) {
                    b += T.charAt(j) == '#' ? 1 : -1;
                }
                if (i < 0 || j < 0 || S.charAt(i) != T.charAt(j)) {
                    return i == -1 && j == -1;
                }
            }
        }

        public boolean backspaceCompare(String S, String T) {
            int i = S.length() - 1, j = T.length() - 1;
            while (true) {
                for (int back = 0; i >= 0 && (back > 0 || S.charAt(i) == '#'); --i) {
                    back += S.charAt(i) == '#' ? 1 : -1;
                }
                for (int back = 0; j >= 0 && (back > 0 || T.charAt(j) == '#'); --j) {
                    back += T.charAt(j) == '#' ? 1 : -1;
                }
                if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                    i--;
                    j--;
                } else {
                    return i == -1 && j == -1;
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}