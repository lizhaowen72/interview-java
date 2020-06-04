package leetcode.editor.cn;
//给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。 
//
// 示例： 
//
// 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
//输出: ["2", "4->49", "51->74", "76->99"]
// 
// Related Topics 数组

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
        Solution solution = new MissingRanges().new Solution();
        solution.findMissingRanges(new int[]{1, 3, 50, 75}, 0, 76);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            List<String> res = new ArrayList<>();
            long pre = (long) lower - 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] - pre == 2) {
                    res.add(String.valueOf(pre + 1));
                } else if (nums[i] - pre > 2) {
                    res.add((pre + 1) + "->" + (nums[i] - 1));
                }
                pre = nums[i];
            }
            if (upper - pre == 1) {
                res.add(String.valueOf(upper));
            } else if (upper - pre > 1) {
                res.add((pre + 1) + "->" + upper);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}