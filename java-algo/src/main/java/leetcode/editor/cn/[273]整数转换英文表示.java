package leetcode.editor.cn;
//将非负整数转换为其对应的英文表示。可以保证给定输入小于 231 - 1 。 
//
// 示例 1: 
//
// 输入: 123
//输出: "One Hundred Twenty Three"
// 
//
// 示例 2: 
//
// 输入: 12345
//输出: "Twelve Thousand Three Hundred Forty Five" 
//
// 示例 3: 
//
// 输入: 1234567
//输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven" 
//
// 示例 4: 
//
// 输入: 1234567891
//输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thou
//sand Eight Hundred Ninety One" 
// Related Topics 数学 字符串 
// 👍 94 👎 0

class IntegerToEnglishWords{
    public static void main(String[] args) {
         Solution solution = new IntegerToEnglishWords().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0)
                words = helper(num % 1000) +THOUSANDS[i] + " " + words;
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}