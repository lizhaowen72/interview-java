package leetcode.editor.cn;
//给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释:
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
// Related Topics 树 动态规划

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，
 * 或者是具有下列性质的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根
 * 结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 它的左、右子树也分别为二叉排序树。
 */
class UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
        List<TreeNode> treeNodes = solution.generateTrees(3);
        for (int i = 0; i < treeNodes.size(); i++) {
            System.out.println(treeNodes.get(i));
        }
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
        public List<TreeNode> generateTrees(int n) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            list = genTrees(1, n);
            if (list.get(0) == null) {
                return new ArrayList<TreeNode>();
            } else {
                return list;
            }
        }

        public List<TreeNode> genTrees(int start, int end) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            if (start > end) {
                list.add(null);
                return list;
            }
            if (start == end) {
                list.add(new TreeNode(start));
                return list;
            }
            List<TreeNode> left, right;
            for (int i = start; i <= end; i++) {
                left = genTrees(start, i - 1);
                right = genTrees(i + 1, end);
                for (TreeNode lnode : left) {
                    for (TreeNode rnode : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = lnode;
                        root.right = rnode;
                        list.add(root);
                    }
                }
            }
            return list;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}