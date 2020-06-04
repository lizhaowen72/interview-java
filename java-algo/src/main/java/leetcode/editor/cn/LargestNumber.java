package leetcode.editor.cn;
//给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: 210 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: 9534330 
//
// 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
// Related Topics 排序

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        int[] nums = {3, 30, 34, 5, 9};
        solution.largestNumber(nums);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            if (nums == null || nums.length == 0) return "";
            String[] s_nums = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                s_nums[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(s_nums, new Comparator<String>() {
                @Override
                public int compare(String str1, String str2) {
                    String s1 = str1 + str2;
                    String s2 = str2 + str1;
                    return s2.compareTo(s1);
                }
            });
            if (s_nums[0].charAt(0) == '0') {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            for (String s : s_nums) {
                sb.append(s);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}