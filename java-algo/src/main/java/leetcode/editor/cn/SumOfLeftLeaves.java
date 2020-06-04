package leetcode.editor.cn;

//计算给定二叉树的所有左叶子之和。
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
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
        int res = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            helper(root, null);
            return res;
        }

        private void helper(TreeNode root, TreeNode pre) {
            if (root == null) return;
            if (root.left == null && root.right == null && pre != null && pre.left == root) {
                res += root.val;
            }
            helper(root.left, root);
            helper(root.right, root);
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