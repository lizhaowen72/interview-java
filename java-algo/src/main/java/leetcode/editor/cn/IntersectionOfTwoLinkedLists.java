package leetcode.editor.cn;
//编写一个程序，找到两个单链表相交的起始节点。
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 
// Related Topics 链表


public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
        ListNode node4 = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node8 = new ListNode(8);
        ListNode node44 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node4.next = node1;
        node1.next = node8;
        node8.next = node44;
        node44.next = node5;

        ListNode node55 = new ListNode(5);
        ListNode node0 = new ListNode(0);
        node55.next = node0;
        node0.next = node1;

        solution.getIntersectionNode(node4, node55);
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        /**
         * Actually we don't care about the "value" of difference, we just want to make sure two pointers reach the intersection node at the same time.
         *
         * We can use two iterations to do that. In the first iteration, we will reset the pointer of one linkedlist to the head of another linkedlist
         * after it reaches the tail node. In the second iteration, we will move two pointers until they points to the same node. Our operations in first
         * iteration will help us counteract the difference. So if two linkedlist intersects, the meeting point in second iteration must be the intersection point.
         * If the two linked lists have no intersection at all, then the meeting pointer in second iteration must be the tail node of both lists, which is null
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 边界检查
            if (headA == null || headB == null) {
                return null;
            }
            ListNode a = headA;
            ListNode b = headB;
            //if a & b have different len, then we will stop the loop after second iteration
            while (a != b) {
                //for the end of first iteration, we just reset the pointer to the head of another linkedlist
                a = a == null ? headB : a.next;
                b = b == null ? headA : b.next;
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}