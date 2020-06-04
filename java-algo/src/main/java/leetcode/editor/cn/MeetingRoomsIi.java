package leetcode.editor.cn;
//给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑
//充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。 
//
// 示例 1: 
//
// 输入: [[0, 30],[5, 10],[15, 20]]
//输出: 2 
//
// 示例 2: 
//
// 输入: [[7,10],[2,4]]
//输出: 1 
// Related Topics 堆 贪心算法 排序


import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsIi {
    public static void main(String[] args) {
        Solution solution = new MeetingRoomsIi().new Solution();
        int[][] intervals = {{7, 10}, {2, 4}};
        solution.minMeetingRooms(intervals);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 分别将开始时间和结束时间存进两个数组。
         * 分别对开始时间和结束时间进行排序。请注意，这将打乱开始时间和结束时间的原始对应关系。它们将被分别处理。
         * 考虑两个指针： s_ptr 和 e_ptr，分别代表开始指针和结束指针。开始指针遍历每个会议，结束指针帮助我们跟踪会议是否结束。
         * 当考虑 s_ptr 指向的特定会议时，检查该开始时间是否大于 e_ptr 指向的会议。若如此，则说明 s_ptr 开始时，已经有会议结束。于是我们可以重用房间。否则，我们就需要开新房间。
         * 若有会议结束，换而言之， start[s_ptr] >= end[e_ptr]，则自增 e_ptr。
         * 重复这一过程，直到 s_ptr 处理完所有会议。
         * @param intervals
         * @return
         */
        public int minMeetingRooms(int[][] intervals) {
            if (intervals.length == 0) return 0;
            Integer[] start = new Integer[intervals.length];
            Integer[] end = new Integer[intervals.length];
            for (int i = 0; i < intervals.length; i++) {
                start[i] = intervals[i][0];
                end[i] = intervals[i][1];
            }
            Arrays.sort(start, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            Arrays.sort(end, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            int startPoint = 0, endPoint = 0, usedRoom = 0;
            while (startPoint < intervals.length) {
                if (start[startPoint] >= end[endPoint]) {
                    usedRoom--;
                    endPoint++;
                }
                usedRoom++;
                startPoint++;

            }
            return usedRoom;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}