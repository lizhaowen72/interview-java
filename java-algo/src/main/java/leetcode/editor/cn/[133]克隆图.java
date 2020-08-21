package leetcode.editor.cn;
//给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。 
//
// 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。 
//
// class Node {
//    public int val;
//    public List<Node> neighbors;
//} 
//
// 
//
// 测试用例格式： 
//
// 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1，第二个节点值为 2，以此类推。该图在测试用例中使用邻接列表表示。 
//
// 邻接列表是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。 
//
// 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
//输出：[[2,4],[1,3],[2,4],[1,3]]
//解释：
//图中有 4 个节点。
//节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
//节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
//节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
//节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
// 
//
// 示例 2： 
//
// 
//
// 输入：adjList = [[]]
//输出：[[]]
//解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
// 
//
// 示例 3： 
//
// 输入：adjList = []
//输出：[]
//解释：这个图是空的，它不含任何节点。
// 
//
// 示例 4： 
//
// 
//
// 输入：adjList = [[2],[1]]
//输出：[[2],[1]] 
//
// 
//
// 提示： 
//
// 
// 节点数介于 1 到 100 之间。 
// 每个节点值都是唯一的。 
// 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。 
// 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。 
// 图是连通图，你可以从给定节点访问到所有节点。 
// 
// Related Topics 深度优先搜索 广度优先搜索 图

import java.util.*;

class CloneGraph {
    public static void main(String[] args) {
        Solution solution = new CloneGraph().new Solution();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        List<Node> neighbors1 = new ArrayList<>();
        neighbors1.add(node2);
        neighbors1.add(node4);
        List<Node> neighbors2 = new ArrayList<>();
        neighbors2.add(node1);
        neighbors2.add(node3);
        List<Node> neighbors3 = new ArrayList<>();
        neighbors3.add(node2);
        neighbors3.add(node4);
        List<Node> neighbors4 = new ArrayList<>();
        neighbors4.add(node1);
        neighbors4.add(node3);
        node1.neighbors = neighbors1;
        node2.neighbors = neighbors2;
        node3.neighbors = neighbors3;
        node4.neighbors = neighbors4;
        Node node = solution.cloneGraph(node1);
        System.out.println(node1 == node);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
    class Solution {
        public Node cloneGraph(Node node) {
            Map<Node, Node> lookup = new HashMap<>();
            //return dfs(node, lookup);
            return cloneGraphBFS(node);
        }

        // BFS
        public Node cloneGraphBFS(Node node) {
            if (node == null) return null;
            Node root = new Node(node.val, new ArrayList());
            Queue<Node> queue = new LinkedList<>();
            Map<Node, Node> map = new HashMap<>();
            map.put(node, root);
            queue.offer(node);
            while (!queue.isEmpty()) {
                Node currNode = queue.poll();
                for (Node child : currNode.neighbors) {
                    if (!map.containsKey(child)) {
                        map.put(child, new Node(child.val, new ArrayList<>()));
                        queue.offer(child);
                    }
                    map.get(currNode).neighbors.add(map.get(child));
                }
            }
            return root;
        }

        //DFS
        public Node cloneGraphDFS(Node node) {
            Node root = new Node(node.val, new ArrayList<>());
            Stack<Node> stack = new Stack<>();
            Map<Node, Node> map = new HashMap<>();
            map.put(node, root);
            stack.add(node);
            while (!stack.isEmpty()) {
                Node currNode = stack.pop();
                for (Node child : currNode.neighbors) {
                    if (!map.containsKey(child)) {
                        map.put(child, new Node(child.val, new ArrayList<>()));
                        stack.add(child);
                    }
                    map.get(currNode).neighbors.add(map.get(child));
                }
            }
            return root;
        }

        private Node dfs(Node node, Map<Node, Node> lookup) {
            if (node == null) {
                return null;
            }
            if (lookup.containsKey(node)) {
                return lookup.get(node);
            }
            Node clone = new Node(node.val, new ArrayList<Node>());
            lookup.put(node, clone);
            for (Node neighbor : node.neighbors) {
                clone.neighbors.add(dfs(neighbor, lookup));
            }
            return clone;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}