package leetcode.editor.cn;
//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 288 👎 0


import java.util.ArrayList;
import java.util.List;

class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left=treeNode2;
        treeNode.right=treeNode3;
        solution.rightSideView(treeNode);
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
        public List<Integer> rightSideView(TreeNode root) {
           List<Integer> res = new ArrayList<>();
           helper(root,res,0);
           return res;
        }
        public void helper(TreeNode root,List<Integer> res,int currDepth){
            if (root==null){
                return;
            }
            /**
             * 针对这个题目，只看右视图，也就是说每层只能获取一个节点，因此list的size（）==currDepth，才能加入到res中
             */
            if (currDepth==res.size()){
                res.add(root.val);
            }
            helper(root.right,res,currDepth+1);
            // 为什么要看left，如果一层中right都为空的情况下，当然这个时候从右看二叉树，当然能够看到left子树
            helper(root.left,res,currDepth+1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}