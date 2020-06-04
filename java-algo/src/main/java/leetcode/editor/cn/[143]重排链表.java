package leetcode.editor.cn;
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表

class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
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
        solution.reorderList(node1);
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
        public void reorderList2(ListNode head) {
            if (head == null || head.next == null) return;
            // find the middle of the list
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // reverse the half after middler 1->2->3->4->5->6 to 1->2-3->6->5->4
            ListNode preMiddler = slow;
            ListNode preCurr = slow.next;
            while (preCurr.next != null) {
                ListNode tmp = preCurr.next;
                preCurr.next = tmp.next;
                tmp.next = preMiddler.next;
                preMiddler.next = tmp;
            }

            // start reorder one by one 1->2-3->6->5->4 to 1->6->2->5->3->4
            slow = head;
            fast = preMiddler.next;
            while (slow != preMiddler) {
                preMiddler.next = fast.next;
                fast.next = slow.next;
                slow.next = fast;
                slow = fast.next;
                fast = preMiddler.next;
            }
        }

        public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // reverse the half after middler 1->2->3->4->5->6 to 1->2-3->6->5->4
            ListNode preMiddler = slow;// 3->4->5->6
            ListNode preCurr = slow.next;// 4->5->6
            while (preCurr.next != null) {
                ListNode tmp = preCurr.next;// tmp 5->6             6
                preCurr.next = tmp.next;    // preCurr 4->6         4-null
                tmp.next = preMiddler.next; // tmp 5-4-6            6-5-4
                preMiddler.next = tmp;      // preMiddler 3-5-4-6   3-6-5-4
            }

            // start reorder one by one 1->2-3->6->5->4 to 1->6->2->5->3->4
            slow = head;
            fast = preMiddler.next;
            while (slow != preMiddler) {
                preMiddler.next = fast.next;
                fast.next = slow.next;
                slow.next = fast;
                slow = fast.next;
                fast = preMiddler.next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}