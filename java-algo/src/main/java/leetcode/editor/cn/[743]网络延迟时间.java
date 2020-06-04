package leetcode.editor.cn;
//有 N 个网络节点，标记为 1 到 N。 
//
// 给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从
//源节点传递到目标节点的时间。 
//
// 现在，我们向当前的节点 K 发送了一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。 
//
// 注意: 
//
// 
// N 的范围在 [1, 100] 之间。 
// K 的范围在 [1, N] 之间。 
// times 的长度在 [1, 6000] 之间。 
// 所有的边 times[i] = (u, v, w) 都有 1 <= u, v <= N 且 0 <= w <= 100。 
// 
// Related Topics 堆 深度优先搜索 广度优先搜索 图

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class NetworkDelayTime {
    public static void main(String[] args) {
        Solution solution = new NetworkDelayTime().new Solution();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int N = 4, K = 2;
        int delayTime = solution.networkDelayTime(times, N, K);
        System.out.println(delayTime);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int networkDelayTime(int[][] times, int N, int K) {
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            for (int[] time : times) {
                map.putIfAbsent(time[0], new HashMap<>());
                map.get(time[0]).put(time[1], time[2]);
            }
            Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
            pq.add(new int[]{0, K});
            int res = 0;
            boolean[] visited = new boolean[N + 1];
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int curNode = cur[1];
                int curDist = cur[0];
                if (visited[curNode]) {
                    continue;
                }
                visited[curNode] = true;
                res = curDist;
                N--;
                if (map.containsKey(curNode)) {
                    for (Integer next : map.get(curNode).keySet()) {
                        pq.add(new int[]{curDist + map.get(curNode).get(next), next});
                    }
                }
            }
            return N == 0 ? res : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}