package leetcode.editor.cn;
//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversalIi{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        solution.levelOrderBottom(node3);
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            //return bfsHelper(root);
            return  dfsHelper(root);
        }

        private List<List<Integer>> dfsHelper(TreeNode root) {
            List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
            dfsHelper(wrapList,root,0);
            return  wrapList;
        }

        private void dfsHelper(List<List<Integer>> wrapList, TreeNode root, int level) {
            if (root == null){
                return;
            }
            if (level>=wrapList.size()){
                wrapList.add(0,new LinkedList<Integer>());
            }
            dfsHelper(wrapList,root.left,level+1);
            dfsHelper(wrapList,root.right,level+1);
            wrapList.get(wrapList.size()-level-1).add(root.val);
        }

        private List<List<Integer>> bfsHelper(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> wrapList = new LinkedList<>();
            if (root == null) {
                return wrapList;
            }
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelNum = queue.size();
                List<Integer> subList = new LinkedList<>();
                for (int i = 0; i < levelNum; i++) {
                    if (queue.peek().left != null) {
                        queue.offer(queue.peek().left);
                    }
                    if (queue.peek().right != null) {
                        queue.offer(queue.peek().right);
                    }
                    subList.add(queue.poll().val);
                }
                wrapList.add(0, subList);
            }
            return wrapList;
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