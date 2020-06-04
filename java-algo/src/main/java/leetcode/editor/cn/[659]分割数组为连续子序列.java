package leetcode.editor.cn;
//输入一个按升序排序的整数数组（可能包含重复数字），你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。返回你是否能做出这样的分割？ 
//
// 
//
// 示例 1： 
//
// 
//输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 
//
// 示例 2： 
//
// 
//输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 
//
// 示例 3： 
//
// 
//输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的数组长度范围为 [1, 10000] 
// 
//
// 
// Related Topics 堆 贪心算法

import java.util.HashMap;

class SplitArrayIntoConsecutiveSubsequences {
    public static void main(String[] args) {
        Solution solution = new SplitArrayIntoConsecutiveSubsequences().new Solution();
        int[] nums ={1,2,3,3,4,5};
        solution.isPossible(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossible(int[] nums) {
            Counter count = new Counter();
            Counter tails = new Counter();
            for (int x : nums) {
                count.add(x, 1);
            }
            for (int x : nums) {
                if (count.get(x) == 0) {
                    continue;
                } else if (tails.get(x) > 0) {
                    tails.add(x, -1);
                    tails.add(x + 1, 1);
                } else if (count.get(x + 1) > 0 && count.get(x + 2) > 0) {
                    count.add(x + 1, -1);
                    count.add(x + 2, -1);
                    tails.add(x + 3, 1);
                } else {
                    return false;
                }
                count.add(x, -1);
            }
            return true;
        }

        class Counter extends HashMap<Integer, Integer> {
            public int get(int k) {
                return containsKey(k) ? super.get(k) : 0;
            }

            public void add(int k, int v) {
                put(k, get(k) + v);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}