package leetcode.editor.cn;

//给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，其中最大指的是子树节点数最多的。
//
// 注意: 
//子树必须包含其所有后代。 
//
// 示例: 
//
// 输入: [10,5,15,1,8,null,7]
//
//   10 
//   / \ 
//  5  15 
// / \   \ 
//1   8   7
//
//输出: 3
//解释: 高亮部分为最大的 BST 子树。
//     返回值 3 在这个样例中为子树大小。
// 
//
// 进阶: 
//你能想出用 O(n) 的时间复杂度解决这个问题吗？ 
// Related Topics 树
public class LargestBstSubtree {
    public static void main(String[] args) {
        Solution solution = new LargestBstSubtree().new Solution();
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        solution.largestBSTSubtree(node1);
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
        int res = 0, preVal = Integer.MIN_VALUE;

        public int largestBSTSubtree(TreeNode root) {
            if (root == null) return 0;
            preVal = Integer.MIN_VALUE;
            if (isBST(root)) {
                res = Math.max(res, getCount(root));
            }
            largestBSTSubtree(root.left);
            largestBSTSubtree(root.right);
            return res;
        }

        public int getCount(TreeNode root) {
            if (root == null) return 0;
            return getCount(root.left) + getCount(root.right) + 1;
        }

        private boolean isBST(TreeNode root) {
            if (root == null) return true;
            boolean leftFlag = isBST(root.left);
            if (preVal >= root.val) {
                return false;
            }
            preVal = root.val;
            boolean rightFlag = isBST(root.right);
            return leftFlag && rightFlag;
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