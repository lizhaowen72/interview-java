package leetcode.editor.cn;
//给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。然后求出出现次数最多的子树
//元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。 
//
// 
//
// 示例 1 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2 
//输入: 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 哈希表

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
    public static void main(String[] args) {
        Solution solution = new MostFrequentSubtreeSum().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    /**
     * Use a hashMap count to count the subtree sum occurrence.
     * <p>
     * A sub function dfs(TreeNode node) will
     * travel through a tree, recursively calculate the sum of subtree,
     * increment the count, and finally return the sum of the sub tree.
     */
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        int countMax;

        public int[] findFrequentTreeSum(TreeNode root) {
            dfs(root);
            List<Integer> res = new ArrayList<>();
            for (Integer key : map.keySet()) {
                if (map.get(key) == countMax) {
                    res.add(key);
                }
            }
            return res.stream().mapToInt(i -> i).toArray();
        }

        private int dfs(TreeNode root) {
            if (root == null) return 0;
            int key = dfs(root.left) + dfs(root.right) + root.val;
            map.put(key, map.getOrDefault(key, 0) + 1);
            countMax = Math.max(countMax, map.get(key));
            return key;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}