package leetcode.editor.cn;
//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索

import java.util.Stack;

class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
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
        public int maxDepth1(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> value = new Stack<>();
            stack.add(root);
            value.add(1);
            int max = 0;
            while (!stack.isEmpty()) {
                TreeNode treeNode = stack.pop();
                Integer temp = value.pop();
                max = Math.max(max, temp);
                if (treeNode.left != null) {
                    stack.add(treeNode.left);
                    value.add(temp + 1);
                }
                if (treeNode.right != null) {
                    stack.add(treeNode.right);
                    value.add(temp + 1);
                }
            }
            return max;
        }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.right) + 1, maxDepth(root.left) + 1);
        }

        /**
         * 递归解法
         *
         * @param root
         * @return
         */
        public int maxDepth3(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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