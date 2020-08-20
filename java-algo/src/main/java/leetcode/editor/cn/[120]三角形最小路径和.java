package leetcode.editor.cn;
//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划

import java.util.ArrayList;
import java.util.List;

class Triangle {
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> integers0 = new ArrayList<>();
        integers0.add(2);
        triangle.add(integers0);
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(3);
        integers1.add(4);
        triangle.add(integers1);
        List<Integer> integers2 = new ArrayList<>();
        integers2.add(6);
        integers2.add(5);
        integers2.add(7);
        triangle.add(integers2);
        List<Integer> integers3 = new ArrayList<>();
        integers3.add(4);
        integers3.add(1);
        integers3.add(8);
        integers3.add(3);
        triangle.add(integers3);
        solution.minimumTotal(triangle);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
           int[] res = new int[triangle.size()+1];
            for (int i = triangle.size()-1; i >=0 ; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    res[j]= Math.min(res[j],res[j+1])+triangle.get(i).get(j);
                }
            }
            return res[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}