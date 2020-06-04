package leetcode.editor.cn;
//对链表进行插入排序。 
//
// 
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。 
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。 
//
// 
//
// 插入排序算法： 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2： 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
// 
// Related Topics 排序 链表

class InsertionSortList{
    public static void main(String[] args) {
        Solution solution = new InsertionSortList().new Solution();
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node1 = new ListNode(1);
        ListNode node0 = new ListNode(0);
        node4.next = node2;
        node2.next = node3;
        node3.next = node1;
        node1.next = node0;
        solution.insertionSortList(node4);
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
        public ListNode insertionSortList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode helper = new ListNode(0);// new starter of the sorted list
            ListNode cur = head;// the node will be inserted
            ListNode pre = helper; // insert node between pre and pre.next
            ListNode next = null;// the next node will be inserted
            // not the end of input list
            while (cur != null) {
                next = cur.next;
                // find the right place to insert
                while (pre.next != null && pre.next.val < cur.val) {
                    pre = pre.next;
                }
                // insert between pre and pre.next
                cur.next = pre.next;
                pre.next = cur;
                pre = helper;
                cur = next;
            }
            return helper.next;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
}