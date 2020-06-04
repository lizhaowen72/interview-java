package leetcode.editor.cn;
//给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。 
//
// 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。 
//
// 示例 1: 
//
// 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
// Related Topics 堆


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        Solution solution = new FindKPairsWithSmallestSums().new Solution();
        int[] nums1 = {1, 7, 11}, nums2 = {2, 4, 6};
        int k = 3;
        solution.kSmallestPairs(nums1, nums2, k);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
            List<List<Integer>> res = new ArrayList<>();
            if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
            for (int i = 0; i < nums1.length && i < k; i++) {
                queue.offer(new int[]{nums1[i], nums2[0], 0});
            }
            while (k-- > 0 && !queue.isEmpty()) {
                int[] curr = queue.poll();
                res.add(new ArrayList<>(Arrays.asList(curr[0],curr[1])));
                if (curr[2] == nums2.length - 1) {
                    continue;
                }
                queue.offer(new int[]{curr[0], nums2[curr[2] + 1], curr[2] + 1});
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}