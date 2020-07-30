package leetcode.editor.cn;
//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preOrder = {3, 9, 20};
        int[] inOrder = {9, 3, 20};
        TreeNode treeNode = solution.buildTree(preOrder, inOrder);
        System.out.println(treeNode);
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

        public TreeNode buildTree(int[] preOrder, int[] inOrder) {
            return build(0, 0, inOrder.length - 1, preOrder, inOrder);
        }

        public TreeNode build(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
            if (preStart > preOrder.length - 1 || inStart > inEnd) {
                return null;
            }
            TreeNode root = new TreeNode(preOrder[preStart]);
            int rootIndex = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inOrder[i] == root.val) {
                    rootIndex = i;
                    break;
                }
            }
            root.left = build(preStart + 1, inStart, rootIndex - 1, preOrder, inOrder);
            root.right = build(preStart + rootIndex - inStart + 1, rootIndex + 1, inEnd, preOrder, inOrder);
            return root;
        }


        public TreeNode buildTree1(int[] preorder, int[] inorder) {
            return helper(0, 0, inorder.length - 1, preorder, inorder);
        }

        private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
            if (preStart > preorder.length - 1 || inStart > inEnd) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            int inIndex = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == root.val) {
                    inIndex = i;
                    break;
                }
            }
            root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
            root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
            return root;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }
}