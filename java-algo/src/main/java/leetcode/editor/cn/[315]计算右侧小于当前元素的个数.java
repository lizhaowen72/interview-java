package leetcode.editor.cn;
//给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 num
//s[i] 的元素的数量。 
//
// 
//
// 示例： 
//
// 输入：nums = [5,2,6,1]
//输出：[2,1,1,0] 
//解释：
//5 的右侧有 2 个更小的元素 (2 和 1)
//2 的右侧仅有 1 个更小的元素 (1)
//6 的右侧有 1 个更小的元素 (1)
//1 的右侧有 0 个更小的元素
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 409 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();
        int[] nums = {5,2,2,6,1};
        solution.countSmaller(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            Integer[] arr = new Integer[nums.length];
            Node root = null;
            for (int i = nums.length-1; i >=0 ; i--) {
                root = insert(nums[i],root,arr,i,0);
            }
            return Arrays.asList(arr);
        }

        private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
            if (node==null){
                node = new Node(num,0);
                ans[i]=preSum;
            }else if (node.val==num){
                node.dup++;
                ans[i]=preSum+node.sum;
            }else if (node.val<num){
                node.right=insert(num,node.right,ans,i,preSum+node.sum+node.dup);
            }else{
                node.sum++;
                node.left = insert(num,node.left,ans,i,preSum);
            }
            return node;
        }
    }
   class Node{
        Node left,right;
        int val,sum,dup=1;

       public Node(int val, int sum) {
           this.val = val;
           this.sum = sum;
       }
   }
    //leetcode submit region end(Prohibit modification and deletion)

}