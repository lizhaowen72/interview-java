package leetcode.editor.cn;
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 说明: 
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。 
// Related Topics 树 深度优先搜索 广度优先搜索

class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            return root == null || isSymmetricRecursive(root.left, root.right);
        }

        /**
         * 递归解法
         *
         * @param left
         * @param right
         * @return
         */
        private boolean isSymmetricRecursive(TreeNode left, TreeNode right) {
            if (left == null || right == null) {
                return left == right;
            }
            if (left.val != right.val) {
                return false;
            }
            return isSymmetricRecursive(left.left, right.right) && isSymmetricRecursive(left.right, right.left);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}