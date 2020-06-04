package leetcode.editor.cn;

//序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
//
//      _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
// 
//
// 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。 
//
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。 
//
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。 
//
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。 
//
// 示例 1: 
//
// 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//输出: true 
//
// 示例 2: 
//
// 输入: "1,#"
//输出: false
// 
//
// 示例 3: 
//
// 输入: "9,#,#,1"
//输出: false 
// Related Topics 栈

/**
 * （1）前序遍历
 * <p>
 * a、访问根节点；b、前序遍历左子树；c、前序遍历右子树。
 * <p>
 * （2）中序遍历
 * <p>
 * a、中序遍历左子树；b、访问根节点；c、中序遍历右子树。
 * <p>
 * （3）后序遍历
 * <p>
 * a、后序遍历左子树；b、后续遍历右子树；c、访问根节点。
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new VerifyPreorderSerializationOfABinaryTree().new Solution();
        solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Some used stack. Some used the depth of a stack. Here I use a different perspective.
         * In a binary tree, if we consider null as leaves, then
         * <p>
         * all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
         * all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
         * Suppose we try to build this tree. During building, we record the difference between out degree and in degree
         * diff = outdegree - indegree. When the next node comes, we then decrease diff by 1, because the node provides an in degree.
         * If the node is not null, we increase diff by 2, because it provides two out degrees. If a serialization is correct,
         * diff should never be negative and diff will be zero when finished.
         *
         * @param preorder
         * @return
         */
        public boolean isValidSerialization(String preorder) {
            String[] nodes = preorder.split(",");
            int diff = 1;
            for (String node : nodes) {
                if (--diff < 0) {
                    return false;
                }
                if (!node.equals("#")) {
                    diff += 2;
                }
            }
            return diff == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}