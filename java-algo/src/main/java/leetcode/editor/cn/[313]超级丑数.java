package leetcode.editor.cn;
//编写一段程序来查找第 n 个超级丑数。 
//
// 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。 
//
// 示例: 
//
// 输入: n = 12, primes = [2,7,13,19]
//输出: 32 
//解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26
//,28,32] 。 
//
// 说明: 
//
// 
// 1 是任何给定 primes 的超级丑数。 
// 给定 primes 中的数字以升序排列。 
// 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。 
// 第 n 个超级丑数确保在 32 位有符整数范围内。 
// 
// Related Topics 堆 数学

import java.util.Arrays;
import java.util.PriorityQueue;

class SuperUglyNumber {
    public static void main(String[] args) {
        Solution solution = new SuperUglyNumber().new Solution();
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        solution.nthSuperUglyNumber(n, primes);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
            for (int prime : primes) {
                queue.add(new int[]{prime, prime, 0});
            }
            int[] nums = new int[n + 1];
            nums[0] = 1;
            int i = 1;
            while (i < n) {
                int[] entry = queue.poll();
                int num = entry[0], prime = entry[1], index = entry[2];
                if (num != nums[i - 1]) {
                    nums[i] = num;
                    i++;
                }
                queue.add(new int[]{prime * nums[index + 1], prime, index + 1});
            }
            return nums[n - 1];
        }

        public int nthSuperUglyNumber2(int n, int[] primes) {
            int[] ugly = new int[n];
            int[] idx = new int[primes.length];
            int[] val = new int[primes.length];
            Arrays.fill(val, 1);
            int next = 1;
            for (int i = 0; i < n; i++) {
                ugly[i] = next;
                next = Integer.MAX_VALUE;
                for (int j = 0; j < primes.length; j++) {
                    if (val[j] == ugly[i]) {
                        val[j] = ugly[idx[j]++] * primes[j];
                    }
                    next = Math.min(next, val[j]);
                }
            }
            return ugly[n - 1];
        }

        public int nthSuperUglyNumber1(int n, int[] primes) {
            int[] ugly = new int[n];
            int[] idx = new int[primes.length];
            ugly[0] = 1;
            for (int i = 1; i < n; i++) {
                // find next
                ugly[i] = Integer.MAX_VALUE;
                for (int j = 0; j < primes.length; j++) {
                    ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
                }
                for (int k = 0; k < primes.length; k++) {
                    while (primes[k] * ugly[idx[k]] <= ugly[i]) {
                        idx[k]++;
                    }
                }
            }
            return ugly[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}