package leetcode.editor.cn;
//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节
//点值之和。 
//
// 例如： 
//
// 
//输入: 二叉搜索树:
//              5
//            /   \
//           2     13
//
//输出: 转换为累加树:
//             18
//            /   \
//          20     13
// 
// Related Topics 树

public class ConvertBstToGreaterTree {
    public static void main(String[] args) {
        Solution solution = new ConvertBstToGreaterTree().new Solution();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(13);
        node1.left = node2;
        node1.right = node3;
        solution.convertBST(node1);
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
        /**
         * Since this is a BST, we can do a reverse inorder traversal to traverse the nodes of the tree in descending order.
         * In the process, we keep track of the running sum of all nodes which we have traversed thus far.
         */
        int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            convert(root);
            return root;
        }

        private void convert(TreeNode root) {
            if (root == null) return;
            convert(root.right);
            root.val += sum;
            sum = root.val;
            convert(root.left);
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