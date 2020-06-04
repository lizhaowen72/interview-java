package leetcode.editor.cn;
//给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从J
//FK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。 
//
// 说明: 
//
// 
// 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排
//序更靠前 
// 所有的机场都用三个大写字母表示（机场代码）。 
// 假定所有机票至少存在一种合理的行程。 
// 
//
// 示例 1: 
//
// 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
// 
//
// 示例 2: 
//
// 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。 
// Related Topics 深度优先搜索 图

import java.util.*;

class ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new ReconstructItinerary().new Solution();
        List<List<String>> tickets = new ArrayList<>();
        List<String> ticket1 = new ArrayList<>();
        List<String> ticket2 = new ArrayList<>();
        List<String> ticket3 = new ArrayList<>();
        List<String> ticket4 = new ArrayList<>();
        ticket1.add("MUC");
        ticket1.add("LHR");
        ticket2.add("JFK");
        ticket2.add("MUC");
        ticket3.add("SFO");
        ticket3.add("SJC");
        ticket4.add("LHR");
        ticket4.add("SFO");
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        solution.findItinerary(tickets);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        List<String> routes = new ArrayList<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                PriorityQueue<String> queue = targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<String>());
                queue.add(ticket.get(1));
            }
            visit("JFK");
            return routes;
        }

        private void visit(String airport) {
            while (targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
                visit(targets.get(airport).poll());
            }
            routes.add(0, airport);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}