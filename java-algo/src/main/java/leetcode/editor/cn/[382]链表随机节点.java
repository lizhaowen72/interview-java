package leetcode.editor.cn;
//给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。 
//
// 进阶: 
//如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？ 
//
// 示例: 
//
// 
//// 初始化一个单链表 [1,2,3].
//ListNode head = new ListNode(1);
//head.next = new ListNode(2);
//head.next.next = new ListNode(3);
//Solution solution = new Solution(head);
//
//// getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
//solution.getRandom();
// 
// Related Topics 蓄水池抽样 
// 👍 78 👎 0

import java.util.Random;

class LinkedListRandomNode {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next=listNode2;
        Solution solution = new LinkedListRandomNode().new Solution(listNode1);
        int random = solution.getRandom();
        System.out.println(random);
    }
//leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        ListNode head;
        Random random;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head = head;
            this.random = new Random();
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            ListNode c = head;
            int r = c.val;
            for (int i = 1; c.next != null; i++) {
                c = c.next;
                if (random.nextInt(i + 1) == i) {
                    r = c.val;
                }
            }
            return r;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(head);
     * int param_1 = obj.getRandom();
     */
//leetcode submit region end(Prohibit modification and deletion)
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}