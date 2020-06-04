package leetcode.editor.cn;

import java.util.*;

//给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
//
// 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: [3] 
//
// 示例 2: 
//
// 输入: [1,1,1,3,3,2,2,2]
//输出: [1,2] 
// Related Topics 数组
public class MajorityElementIi {
    public static void main(String[] args) {
        Solution solution = new MajorityElementIi().new Solution();
        int[] nums = {1,1,1,3,3,2,2,2};
        solution.majorityElement(nums);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int k = 3;
            Map<Integer, Integer> candidates = new HashMap<>();
            for (int a : nums) {
                candidates.put(a, candidates.getOrDefault(a, 0) + 1);
                if (candidates.size() == k) {
                    Iterator<Map.Entry<Integer, Integer>> it = candidates.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<Integer, Integer> item = it.next();
                        if (item.getValue() == 1) {
                            it.remove();
                        } else {
                            item.setValue(item.getValue() - 1);
                        }
                    }
                }
            }
            // check correctness of candidates
            List<Integer> ans = new ArrayList<>();
            Iterator<Map.Entry<Integer, Integer>> it = candidates.entrySet().iterator();
            while (it.hasNext()) {
                Integer key = it.next().getKey();
                int count = 0;
                for (int num : nums) {
                    if (num == key) {
                        count++;
                    }
                    if (count > nums.length / k) {
                        ans.add(key);
                        break;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}