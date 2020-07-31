package leetcode.editor.cn;
//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组

import java.util.HashMap;
import java.util.Map;

class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        solution.buildTree(inorder, postorder);
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || postorder == null || inorder.length != postorder.length) {
                return null;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTreeByPostAndInOrder(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
        }

        public TreeNode buildTreeByPostAndInOrder(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend, Map<Integer, Integer> map) {
            if (istart > iend || pstart > pend) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[pend]);
            Integer rindex = map.get(postorder[pend]);
            root.left = buildTreeByPostAndInOrder(inorder, istart, rindex - 1, postorder, pstart, pstart + rindex - istart - 1, map);
            root.right = buildTreeByPostAndInOrder(inorder, rindex + 1, iend, postorder, pstart + rindex - istart, pend - 1, map);
            return root;
        }

        /**
         * The the basic idea is to take the last element in postorder array as the root, find the position of the root
         * in the inorder array; then locate the range for left sub-tree and right sub-tree and do recursion. Use a HashMap
         * to record the index of root in the inorder array.
         *
         * @param inorder
         * @param postorder
         * @return
         */
        public TreeNode buildTree2(int[] inorder, int[] postorder) {
            if (inorder == null || postorder == null || inorder.length != postorder.length) {
                return null;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
        }

        private TreeNode buildTreePostIn(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend, Map<Integer, Integer> map) {
            if (pstart > pend || istart > iend) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[pend]);
            // root节点对应的节点
            int ri = map.get(postorder[pend]);
            TreeNode leftChild = buildTreePostIn(inorder, istart, ri - 1, postorder, pstart, pstart + ri - istart - 1, map);
            TreeNode rightChild = buildTreePostIn(inorder, ri + 1, iend, postorder, pstart + ri - istart, pend - 1, map);
            root.left = leftChild;
            root.right = rightChild;
            return root;
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