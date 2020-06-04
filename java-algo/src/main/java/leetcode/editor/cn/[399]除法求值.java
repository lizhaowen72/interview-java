package leetcode.editor.cn;
//给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则
//返回 -1.0。 
//
// 示例 : 
//给定 a / b = 2.0, b / c = 3.0 
//问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
//返回 [6.0, 0.5, -1.0, 1.0, -1.0 ] 
//
// 输入为: vector<pair<string, string>> equations, vector<double>& values, vector<p
//air<string, string>> queries(方程式，方程式结果，问题方程式)， 其中 equations.size() == values.siz
//e()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。 
//
// 基于上述例子，输入如下： 
//
// 
//equations(方程式) = [ ["a", "b"], ["b", "c"] ],
//values(方程式结果) = [2.0, 3.0],
//queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] 
//]. 
// 
//
// 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。 
// Related Topics 并查集 图

import java.util.*;

class EvaluateDivision {
    public static void main(String[] args) {
        Solution solution = new EvaluateDivision().new Solution();
        List<List<String>> equations = new ArrayList<>();
        List<String> equation = new ArrayList<>();
        equation.add("a");
        equation.add("b");
        List<String> equation2 = new ArrayList<>();
        equation2.add("b");
        equation2.add("c");
        equations.add(equation);
        equations.add(equation2);
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> query1 = new ArrayList<>();
        query1.add("a");
        query1.add("c");
        List<String> query2 = new ArrayList<>();
        query2.add("b");
        query2.add("a");
        List<String> query3 = new ArrayList<>();
        query3.add("a");
        query3.add("e");
        List<String> query4 = new ArrayList<>();
        query4.add("a");
        query4.add("a");
        List<String> query5 = new ArrayList<>();
        query5.add("x");
        query5.add("x");
        queries.add(query1);
        queries.add(query2);
        queries.add(query3);
        queries.add(query4);
        queries.add(query5);
        double[] res = solution.calcEquation(equations, values, queries);
        for (double v : res) {
            System.out.println(v);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, Map<String, Double>> graph = buildGraph(equations, values);
            double[] res = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                res[i]=getProductWeight(queries.get(i).get(0),queries.get(i).get(1),new HashSet<String>(),graph);
            }
            return res;
        }

        private double getProductWeight(String start, String end, HashSet<String> visited, Map<String, Map<String, Double>> graph) {
            if (!graph.containsKey(start)){
                return -1.0;
            }
            if (graph.get(start).containsKey(end)){
                return graph.get(start).get(end);
            }
            visited.add(start);
            for (Map.Entry<String, Double> entry : graph.get(start).entrySet()) {
                if (!visited.contains(entry.getKey())){
                    double productWeight = getProductWeight(entry.getKey(), end, visited, graph);
                    if (productWeight!=-1.0){
                        return productWeight*entry.getValue();
                    }
                }
            }
            return -1.0;
        }

        private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
            Map<String, Map<String, Double>> graph = new HashMap<>();
            String u, v;
            for (int i = 0; i < equations.size(); i++) {
                u = equations.get(i).get(0);
                v = equations.get(i).get(1);
                graph.putIfAbsent(u, new HashMap<>());
                graph.get(u).putIfAbsent(v, values[i]);
                graph.putIfAbsent(v, new HashMap<>());
                graph.get(v).putIfAbsent(u, 1 / values[i]);
            }
            return graph;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}