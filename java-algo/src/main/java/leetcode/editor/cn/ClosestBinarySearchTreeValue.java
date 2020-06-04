package leetcode.editor.cn;
//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 题目保证在该二叉搜索树中只会存在一个最接近目标值的数 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: 4
// 
// Related Topics 树 二分查找


public class ClosestBinarySearchTreeValue {
    public static void main(String[] args) {
        Solution solution = new ClosestBinarySearchTreeValue().new Solution();
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        solution.closestValue(node1, 3.71426);
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
        int res;

        public int closestValue(TreeNode root, double target) {
            return closest(root, target);
        }

        public int closest(TreeNode root, double target) {
            double delta = Math.abs(target - root.val);
            if (target < root.val) {
                if (root.left != null) {
                    int left = closest(root.left, target);
                    return Math.abs(left - target) > delta ? root.val : left;
                }
            }
            if (target > root.val) {
                if (root.right != null) {
                    int right = closest(root.right, target);
                    return Math.abs(right - target) > delta ? root.val : right;
                }
            }
            return root.val;
        }


        private void helper(TreeNode root, double target) {
            if (root == null) return;
            helper(root.left, target);
            res = Math.abs(res - target) > Math.abs(root.val - target) ? root.val : res;
            helper(root.right, target);
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