package leetcode.editor.cn;
//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计 
// 👍 60 👎 0

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class XuLieHuaErChaShuLcof {
    public static void main(String[] args) {
        Codec solution = new XuLieHuaErChaShuLcof().new Codec();
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
    public class Codec {
        private static final String spliter = ",";
        private static final String NN = "X";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root==null){
                return null;
            }
            StringBuilder sb = new StringBuilder();
            serializeHelp(root,sb);
            return sb.toString();
        }

        private void serializeHelp(TreeNode root, StringBuilder sb) {
            if (root==null){
                sb.append(NN).append(spliter);
            }else{
                sb.append(root.val).append(spliter);
                serializeHelp(root.left,sb);
                serializeHelp(root.right,sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data==null) return null;
            String[] strs = data.split(spliter);
            Queue<String> queue = new LinkedList<>();
            queue.addAll(Arrays.asList(strs));
            return deserializeHelper(queue);
        }

        private TreeNode deserializeHelper(Queue<String> queue) {
            String node = queue.remove();
            if (node.equals(NN)){
                return null;
            }else{
                TreeNode root = new TreeNode(Integer.valueOf(node));
                root.left=deserializeHelper(queue);
                root.right=deserializeHelper(queue);
                return root;
            }
        }
    }

    // Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
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