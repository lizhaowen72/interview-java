package leetcode.editor.cn;
//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索

import java.util.LinkedList;
import java.util.List;

class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new LinkedList<>();
            List<Integer> currentResult = new LinkedList<>();
            pathSum(root, sum, currentResult, result);
            return result;
        }

        private void pathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {
            if (root == null) {
                return;
            }
            currentResult.add(root.val);
            if (root.left == null && root.right == null && sum == root.val) {
                result.add(new LinkedList<>(currentResult));
                currentResult.remove(currentResult.size() - 1);
                return;
            } else {
                pathSum(root.left, sum - root.val, currentResult, result);
                pathSum(root.right, sum - root.val, currentResult, result);
            }
            currentResult.remove(currentResult.size() - 1);
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