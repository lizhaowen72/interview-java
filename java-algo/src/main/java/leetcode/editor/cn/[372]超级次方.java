package leetcode.editor.cn;
//你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。 
//
// 示例 1: 
//
// 输入: a = 2, b = [3]
//输出: 8
// 
//
// 示例 2: 
//
// 输入: a = 2, b = [1,0]
//输出: 1024 
// Related Topics 数学 
// 👍 80 👎 0

class SuperPow{
    public static void main(String[] args) {
         Solution solution = new SuperPow().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int superPow(int a, int[] b) {
        if (a % 1337 == 0) return 0;
        int p = 0;
        for (int i : b) p = (p * 10 + i) % 1140;
        if (p == 0) p += 1440;
        return power(a, p, 1337);
    }
    public int power(int a, int n, int mod) {
        a %= mod;
        int ret = 1;
        while (n != 0) {
            if ((n & 1) != 0) ret = ret * a % mod;
            a = a * a % mod;
            n >>= 1;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}