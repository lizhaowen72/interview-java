package leetcode.editor.cn;
//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。 
//
// 示例 : 
//
// 输入: [1,2,1,3,2,5]
//输出: [3,5] 
//
// 注意： 
//
// 
// 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。 
// 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
// 
// Related Topics 位运算

class SingleNumberIii{
    public static void main(String[] args) {
         Solution solution = new SingleNumberIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        /**
         * 在第一遍中，我们对数组中的所有元素进行XOR，然后获取我们需要查找的两个数字的XOR。 请注意，由于两个数字是不同的，因此XOR结果中必须有一个设置位（即值“ 1”的位）。 找
         * 输出任意的设置位（例如，最右边的设置位）。
         * <p>
         * 在第二遍中，我们将所有数字分为两组，一个组设置了上述位，另一组未设置上述位。 我们需要找到的两个不同的数字必须分为两个不同的组。 每个组中的XOR数字，我们可以在任一组中找到一个数字。
         *
         * @param nums
         * @return
         */
            // pass 1:
            // get the xor of the two numbers we need to find
            int diff = 0;
            for (int num : nums) {
                diff ^= num;
            }
            // get its last set bit
            diff &= -diff;

            // pass 2:
            // this array stores the two numbers we will return
            int[] rets = {0, 0};
            for (int num : nums) {
                if ((num & diff) == 0) {// the bit is not set
                    rets[0] ^= num;
                } else {// the bit is set
                    rets[1] ^= num;
                }
            }
            return rets;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}