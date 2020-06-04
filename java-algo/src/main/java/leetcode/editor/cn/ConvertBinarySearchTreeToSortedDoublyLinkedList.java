package leetcode.editor.cn;
//将一个二叉搜索树就地转化为一个已排序的双向循环链表。可以将左右孩子指针作为双向循环链表的前驱和后继指针。 
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例： 
//
// 
//
// 
//
// 
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。 
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。 
//
// 
//
// 
//
// 
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。 
//
// 下图显示了转化后的二叉搜索树，实线表示后继关系，虚线表示前驱关系。 
//
// 
//
// 
// Related Topics 树 链表 分治算法

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    public static void main(String[] args) {
        Solution solution = new ConvertBinarySearchTreeToSortedDoublyLinkedList().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
    class Solution {
        Node first = null;
        Node last = null;

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            helper(root);
            first.left = last;
            last.right = first;
            return first;
        }

        public void helper(Node root) {
            if (root == null) return;
            helper(root.left);
            if (last != null) {
                last.right = root;
                root.left = last;
            } else {
                first = root;
            }
            last = root;
            helper(root.right);
        }

    }


    class Solution1 {
        Node first = null;
        Node last = null;

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            helper(root);
            // 将最前与最后的结点链接完成闭环，返回 first 。
            last.right = first;
            first.left = last;
            return first;
        }

        // 标准中序遍历
        private void helper(Node root) {
            if (root != null) {
                helper(root.left);
                // 若 last 结点不为空，将 last 与当前的 node 链接。
                if (last != null) {
                    last.right = root;
                    root.left = last;
                } else {// 否则初始化 first 结点
                    first = root;
                }
                // 将当前结点标记为最后 : last = node.
                last = root;
                helper(root.right);
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class Node {
        int val;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}