package leetcode.editor.cn;
//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索

class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        TreeNode node3 = new TreeNode(-10);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        solution.maxPathSum(node3);
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
        int maxValue = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxPathDown(root);
            return maxValue;
        }

        public int maxPathDown(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(0, maxPathDown(root.left));
            int right = Math.max(0, maxPathDown(root.right));
            maxValue = Math.max(maxValue, left + right + root.val);
            // Math.max(left, right) + root.val:选取大的一个路径 -10-->20-->15，而非-10-->20-->7
            return Math.max(left, right) + root.val;
        }


        public int maxPathSum2(TreeNode root) {
            maxPathDown2(root);
            return maxValue;
        }

        private int maxPathDown2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(0, maxPathDown2(root.left));
            int right = Math.max(0, maxPathDown2(root.right));
            maxValue = Math.max(maxValue, left + right + root.val);
            return Math.max(left, right) + root.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }
}