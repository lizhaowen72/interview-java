package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//给定两个数组，编写一个函数来计算它们的交集。
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [9,4] 
//
// 说明: 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        solution.intersection(nums1, nums2);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Use two hash sets
         * Time complexity: O(n)
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersection3(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            Set<Integer> intersect = new HashSet<>();
            for (int i = 0; i < nums1.length; i++) {
                set.add(nums1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                if (set.contains(nums2[i])) {
                    intersect.add(nums2[i]);
                }
            }
            int[] result = new int[intersect.size()];
            int i = 0;
            for (Integer num : intersect) {
                result[i++] = num;
            }
            return result;
        }

        /**
         * Sort both arrays, use two pointers
         * Time complexity: O(nlogn)
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    set.add(nums1[i]);
                    i++;
                    j++;
                }
            }
            int[] result = new int[set.size()];
            int k = 0;
            for (Integer num : set) {
                result[k++] = num;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}