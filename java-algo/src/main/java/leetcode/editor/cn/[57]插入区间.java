package leetcode.editor.cn;
//给出一个无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出: [[1,5],[6,9]]
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出: [[1,2],[3,10],[12,16]]
//解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
// Related Topics 排序 数组

import java.util.ArrayList;
import java.util.List;

class InsertInterval {
    public static void main(String[] args) {
        Solution solution = new InsertInterval().new Solution();
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 17}};
        int[] newInterval = {4, 8};
        int[][] insert = solution.insert(intervals, newInterval);
        System.out.println(insert);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int i = 0;
            int len = intervals.length;
            List<int[]> res = new ArrayList<>();
            while (i < len && intervals[i][1] < newInterval[0]) {
                res.add(intervals[i++]);
            }
            while (i < len && intervals[i][0] <= newInterval[1]) {
                newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
                i++;
            }
            res.add(newInterval);
            while (i < len) {
                res.add(intervals[i++]);
            }
            return res.toArray(new int[res.size()][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}