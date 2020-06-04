package leetcode.editor.cn;
//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
//
// 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树


public class SerializeAndDeserializeBst {
    public static void main(String[] args) {
        Codec solution = new SerializeAndDeserializeBst().new Codec();
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        String serialize = solution.serialize(node1);
        System.out.println(serialize);
        TreeNode deserialize = solution.deserialize("2,1,3");
        System.out.println(deserialize);
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

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return null;
            StringBuilder sb = new StringBuilder();
            helper(root, sb);
            return sb.substring(0, sb.length() - 1);
        }

        private void helper(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            sb.append(root.val).append(",");
            helper(root.left, sb);
            helper(root.right, sb);
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            String[] nodeValues = data.split(",");
            return builder(nodeValues, 0, nodeValues.length - 1);
        }

        private TreeNode builder(String[] nodeValues, int lo, int hi) {
            if (lo > hi) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(nodeValues[lo]));
            int index = hi + 1;
            for (int i = lo + 1; i <= hi; i++) {
                if (Integer.valueOf(nodeValues[i]) > root.val) {
                    index = i;
                    break;
                }
            }
            root.left = builder(nodeValues, lo + 1, index - 1);
            root.right = builder(nodeValues, index, hi);
            return root;
        }
    }

    // Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
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