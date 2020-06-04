package leetcode.editor.cn;
//你需要从一个包括括号和整数的字符串构建一棵二叉树。 
//
// 输入的字符串代表一棵二叉树。它包括整数和随后的0，1或2对括号。整数代表根的值，一对括号内表示同样结构的子树。 
//
// 若存在左子结点，则从左子结点开始构建。 
//
// 示例: 
//
// 输入: "4(2(3)(1))(6(5))"
//输出: 返回代表下列二叉树的根节点:
//
//       4
//     /   \
//    2     6
//   / \   / 
//  3   1 5   
// 
//
// 
//
// 注意: 
//
// 
// 输入字符串中只包含 '(', ')', '-' 和 '0' ~ '9' 
// 空树由 "" 而非"()"表示。 
// 
//
// 
// Related Topics 树 字符串

import java.util.Stack;

public class ConstructBinaryTreeFromString {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromString().new Solution();
        solution.str2tree("423(2(3)(1))(6(5))");
    }


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    /**
     * 字符串输出的规律为root.val(root.left.val)(root.right.val)，遵循前序遍历，所以创建一个Stack来储存节点。
     * 遍历字符串，如果遇到了数字，则创建节点，如果stack不为空，则获取顶层元素，如果顶层元素的左子树为null，则当前节点为顶层元素的左子树
     * 如果顶层元素左子树不为Null，则将当前节点连接在右子树，当遇到")"弹出stack顶层元素，直到字符串遍历完。
     * 这里需要注意节点可能为负值。
     */
    class Solution {
        public TreeNode str2tree(String s) {
            if (s == null || s.length() == 0) return null;
            Stack<TreeNode> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    stack.pop();
                } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-') {
                    int start = i;
                    // 找到根节点
                    while (i < s.length() - 1 && s.charAt(i + 1) >= '0' && s.charAt(i) <= '9') {
                        i++;
                    }
                    TreeNode root = new TreeNode(Integer.valueOf(s.substring(start, i + 1)));
                    if (!stack.isEmpty()) {
                        TreeNode parent = stack.peek();
                        if (parent.left == null) {
                            parent.left = root;
                        } else {
                            parent.right = root;
                        }
                    }
                    stack.push(root);
                }
            }
            if (stack.isEmpty()) return null;
            return stack.pop();
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