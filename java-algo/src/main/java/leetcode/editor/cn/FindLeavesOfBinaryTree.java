package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//给你一棵完全二叉树，请按以下要求的顺序收集它的全部节点：
//
// 
// 依次从左到右，每次收集并删除所有的叶子节点 
// 重复如上过程直到整棵树为空 
// 
//
// 示例: 
//
// 输入: [1,2,3,4,5]
//  
//          1
//         / \
//        2   3
//       / \     
//      4   5    
//
//输出: [[4,5,3],[2],[1]]
// 
//
// 
//
// 解释: 
//
// 1. 删除叶子节点 [4,5,3] ，得到如下树结构： 
//
//           1
//         / 
//        2          
// 
//
// 
//
// 2. 现在删去叶子节点 [2] ，得到如下树结构： 
//
//           1          
// 
//
// 
//
// 3. 现在删去叶子节点 [1] ，得到空树： 
//
//           []         
// 
// Related Topics 树 深度优先搜索
public class FindLeavesOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new FindLeavesOfBinaryTree().new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
        solution.findLeaves(node1);
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
    /**
     * 使用dfs,递归时传入上一个节点,如果当前节点是叶子节点,则将值加入集合,使用上个节点将当前叶子节点删除
     * 每递归一次就会修剪掉叶子节点,形成新树,循环修剪叶子节点,直至剩下根节点,最后将根节点加入结果集即可
     */
    class Solution {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> findLeaves(TreeNode root) {
            if (root == null) return res;
            while (root.left != null || root.right != null) {
                helper(root, null, list);
                res.add(new ArrayList<>(list));
                list.clear();
            }
            list.add(root.val);
            res.add(new ArrayList<>(list));
            return res;
        }

        private void helper(TreeNode root, TreeNode pre, List<Integer> list) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                list.add(root.val);
                if (pre != null && pre.left == root) {
                    pre.left = null;
                }
                if (pre != null && pre.right == root) {
                    pre.right = null;
                }
            }
            pre = root;
            helper(root.left, pre, list);
            helper(root.right, pre, list);
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