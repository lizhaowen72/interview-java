package leetcode.editor.cn;
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表

class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        solution.reverseBetween(node1, 2, 5);
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        private boolean stop;
        private ListNode left;

        ListNode successor = null;

        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == 1) {
                return reverseN(head, n);
            }
            head.next = reverseBetween(head.next, m - 1, n - 1);
            return head;
        }

        private ListNode reverseN(ListNode head, int n) {
            if (n == 1) {
                successor = head.next;
                return head;
            }
            ListNode last = reverseN(head.next, n - 1);
            head.next.next = head;
            head.next = successor;
            return last;
        }

        public ListNode reverseBetween3(ListNode head, int m, int n) {
            this.left = head;
            this.stop = false;
            this.recurseAndReverse(head, m, n);
            return head;
        }

        private void recurseAndReverse(ListNode right, int m, int n) {
            if (n == 1) {
                return;
            }
            right = right.next;
            if (m > 1) {
                this.left = this.left.next;
            }
            this.recurseAndReverse(right, m - 1, n - 1);
            if (this.left == right || right.next == this.left) {
                this.stop = true;
            }
            if (!this.stop) {
                int t = this.left.val;
                this.left.val = right.val;
                right.val = t;
                this.left = this.left.next;
            }
        }


        public ListNode reverseBetween2(ListNode head, int m, int n) {
            if (head == null) {
                return null;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            for (int i = 0; i < m - 1; i++) {
                pre = pre.next;
            }
            ListNode start = pre.next;
            ListNode then = start.next;
            for (int i = 0; i < n - m; i++) {
                start.next = then.next;
                then.next = pre.next;
                pre.next = then;
                then = start.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}