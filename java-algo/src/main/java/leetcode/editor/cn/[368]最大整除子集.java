package leetcode.editor.cn;
//给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。 
//
//
// 如果有多个目标子集，返回其中任何一个均可。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2] (当然, [1,3] 也正确)
// 
//
// 示例 2: 
//
// 输入: [1,2,4,8]
//输出: [1,2,4,8]
// 
// Related Topics 数学 动态规划

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LargestDivisibleSubset {
    public static void main(String[] args) {
        Solution solution = new LargestDivisibleSubset().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int n = nums.length;
            int[] count = new int[n];
            int[] pre = new int[n];
            Arrays.sort(nums);
            int max = 0, index = -1;
            for (int i = 0; i < n; i++) {
                count[i] = 1;
                pre[i] = -1;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] % nums[j] == 0) {
                        if (1 + count[j] > count[i]) {
                            count[i] = count[j] + 1;
                            pre[i] = j;
                        }
                    }
                }
                if (count[i] > max) {
                    max = count[i];
                    index = i;
                }
            }
            List<Integer> res = new ArrayList<>();
            while (index != -1) {
                res.add(nums[index]);
                index = pre[index];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}