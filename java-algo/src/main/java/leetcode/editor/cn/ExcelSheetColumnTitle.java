package leetcode.editor.cn;
//给定一个正整数，返回它在 Excel 表中相对应的列名称。
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学


public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnTitle().new Solution();
        String s = solution.convertToTitle(701);
        System.out.println(s);
        System.out.println((char)('A'+25));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int n) {
            return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + n % 26);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}