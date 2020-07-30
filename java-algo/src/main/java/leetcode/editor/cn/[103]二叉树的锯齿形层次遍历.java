package leetcode.editor.cn;
//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
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
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索

import java.util.ArrayList;
import java.util.List;

class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        solution.zigzagLevelOrder(node3);
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> sol = new ArrayList<>();
            traverl(root, sol, 0);
            return sol;
        }

        private void traverl(TreeNode root, List<List<Integer>> sol, int level) {
            if (root == null) {
                return;
            }
            if (sol.size() <= level) {
                List<Integer> newLevel = new ArrayList<>();
                sol.add(newLevel);
            }
            List<Integer> levelList = sol.get(level);
            if (level % 2 == 0) {
                levelList.add(root.val);
            } else {
                levelList.add(0, root.val);
            }
            traverl(root.left, sol, level + 1);
            traverl(root.right, sol, level + 1);
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