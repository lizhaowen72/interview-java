package leetcode.editor.cn;
//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索

class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        solution.isBalanced(node3);
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
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            int leftDepth = depthHelper(root.left);
            int rightDepth = depthHelper(root.right);
            return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced2(root.left) && isBalanced2(root.right);
        }

        private int depthHelper(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(depthHelper(root.left), depthHelper(root.right)) + 1;
        }

        /**
         * 解法1:自顶向下
         *
         * @param root
         * @return
         */
        public boolean isBalanced2(TreeNode root) {
            if (root == null) {
                return true;
            }
            int left = depth(root.left);
            int right = depth(root.right);
            return Math.abs(left - right) <= 1 && isBalanced2(root.left) && isBalanced2(root.right);
        }

        public int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }

        public boolean isBalanced3(TreeNode root) {
            return dfsHeight(root) != -1;
        }

        public int dfsHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = dfsHeight(root.left);
            if (leftHeight == -1) {
                return -1;
            }
            int rightLeft = dfsHeight(root.right);
            if (rightLeft == -1) {
                return -1;
            }
            if (Math.abs(leftHeight - rightLeft) > 1) {
                return -1;
            }
            return Math.max(leftHeight, rightLeft) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
}