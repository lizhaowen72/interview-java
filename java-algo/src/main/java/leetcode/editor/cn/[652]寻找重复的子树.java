package leetcode.editor.cn;
//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FindDuplicateSubtrees {
    public static void main(String[] args) {
        Solution solution = new FindDuplicateSubtrees().new Solution();
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
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> res = new ArrayList<>();
            postOrder(root, new HashMap<String, Integer>(), res);
            return res;
        }

        private String postOrder(TreeNode root, HashMap<String, Integer> map, List<TreeNode> res) {
            if (root == null) return "#";
            String serial = root.val + "," + postOrder(root.left, map, res) + "," + postOrder(root.right, map, res);
            if (map.getOrDefault(serial, 0) == 1) {
                res.add(root);
            }
            map.put(serial, map.getOrDefault(serial, 0) + 1);
            return serial;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}