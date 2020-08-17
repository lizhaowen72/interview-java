package leetcode.editor.cn;
//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 135 👎 0

class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.left = node6;
        solution.findMode(node1);
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
        private int currVal;
        private int currCount=0;
        private int maxCount=0;
        private int modeCount=0;
        private int[] nodes;
        public int[] findMode(TreeNode root) {
            inorder(root);
            nodes=new int[modeCount];
            modeCount=0;
            currCount=0;
            inorder(root);
            return nodes;
        }

        private void inorder(TreeNode root) {
            if (root==null) return;
            inorder(root.left);
            handlerValue(root.val);
            inorder(root.right);
        }

        private void handlerValue(int val) {
            if (val!=currVal){
                currVal=val;
                currCount=0;
            }
            currCount++;
            if (currCount>maxCount){
                maxCount=currCount;
                modeCount=1;
            }else if (currCount==maxCount){
                if (nodes!=null){
                    nodes[modeCount]=currVal;
                }
                modeCount++;
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}