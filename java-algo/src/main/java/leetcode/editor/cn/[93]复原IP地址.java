package leetcode.editor.cn;
//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法

import java.util.ArrayList;
import java.util.List;

class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        solution.restoreIpAddresses("25525511135");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            int len = s.length();
            for (int i = 1; i < 4; i++) {
                for (int j = i + 1; j < i + 4; j++) {
                    for (int k = j + 1; k < j + 4 && k < len; k++) {
                        String s1 = s.substring(0, i);
                        String s2 = s.substring(i, j);
                        String s3 = s.substring(j, k);
                        String s4 = s.substring(k, len);
                        if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                            res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                        }
                    }
                }
            }
            return res;
        }

        /**
         * 3层循环将字符串分割成4个子串：s1,s2,s3,s4,然后检查每个子串是否是有效的
         * 有效的判定条件：字符串的整个长度超过3或者等于0 or 首字符为‘0’并且长度超过1 or 整个字符串转成Integer数字
         *
         * @param s
         * @return
         */
        private boolean isValid(String s) {
            if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
                return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}