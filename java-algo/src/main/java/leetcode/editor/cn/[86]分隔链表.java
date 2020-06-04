package leetcode.editor.cn;
//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针

class PartitionList{
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        ListNode node2 = new ListNode(1);
        ListNode node22 = new ListNode(4);
        ListNode node222 = new ListNode(3);
        node2.next = node22;
        node22.next = node222;
        solution.partition(node2, 0);
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
        public ListNode partition(ListNode head, int x) {

            // before and after are the two pointers used to create the two list
            // before_head and after_head are used to save the heads of the two lists.
            // All of these are initialized with the dummy nodes created.
            ListNode before_head = new ListNode(0);
            ListNode before = before_head;
            ListNode after_head = new ListNode(0);
            ListNode after = after_head;

            while (head != null) {

                // If the original list node is lesser than the given x,
                // assign it to the before list.
                if (head.val < x) {
                    before.next = head;
                    before = before.next;
                } else {
                    // If the original list node is greater or equal to the given x,
                    // assign it to the after list.
                    after.next = head;
                    after = after.next;
                }

                // move ahead in the original list
                head = head.next;
            }

            // Last node of "after" list would also be ending node of the reformed list
            after.next = null;

            // Once all the nodes are correctly assigned to the two lists,
            // combine them to form a single list which would be returned.
            before.next = after_head.next;

            return before_head.next;
        }

        public ListNode partition2(ListNode head, int x) {
            ListNode node1 = new ListNode(0);
            ListNode node2 = new ListNode(0);
            ListNode pre1 = node1, pre2 = node2;
            ListNode cur = head;
            while (cur != null) {
                if (cur.val < x) {
                    pre1.next = cur;
                    pre1 = pre1.next;
                } else {
                    pre2.next = cur;
                    pre2 = pre2.next;
                }
                cur = cur.next;
            }
            /**
             * 我对这步的理解是：遍历完head后存放大数的链表最后一个节点后若还有小的节点，再循环中仅仅为该小节点添加引用（添加到存放小
             * 数的链表末）是不够的，需要将其最后一个大数的next域设为空避免出现环形链表，否则在结果链表中遍历完结果又会跳到小数部分出现死循环。
             */
            pre2.next = null;
            pre1.next = node2.next;
            return node1.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}