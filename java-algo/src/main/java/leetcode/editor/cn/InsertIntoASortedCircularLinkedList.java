package leetcode.editor.cn;
//给定循环升序列表中的一个点，写一个函数向这个列表中插入一个新元素，使这个列表仍然是循环升序的。给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中
//最小元素的指针。 
//
// 如果有多个满足条件的插入位置，你可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。 
//
// 如果列表为空（给定的节点是 null），你需要创建一个循环有序列表并返回这个点。否则。请返回原先给定的节点。 
//
// 下面的例子可以帮你更好的理解这个问题： 
//
// 
//
// 
// 
//在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2。 
//
// 
//
// 
// 
//
// 新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3。 
// Related Topics 链表


public class InsertIntoASortedCircularLinkedList {
    public static void main(String[] args) {
        Solution solution = new InsertIntoASortedCircularLinkedList().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/
    class Solution {
        public Node insert(Node head, int insertVal) {
            Node ins = new Node(insertVal);
            // 头节点是空，构造单节点循环链表返回
            if (head == null) {
                ins.next = null;
                return ins;
            }
            // 记录最大值节点
            Node max = head;
            Node tmp = head;
            while (tmp.next != head) {
                Node next = tmp.next;
                // 寻找符合升序条件的节点
                if (tmp.val <= insertVal && insertVal <= next.val) {
                    tmp.next = ins;
                    ins.next = next;
                    return head;
                }
                tmp = next;
                if (tmp.val >= max.val) {
                    max = tmp;
                }
            }
            if (tmp.val <= insertVal && insertVal <= tmp.next.val) {
                Node next = tmp.next;
                tmp.next = ins;
                ins.next = next;
                return head;
            }
            // 没有满足升序的节点，将insertVal插入到最大值节点后面
            Node next = max.next;
            max.next = ins;
            ins.next = next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}