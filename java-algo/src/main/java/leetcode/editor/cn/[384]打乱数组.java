package leetcode.editor.cn;
//打乱一个没有重复元素的数组。 
//
// 示例: 
//
// 
//// 以数字集合 1, 2 和 3 初始化数组。
//int[] nums = {1,2,3};
//Solution solution = new Solution(nums);
//
//// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
//solution.shuffle();
//
//// 重设数组到它的初始状态[1,2,3]。
//solution.reset();
//
//// 随机返回数组[1,2,3]打乱后的结果。
//solution.shuffle();
// 
//

import java.util.Random;

class ShuffleAnArray {
    public static void main(String[] args) {
        Solution solution = new ShuffleAnArray().new Solution(new int[]{1, 2, 3});
        int[] shuffle = solution.shuffle();
        for (int i : shuffle) {
            System.out.print(i + "->");
        }
        int[] reset = solution.reset();
        for (int i : reset) {
            System.out.print(i + "-->");
        }
        int[] res = solution.shuffle();
        for (int i : res) {
            System.out.print(i+"--->");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] array;
        private int[] original;

        public Solution(int[] nums) {
            array = nums;
            original = nums.clone();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            array = original;
            original = original.clone();
            return original;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            for (int i = 0; i < array.length; i++) {
                swap(i, randRange(i, array.length));
            }
            return array;
        }

        private void swap(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        private int randRange(int min, int max) {
            return new Random().nextInt(max - min) + min;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}