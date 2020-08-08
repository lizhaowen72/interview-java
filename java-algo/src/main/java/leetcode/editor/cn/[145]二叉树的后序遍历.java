package leetcode.editor.cn;
//给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

import java.util.*;

class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        node1.right = node3;
        node1.left = node2;
        solution.postorderTraversal(node1);
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
        public List<Integer> postorderTraversal0(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root, res);
            return res;
        }

        private void helper(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            helper(root.left, res);
            helper(root.right, res);
            res.add(root.val);
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> res = new ArrayList<>();
            TreeNode currNode = root;
            while (!stack.isEmpty() || currNode != null) {
                while (currNode != null) {
                    res.add(0, currNode.val);
                    stack.add(currNode);
                    currNode = currNode.right;
                }
                currNode = stack.pop();
                currNode = currNode.left;
            }
            return res;
        }


        /**
         * 迭代解法1
         *
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal2(TreeNode root) {
            LinkedList<Integer> result = new LinkedList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode p = root;
            while (!stack.isEmpty() || p != null) {
                if (p != null) {
                    stack.push(p);
                    result.addFirst(p.val);  // Reverse the process of preorder
                    p = p.right;             // Reverse the process of preorder
                } else {
                    TreeNode node = stack.pop();
                    p = node.left;           // Reverse the process of preorder
                }
            }
            return result;
        }

        /**
         * 迭代解法1
         *
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal1(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> res = new ArrayList<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    res.add(0, root.val);
                    root = root.right;
                }
                root = stack.pop();
                root = root.left;
            }
            return res;
        }

        /**
         * 递归解法
         *
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal3(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            recursive(root, res);
            return res;
        }

        private void recursive(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            recursive(root.left, res);
            recursive(root.right, res);
            res.add(root.val);
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