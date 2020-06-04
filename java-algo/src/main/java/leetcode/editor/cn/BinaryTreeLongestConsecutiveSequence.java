package leetcode.editor.cn;

//给你一棵指定的二叉树，请你计算它最长连续序列路径的长度。
//
// 该路径，可以是从某个初始结点到树中任意结点，通过「父 - 子」关系连接而产生的任意路径。 
//
// 这个最长连续的路径，必须从父结点到子结点，反过来是不可以的。 
//
// 示例 1： 
//
// 输入:
//
//   1
//    \
//     3
//    / \
//   2   4
//        \
//         5
//
//输出: 3
//
//解析: 当中，最长连续序列是 3-4-5，所以返回结果为 3 
//
// 示例 2： 
//
// 输入:
//
//   2
//    \
//     3
//    / 
//   2    
//  / 
// 1
//
//输出: 2 
//
//解析: 当中，最长连续序列是 2-3。注意，不是 3-2-1，所以返回 2。 
// Related Topics 树
public class BinaryTreeLongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLongestConsecutiveSequence().new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.right = node3;
        node3.left = node2;
        node3.right = node4;
        node4.right = node5;
        solution.longestConsecutive(node1);
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
        private int maxLength = 0;

        public int longestConsecutive(TreeNode root) {
            dfs(root, null, 0);
            return maxLength;
        }

        private void dfs(TreeNode p, TreeNode parent, int len) {
            if (p == null) return;
            len = (parent != null && p.val == parent.val + 1) ? len + 1 : 1;
            maxLength = Math.max(maxLength, len);
            dfs(p.left, p, len);
            dfs(p.right, p, len);
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