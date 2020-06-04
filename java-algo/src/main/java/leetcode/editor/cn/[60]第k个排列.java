package leetcode.editor.cn;
//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法

import java.util.ArrayList;
import java.util.List;

class PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new PermutationSequence().new Solution();
        String permutation = solution.getPermutation(4, 9);
        System.out.println(permutation);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getPermutation(int n, int k) {
            StringBuilder sb = new StringBuilder();
            List<Integer> nums = new ArrayList<>();
            int fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
                nums.add(i);
            }
            for (int i = 0, l = k - 1; i < n; i++) {
                fact /= n - i;
                int index = l / fact;
                sb.append(nums.remove(index));
                l -= index * fact;
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}