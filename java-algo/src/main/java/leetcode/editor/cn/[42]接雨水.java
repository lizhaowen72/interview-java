package leetcode.editor.cn;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针

class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        solution.trap(height);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int a = 0;
            int b = height.length - 1;
            int max = 0;
            int leftMax = 0;
            int rightMax = 0;
            while (a <= b) {
                leftMax = Math.max(leftMax, height[a]);
                rightMax = Math.max(rightMax, height[b]);
                if (leftMax < rightMax) {
                    max += (leftMax - height[a]);
                    a++;
                } else {
                    max += (rightMax - height[b]);
                    b--;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}