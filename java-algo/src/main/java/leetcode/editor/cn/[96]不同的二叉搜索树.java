package leetcode.editor.cn;
//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划

class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        System.out.println(solution.numTrees(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees2(int n) {
            return genTreeNums(1, n);
        }

        private int genTreeNums(int start, int end) {
            int res = 0;
            if (start >= end) {
                return 1;
            }
            for (int i = start; i <= end; i++) {
                int leftTreeNums = genTreeNums(start, i - 1);
                int rightTreeNums = genTreeNums(i + 1, end);
                res += leftTreeNums * rightTreeNums;
            }
            return res;
        }

        public int numTrees(int n) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    res[i] += res[i - j] * res[j - 1];
                }
            }
            return res[n];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}