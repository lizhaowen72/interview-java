package leetcode.editor.cn;
//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
// 
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
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 162 👎 0


class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null) {
                return null;
            }
            return build(preorder, 0, inorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int pstart, int[] inorder, int istart, int iend) {
            if (pstart > preorder.length - 1 || istart > iend) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[pstart]);
            int iRootIndex = 0;
            for (int i = istart; i <= iend; i++) {
                if (inorder[i] == root.val) {
                    iRootIndex = i;
                    break;
                }
            }
            root.left = build(preorder, pstart + 1, inorder, istart, iRootIndex - 1);
            root.right = build(preorder, pstart + iRootIndex - istart + 1, inorder, iRootIndex + 1, iend);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}