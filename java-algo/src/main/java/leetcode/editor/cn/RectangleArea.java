package leetcode.editor.cn;

//在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
//
// 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。 
//
// 
//
// 示例: 
//
// 输入: -3, 0, 3, 4, 0, -1, 9, 2
//输出: 45 
//
// 说明: 假设矩形面积不会超出 int 的范围。 
// Related Topics 数学
public class RectangleArea {
    public static void main(String[] args) {
        Solution solution = new RectangleArea().new Solution();

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int x = Math.min(G, C) > Math.max(A, E) ? Math.min(G, C) - Math.max(A, E) : 0;
            int y = Math.min(H, D) > Math.max(B, F) ? Math.min(H, D) - Math.max(B, F) : 0;
            return (D - B) * (C - A) + (G - E) * (H - F) - x * y;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}