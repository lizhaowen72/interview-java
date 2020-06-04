package leetcode.editor.cn;
//给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以
//结果应当返回修剪好的二叉搜索树的新的根节点。 
//
// 示例 1: 
//
// 
//输入: 
//    1
//   / \
//  0   2
//
//  L = 1
//  R = 2
//
//输出: 
//    1
//      \
//       2
// 
//
// 示例 2: 
//
// 
//输入: 
//    3
//   / \
//  0   4
//   \
//    2
//   /
//  1
//
//  L = 1
//  R = 3
//
//输出: 
//      3
//     / 
//   2   
//  /
// 1
// 
// Related Topics 树


public class TrimABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new TrimABinarySearchTree().new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        solution.trimBST(node1, 1, 2);
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
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if (root == null) return null;
            if (root.val < L) {
                return trimBST(root.right, L, R);
            }
            if (root.val > R) {
                return trimBST(root.left, L, R);
            }
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
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