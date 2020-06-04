package leetcode.editor.cn;
//二叉搜索树中的两个节点被错误地交换。 
//
// 请在不改变其结构的情况下，恢复这棵树。 
//
// 示例 1: 
//
// 输入: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//输出: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
// 
//
// 示例 2: 
//
// 输入: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//输出: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3 
//
// 进阶: 
//
// 
// 使用 O(n) 空间复杂度的解法很容易实现。 
// 你能想出一个只使用常数空间的解决方案吗？ 
// 
// Related Topics 树 深度优先搜索

class RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new RecoverBinarySearchTree().new Solution();
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        node.left = node1;
        node.right = node2;
        node2.left = node3;
        solution.recoverTree(node);
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
        TreeNode firstElement = null;
        TreeNode secondElement = null;
        TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

        /**
         * 镜像解法
         *
         * @param root
         */
        public void recoverTree(TreeNode root) {
            TreeNode pre = null;
            TreeNode first = null, second = null;
            TreeNode temp = null;
            while (root != null) {
                if (root.left != null) {
                    // connect threading for root
                    temp = root.left;
                    while (temp.right != null && temp.right != root) {
                        temp = temp.right;
                    }
                    // the threading already exists
                    if (temp.right != null) {
                        if (pre != null && pre.val > root.val) {
                            if (first == null) {
                                first = pre;
                                second = root;
                            } else {
                                second = root;
                            }
                        }
                        pre = root;
                        temp.right = null;
                        root = root.right;
                    } else {
                        // construct the threading
                        temp.right = root;
                        root = root.left;
                    }
                } else {
                    if (pre != null && pre.val > root.val) {
                        if (first == null) {
                            first = pre;
                            second = root;
                        } else {
                            second = root;
                        }
                    }
                    pre = root;
                    root = root.right;
                }
            }
            // swap two node values;
            if (first != null && second != null) {
                int t = first.val;
                first.val = second.val;
                second.val = t;
            }
        }

        /**
         * 递归解法
         *
         * @param root
         */
        public void recoverTree2(TreeNode root) {
            traverse(root);
            int temp = firstElement.val;
            firstElement.val = secondElement.val;
            secondElement.val = temp;
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            traverse(root.left);
            if (firstElement == null && prevElement.val > root.val) {
                firstElement = prevElement;
            }
            if (firstElement != null && prevElement.val > root.val) {
                secondElement = root;
            }
            prevElement = root;
            traverse(root.right);
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