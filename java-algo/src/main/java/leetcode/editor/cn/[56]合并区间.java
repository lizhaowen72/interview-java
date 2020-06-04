package leetcode.editor.cn;
//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = solution.merge(intervals);
        System.out.println(merge);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * The idea is to sort the intervals by their starting points. Then, we take the first interval and compare its
         * end with the next intervals starts. As long as they overlap, we update the end to be the max end of the
         * overlapping intervals. Once we find a non overlapping interval, we can add the previous "extended" interval and start over.
         * <p>
         * Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the resulting algorithm takes O(n log(n)).
         * <p>
         * I used a lambda comparator (Java 8) and a for-each loop to try to keep the code clean and simple.
         * <p>
         * EDIT: The function signature changed in april 2019.
         * Here is a new version of the algorithm with arrays. To make more memory efficient, I reused the initial array
         * (sort of "in-place") but it would be easy to create new subarrays if you wanted to keep the initial data.
         * It takes less memory than 99% of the other solutions (sometimes 90% depending on the run) and is more than 10 times
         * faster than the previous version with lists.
         *
         * @param intervals
         * @return
         */
        public int[][] merge(int[][] intervals) {
            if (intervals.length <= 1) {
                return intervals;
            }
            Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
            List<int[]> res = new ArrayList<>();
            int[] newInterval = intervals[0];
            res.add(newInterval);
            for (int[] interval : intervals) {
                if (interval[0] <= newInterval[1]) {// Overlapping intervals, move the end if needed
                    newInterval[1] = Math.max(newInterval[1], interval[1]);
                } else {// Disjoint intervals, add the new interval to the list
                    newInterval = interval;
                    res.add(newInterval);
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}