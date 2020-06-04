package leetcode.editor.cn;
//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表

class SortList{
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        node4.next = node2;
        node2.next = node1;
        node1.next = node3;
        solution.sortList(node4);
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
        public ListNode sortList(ListNode head) {
            // 递归终止条件
            if (head == null || head.next == null) {
                return head;
            }
            // 使用快慢指针切割链表成2部分
            ListNode prev = null, slow = head, fast = head;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next = null;
            ListNode l1 = sortList(head);
            ListNode l2 = sortList(slow);
            return mergeSortList(l1, l2);
        }

        private ListNode mergeSortList(ListNode l1, ListNode l2) {
            ListNode dummyNode = new ListNode(0);
            ListNode curr = dummyNode;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
                curr = curr.next;
            }
            if (l1 != null) {
                curr.next = l1;
            }
            if (l2 != null) {
                curr.next = l2;
            }
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}