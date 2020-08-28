package leetcode.editor.cn;
//给定两个字符串 s 和 t，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例: 
//
// 输入：
//s = "abcd"
//t = "abcde"
//
//输出：
//e
//
//解释：
//'e' 是那个被添加的字母。
// 
// Related Topics 位运算 哈希表 
// 👍 151 👎 0

class FindTheDifference {
    public static void main(String[] args) {
        Solution solution = new FindTheDifference().new Solution();
        solution.findTheDifference("ab", "abc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char findTheDifference(String s, String t) {
            int len = t.length();
            char ret = t.charAt(len - 1);
            for (int i = 0; i < len - 1; i++) {
                ret ^= s.charAt(i);
                ret ^= t.charAt(i);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}