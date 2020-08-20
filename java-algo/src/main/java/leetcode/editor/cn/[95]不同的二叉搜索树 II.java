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
// 👍 604 👎 0

import com.sun.org.apache.xalan.internal.xsltc.dom.NodeSortRecord;

import java.util.ArrayList;
import java.util.List;

class UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
        solution.generateTrees(3);
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
            List<TreeNode>[] result = new List[n + 1];
            result[0] = new ArrayList<TreeNode>();
            if (n == 0) {
                return result[0];
            }
            result[0].add(null);
            for (int len = 1; len <= n; len++) {
                result[len] = new ArrayList<TreeNode>();
                for (int j = 0; j < len; j++) {
                    for (TreeNode nodeL : result[j]) {
                        for (TreeNode nodeR : result[len - j - 1]) {
                            TreeNode node = new TreeNode(j + 1);
                            node.left = nodeL;
                            node.right = clone(nodeR, j + 1);
                            result[len].add(node);
                        }
                    }
                }
            }
            return result[n];
        }

        private TreeNode clone(TreeNode node, int offSet) {
            if (node == null) {
                return null;
            }
            TreeNode treeNode = new TreeNode(node.val + offSet);
            treeNode.left = clone(node.left, offSet);
            treeNode.right = clone(node.right, offSet);
            return treeNode;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}