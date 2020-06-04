package leetcode.editor.cn;
//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的 k 个值。
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 你可以默认 k 值永远是有效的，即 k ≤ 总结点数 
// 题目保证该二叉搜索树中只会存在一种 k 个值集合最接近目标值 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 = 3.714286，且 k = 2
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: [4,3] 
//
// 拓展： 
//假设该二叉搜索树是平衡的，请问您是否能在小于 O(n)（n 为总结点数）的时间复杂度内解决该问题呢？ 
// Related Topics 栈 树


import java.util.*;

public class ClosestBinarySearchTreeValueIi {
    public static void main(String[] args) {
        Solution solution = new ClosestBinarySearchTreeValueIi().new Solution();
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        solution.closestKValues(node1, 3.714286, 2);
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            // 1.中序遍历,获得bst的升序元素
            List<Integer> list = new ArrayList<>();
            helper(root, list);
            // 2.根据升序元素数组,求出每个元素与target的差值绝对值,使用map保存差值和对应的节点
            Map<Double, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                Double key = Math.abs(list.get(i) - target);
                List<Integer> valueList = map.get(key);
                if (valueList == null) {
                    valueList = new ArrayList<>();
                }
                valueList.add(list.get(i));
                map.put(key, valueList);
            }
            // 3.排序
            ArrayList<Double> diffs = new ArrayList<>(map.keySet());
            Collections.sort(diffs);
            // 4.获取kge值
            List<Integer> res = new ArrayList<>();
            for (Double key : diffs) {
                for (int val : map.get(key)) {
                    res.add(val);
                    if (--k == 0) {
                        return res;
                    }
                }
            }
            return res;
        }

        private void helper(TreeNode root, List<Integer> list) {
            if (root == null) return;
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}