package leetcode.editor.en;
//There are a total of numCourses courses you have to take, labeled from 0 to nu
//mCourses-1. 
//
// Some courses may have prerequisites, for example to take course 0 you have to
// first take course 1, which is expressed as a pair: [0,1] 
//
// Given the total number of courses and a list of prerequisite pairs, is it pos
//sible for you to finish all courses? 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//             To take course 1 you should have finished course 0. So it is poss
//ible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//             To take course 1 you should have finished course 0, and to take c
//ourse 0 you should
//             also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// The input prerequisites is a graph represented by a list of edges, not adjace
//ncy matrices. Read more about how a graph is represented. 
// You may assume that there are no duplicate edges in the input prerequisites. 
//
// 1 <= numCourses <= 10^5 
// 
// Related Topics Depth-first Search Breadth-first Search Graph Topological Sort
// 
// 👍 4162 👎 183

import java.util.LinkedList;

class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        solution.canFinish(numCourses,prerequisites);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}