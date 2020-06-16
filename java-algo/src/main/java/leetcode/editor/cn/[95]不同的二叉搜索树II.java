package leetcode.editor.cn;
//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划


import java.util.ArrayList;
import java.util.List;

class UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            List<TreeNode> treeNodes = genTrees(1, n);
            if (treeNodes.get(0) == null) {
                return new ArrayList<TreeNode>();
            }
            return treeNodes;

        }

        public List<TreeNode> genTrees(int start, int end) {
            List<TreeNode> res = new ArrayList<>();
            if (start > end) {
                res.add(null);
                return res;
            }
            if (start == end) {
                res.add(new TreeNode(start));
                return res;
            }
            List<TreeNode> leftListTreeNode = null, rightListTreeNode = null;
            for (int i = start; i <= end; i++) {
                leftListTreeNode = genTrees(start, i - 1);
                rightListTreeNode = genTrees(i + 1, end);
                for (TreeNode lTreeNode : leftListTreeNode) {
                    for (TreeNode rTreeNode : rightListTreeNode) {
                        TreeNode root = new TreeNode(i);
                        root.left = lTreeNode;
                        root.right = rTreeNode;
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}