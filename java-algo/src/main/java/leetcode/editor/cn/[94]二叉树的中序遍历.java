package leetcode.editor.cn;
//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        List<Integer> integers = solution.inorderTraversal1(node1);
        System.out.println(integers);
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
        List<Integer> res = new ArrayList<>();

        public List<Integer> inorderTraversal1(TreeNode root) {
            traverse(root);
            return res;
        }

        public void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            traverse(root.left);
            res.add(root.val);
            traverse(root.right);
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            List<Integer> result = new ArrayList<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.add(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                result.add(curr.val);
                curr = curr.right;
            }
            return result;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}