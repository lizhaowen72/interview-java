package leetcode.editor.cn;

//给定一个二叉树，统计该二叉树数值相同的子树个数。
//
// 同值子树是指该子树的所有节点都拥有相同的数值。 
//
// 示例： 
//
// 输入: root = [5,1,5,5,5,null,5]
//
//              5
//             / \
//            1   5
//           / \   \
//          5   5   5
//
//输出: 4
// 
// Related Topics 树
public class CountUnivalueSubtrees {
    public static void main(String[] args) {
        Solution solution = new CountUnivalueSubtrees().new Solution();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        solution.countUnivalSubtrees(node1);
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
        int res = 0;

        public int countUnivalSubtrees(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (isUnival(root, root.val)) {
                res++;
            }
            countUnivalSubtrees(root.left);
            countUnivalSubtrees(root.right);
            return res;
        }

        private boolean isUnival(TreeNode root, int val) {
            if (root == null) {
                return true;
            }
            if (root.val != val) {
                return false;
            }
            return isUnival(root.left, val) && isUnival(root.right, val);
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