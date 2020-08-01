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
// 👍 281 👎 0


import java.util.ArrayList;
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
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> currentList = new ArrayList<>();
            pathSumHelper(root, sum, res, currentList);
            return res;
        }

        private void pathSumHelper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> currentList) {
            if (root == null) {
                return;
            }
            currentList.add(root.val);
            if (root.left == null && root.right == null && sum - root.val == 0) {
                res.add(new ArrayList<>(currentList));
                currentList.remove(currentList.size() - 1);
                return;
            } else {
                pathSumHelper(root.left, sum - root.val, res, currentList);
                pathSumHelper(root.right, sum - root.val, res, currentList);
            }
            currentList.remove(currentList.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}