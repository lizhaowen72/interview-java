package leetcode.editor.cn;
//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索


import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node4 = new TreeNode(4);
        node6.left = node2;
        node6.right = node8;
        node2.right = node4;
        solution.binaryTreePaths(node6);
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();
            if (root != null) {
                searchBTP(root, "", ans);
            }
            return ans;
        }

        private void searchBTP(TreeNode root, String path, List<String> ans) {
            if (root.left == null && root.right == null) {
                ans.add(path + root.val);
            }
            if (root.left != null) {
                searchBTP(root.left, path + root.val + "->", ans);
            }
            if (root.right != null) {
                searchBTP(root.right, path + root.val + "->", ans);
            }
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