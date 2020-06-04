package leetcode.editor.cn;

//给你一个二叉搜索树和其中的某一个结点，请你找出该结点在树中顺序后继的节点。
//
// 结点 p 的后继是值比 p.val 大的结点中键值最小的结点。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入: root = [2,1,3], p = 1
//输出: 2
//解析: 这里 1 的顺序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
// 
//
// 示例 2: 
//
// 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//输出: null
//解析: 因为给出的结点没有顺序后继，所以答案就返回 null 了。
// 
//
// 
//
// 注意: 
//
// 
// 假如给出的结点在该树中没有顺序后继的话，请返回 null 
// 我们保证树中每个结点的值是唯一的 
// 
// Related Topics 树

/**
 * 因为BST中序遍历的结果是节点升序，所以进行中序遍历找到P节点后遍历的下一个节点就是顺序后继节点
 * 由题意可知，顺序后继节点可能有两种情况：
 * 1.P是最后一个节点，顺序后继为null
 * 2.P不是最后一个节点，顺序后继为P中序遍历之后的第一个节点
 * 所以设定一个boolean指示是否找到P节点，并由boolean遍历的值来确定后继节点属于上述情况的哪种
 */
public class InorderSuccessorInBst {
    public static void main(String[] args) {
        Solution solution = new InorderSuccessorInBst().new Solution();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        solution.inorderSuccessor(root, root);
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
        TreeNode res;
        boolean findP;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null) return null;
            helper(root, p);
            return findP ? null : res;
        }

        private void helper(TreeNode root, TreeNode p) {
            if (root == null) {
                return;
            }
            helper(root.left, p);
            if (findP) {
                res = root;
                findP = false;
                return;
            }
            if (root == p) {
                findP = true;
            }
            helper(root.right, p);
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