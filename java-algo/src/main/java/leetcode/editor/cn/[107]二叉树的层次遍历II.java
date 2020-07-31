package leetcode.editor.cn;
//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 276 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        solution.dfsHelper(root);
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            return dfsTraverse(root);
        }

        private List<List<Integer>> dfsHelper(TreeNode root) {
            List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
            dfsHelper(wrapList, root, 0);
            return wrapList;
        }

        private void dfsHelper(List<List<Integer>> wrapList, TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (level >= wrapList.size()) {
                wrapList.add(0, new LinkedList<Integer>());
            }
            dfsHelper(wrapList, root.left, level + 1);
            dfsHelper(wrapList, root.right, level + 1);
            wrapList.get(wrapList.size() - level - 1).add(root.val);
        }

        private List<List<Integer>> bfsHelper(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> wrapList = new LinkedList<>();
            if (root == null) {
                return wrapList;
            }
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelNum = queue.size();
                List<Integer> subList = new LinkedList<>();
                for (int i = 0; i < levelNum; i++) {
                    if (queue.peek().left != null) {
                        queue.offer(queue.peek().left);
                    }
                    if (queue.peek().right != null) {
                        queue.offer(queue.peek().right);
                    }
                    subList.add(queue.poll().val);
                }
                wrapList.add(0, subList);
            }
            return wrapList;
        }

        public List<List<Integer>> bfsTraverse(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null) return res;
            queue.add(root);
            while (!queue.isEmpty()) {
                int level_num = queue.size();
                List<Integer> subRes = new ArrayList<>();
                for (int i = 0; i < level_num; i++) {
                    if (queue.peek().left != null) {
                        queue.add(queue.peek().left);
                    }
                    if (queue.peek().right != null) {
                        queue.add(queue.peek().right);
                    }
                    subRes.add(queue.poll().val);
                }
                res.add(0, subRes);
            }
            return res;
        }

        public List<List<Integer>> dfsTraverse(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            dfsTraverseHelper(root, 0, res);
            return res;
        }

        public void dfsTraverseHelper(TreeNode root, int level, List<List<Integer>> res) {
            if (root == null) return;
            if (level >= res.size()) {
                res.add(0, new ArrayList<>());
            }
            dfsTraverseHelper(root.left, level + 1, res);
            dfsTraverseHelper(root.right, level + 1, res);
            res.get(res.size() - level - 1).add(root.val);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}