package leetcode.editor.cn;

//给出一个完全二叉树，求出该树的节点个数。
//
// 说明： 
//
// 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。 
//
// 示例: 
//
// 输入: 
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//输出: 6 
// Related Topics 树 二分查找
public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode nodeLeft = new TreeNode(2);
        TreeNode nodeRight = new TreeNode(3);
        root.left = nodeLeft;
        root.right = nodeRight;

        TreeNode nodeLeft1 = new TreeNode(4);
        TreeNode nodeRight1 = new TreeNode(5);
        nodeLeft.left = nodeLeft1;
        nodeLeft.right = nodeRight1;

        TreeNode nodeLeft2 = new TreeNode(6);
        TreeNode nodeRight2 = new TreeNode(7);
        nodeRight.left = nodeLeft2;
        //nodeRight.right = nodeRight2;
        solution.countNodes3(root);
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
        public int countNodes3(TreeNode root) {
            if (root == null) {
                return 0;
            }
            TreeNode left = root, right = root;
            int height = 0;
            while (right != null) {
                left = left.left;
                right = right.right;
                height++;
            }
            if (left == null) {
                return (1 << height) - 1;
            }
            return 1 + countNodes3(root.left) + countNodes3(root.right);
        }

        public int countNodes2(TreeNode root) {
            int nodes = 0, h = height(root);
            while (root != null) {
                if (height(root.right) == h - 1) {
                    nodes += 1 << h;
                    root = root.right;
                } else {
                    nodes += 1 << h - 1;
                    root = root.left;
                }
                h--;
            }
            return nodes;
        }

        public int countNodes1(TreeNode root) {
            int h = height(root);
            return h < 0 ? 0 : height(root.right) == h - 1 ? (1 << h) + countNodes1(root.right) :
                    (1 << h - 1) + countNodes1(root.left);
        }

        private int height(TreeNode root) {
            return root == null ? -1 : 1 + height(root.left);
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