package leetcode.editor.cn;
//给定一个二叉树，原地将它展开为链表。 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索

class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
//        TreeNode node15 = new TreeNode(15);
//        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
//        node20.left = node15;
//        node20.right = node7;
        solution.flatten(node3);
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
        private TreeNode prev = null;

        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten(root.right);
            flatten(root.left);
            root.right = prev;
            root.left = null;
            prev = root;
        }


        public void flatten2(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten2(root.right);
            flatten2(root.left);
            root.right = prev;
            root.left = null;
            prev = root;
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