package leetcode.editor.cn;
//用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。 
//
// 你可以假设这个整数除了 0 本身，没有任何前导的 0。 
//
// 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
// 
// Related Topics 链表

public class PlusOneLinkedList {
    public static void main(String[] args) {
        Solution solution = new PlusOneLinkedList().new Solution();
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        solution.plusOne(node1);
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
        /**
         * 思路：
         * <p>
         * 用快指针fast，遍历链表
         * fast.val != 9，慢指针移动到当前快指针处
         * fast.val = 9，慢指针原地不动
         * 遍历结束，慢指针的值加一，慢指针后续所有节点值设置为0，
         *
         * @param head
         * @return
         */
        public ListNode plusOne(ListNode head) {
            //1.双指针
            ListNode fast = head;
            ListNode slow = new ListNode(0);
            slow.next = head;
            // 2.遍历链表
            while (fast != null) {
                if (fast.val != 9) {
                    slow = fast;
                }
                fast = fast.next;
            }
            //3.末位加1
            slow.val += 1;
            ListNode curr = slow.next;
            while (curr != null) {
                curr.val = 0;
                curr = curr.next;
            }
            return slow.next == head ? slow : head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}