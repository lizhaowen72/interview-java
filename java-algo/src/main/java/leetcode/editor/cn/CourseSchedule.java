package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//现在你总共有 n 门课需要选，记为 0 到 n-1。
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1] 
//
// 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？ 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。 
//
// 示例 2: 
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。 
//
// 说明: 
//
// 
// 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 
//
// 提示: 
//
// 
// 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。 
// 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。 
// 
// 拓扑排序也可以通过 BFS 完成。 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序
public class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        boolean finish = solution.canFinish(4, prerequisites);
        System.out.println(finish);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 顶点的度是指和该顶点相连的边的条数。特别是对于有向图来说，
         * 顶点的出边条数称为该顶点的出度，顶点的入边条数称为该顶点的入度
         *
         * @param numCourses
         * @param prerequisites
         * @return
         */
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] indegree = new int[numCourses];
            for (int[] cp : prerequisites) {
                indegree[cp[0]]++;
            }
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    queue.addLast(i);
                }
            }
            while (!queue.isEmpty()) {
                int pre = queue.removeFirst();
                numCourses--;
                for (int[] pq : prerequisites) {
                    if (pq[1] != pre) {
                        continue;
                    }
                    if (--indegree[pq[0]] == 0) {
                        queue.add(pq[0]);
                    }
                }
            }
            return numCourses == 0;
        }

        public boolean canFinish2(int numCourses, int[][] prerequisites) {
            int[][] matrix = new int[numCourses][numCourses];//i -> j
            int[] indegree = new int[numCourses];
            for (int i = 0; i < prerequisites.length; i++) {
                int ready = prerequisites[i][0];
                int pre = prerequisites[i][1];
                if (matrix[pre][ready] == 0) {
                    indegree[ready]++;// duplicate case
                }
                matrix[pre][ready] = 1;
            }
            int count = 0;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int course = queue.poll();
                count++;
                for (int i = 0; i < numCourses; i++) {
                    if (matrix[course][i] != 0) {
                        if (--indegree[i] == 0) {
                            queue.offer(i);
                        }
                    }
                }
            }
            return count == numCourses;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}