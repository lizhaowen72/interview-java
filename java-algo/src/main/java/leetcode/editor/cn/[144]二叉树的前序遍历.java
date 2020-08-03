package leetcode.editor.cn;
//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preorderTraversalHelper(root, res);
            return res;
        }

        private void preorderTraversalHelper(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            preorderTraversalHelper(root.left, res);
            preorderTraversalHelper(root.right, res);
        }


        public List<Integer> preorderTraversal3(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> res = new ArrayList<>();
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    res.add(root.val);
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
            }
            return res;
        }


        public List<Integer> preorderTraversal1(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> list = new ArrayList<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    list.add(root.val);
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
            }
            return list;
        }

        public List<Integer> preorderTraversal2(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            recursive(root, res);
            return res;
        }

        /**
         * 递归解法
         *
         * @param root
         * @param res
         */
        private void recursive(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            recursive(root.left, res);
            recursive(root.right, res);
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