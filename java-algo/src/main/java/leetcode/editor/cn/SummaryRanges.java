package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
//
// 示例 1: 
//
// 输入: [0,1,2,4,5,7]
//输出: ["0->2","4->5","7"]
//解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。 
//
// 示例 2: 
//
// 输入: [0,2,3,4,6,8,9]
//输出: ["0","2->4","6","8->9"]
//解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。 
// Related Topics 数组
public class SummaryRanges {
    public static void main(String[] args) {
        Solution solution = new SummaryRanges().new Solution();
        int[] nums = {0, 1, 2, 4, 5, 7};
        solution.summaryRanges(nums);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                while (i + 1 < nums.length && (nums[i + 1] - nums[i] == 1)) {
                    i++;
                }
                if (temp != nums[i]) {
                    res.add(temp + "->" + nums[i]);
                } else {
                    res.add(temp + "");
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}