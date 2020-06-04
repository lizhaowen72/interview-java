package leetcode.editor.cn;
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组

import java.util.ArrayList;
import java.util.List;

class PascalsTriangle{
    public static void main(String[] args) {
         Solution solution = new PascalsTriangle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> allRows = new ArrayList<>();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                row.add(0, 1);
                for (int j = 1; j < row.size() - 1; j++) {
                    row.set(j, row.get(j) + row.get(j + 1));
                }
                allRows.add(new ArrayList<Integer>(row));
            }
            return allRows;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}