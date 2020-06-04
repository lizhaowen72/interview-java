package leetcode.editor.cn;

import java.util.Stack;

//给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，要么为空，将此二叉树上下翻转并将它变成一棵树， 原来的右节点将转换成左叶节点。返回新的根。
//
// 例子: 
//
// 输入: [1,2,3,4,5]
//
//    1
//   / \
//  2   3
// / \
//4   5
//
//输出: 返回二叉树的根 [4,5,2,#,#,3,1]
//
//   4
//  / \
// 5   2
//    / \
//   3   1  
// 
//
// 说明: 
//
// 对 [4,5,2,#,#,3,1] 感到困惑? 下面详细介绍请查看 二叉树是如何被序列化的。 
//
// 二叉树的序列化遵循层次遍历规则，当没有节点存在时，'#' 表示路径终止符。 
//
// 这里有一个例子: 
//
//    1
//  / \
// 2   3
//    /
//   4
//    \
//     5
// 
//
// 上面的二叉树则被序列化为 [1,2,3,#,#,4,#,#,5]. 
// Related Topics 树
public class BinaryTreeUpsideDown {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeUpsideDown().new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        solution.upsideDownBinaryTree(node1);
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
        public TreeNode upsideDownBinaryTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            Stack<TreeNode> stack = new Stack<>();

            while (root.left != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode dummyRoot = root;
            TreeNode curr = dummyRoot;
            while (!stack.isEmpty()) {
                TreeNode parent = stack.pop();
                TreeNode left = parent.right;
                curr.left = left;
                curr.right = parent;
                parent.left = null;
                parent.right = null;
                curr = parent;
            }
            return dummyRoot;
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