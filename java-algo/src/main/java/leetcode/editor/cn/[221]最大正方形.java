package leetcode.editor.cn;
//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划 
// 👍 522 👎 0

class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] a) {
            if (a.length==0) return 0;
            int m=a.length,n=a[0].length;
            int res=0;
            // dp[i][j]表示以a[i][j]为右下角的正方形的长度
            int[][] dp = new int[m+1][n+1];
            for (int i = 1; i <=m ; i++) {
                for (int j = 1; j <=n ; j++) {
                    if (a[i-1][j-1]=='1'){
                        dp[i][j]=min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1])+1;
                        res= Math.max(res,dp[i][j]);
                    }
                }
            }
            return res*res;
        }
        public int min(int a,int b,int c){
            return Math.min(Math.min(a, b),c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}