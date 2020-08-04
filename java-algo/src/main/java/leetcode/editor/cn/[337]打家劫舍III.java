package leetcode.editor.cn;
//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 
// 👍 446 👎 0


class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);
        root.left = node2;
        root.right = node3;
        node2.right = node4;
        node3.right = node5;
        solution.rob(root);

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
        public int rob(TreeNode root) {
            int[] rob = doRob1(root);
            return Math.max(rob[0], rob[1]);
        }

        public int[] doRob1(TreeNode root) {
            int[] rob = new int[2];
            if (root == null) {
                return rob;
            }
            int[] leftArr = doRob1(root.left);
            int[] rightArr = doRob1(root.right);
            rob[0] = Math.max(leftArr[0], leftArr[1]) + Math.max(rightArr[0], rightArr[1]);
            rob[1] = leftArr[0] + root.val + rightArr[0];
            return rob;
        }


        public int rob1(TreeNode root) {
            int[] rob = doRob(root);
            return Math.max(rob[0], rob[1]);
        }

        private int[] doRob(TreeNode root) {
            // res[0]:表示不加根节点能够盗取的最大金额
            // res[1]:表示加上根节点能够盗取的最大金额
            int[] res = new int[2];
            if (root == null) {
                return res;
            }
            int[] leftArr = doRob(root.left);// [3.2]
            int[] rightArr = doRob(root.right);// [1,2]
            res[0] = Math.max(leftArr[0], leftArr[1]) + Math.max(rightArr[0], rightArr[1]);
            res[1] = leftArr[0] + root.val + rightArr[0];
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}