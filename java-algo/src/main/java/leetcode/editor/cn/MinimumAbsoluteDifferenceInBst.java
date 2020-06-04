package leetcode.editor.cn;
//给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。 
//
// 示例 : 
//
// 
//输入:
//
//   1
//    \
//     3
//    /
//   2
//
//输出:
//1
//
//解释:
//最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 注意: 树中至少有2个节点。 
// Related Topics 树


public class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(0);
        node1.right = node2;
        node2.left = node3;
        node1.left = node4;
        solution.getMinimumDifference(node1);
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        Integer min = Integer.MAX_VALUE;
        Integer prev = null;

        public int getMinimumDifference(TreeNode root) {
            if (root == null) return min;
            getMinimumDifference(root.left);
            if (prev != null) {
                min = Math.min(min, root.val - prev);
            }
            prev = root.val;
            getMinimumDifference(root.right);
            return min;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}