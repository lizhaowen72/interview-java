package leetcode.editor.cn;
//所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究
//非常有帮助。 
//
// 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。 
//
// 
//
// 示例： 
//
// 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC", "CCCCCAAAAA"] 
// Related Topics 位运算 哈希表

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RepeatedDnaSequences {
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences().new Solution();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        solution.findRepeatedDnaSequences(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> seen = new HashSet<>();
            Set<String> repeated = new HashSet<>();
            for (int i = 0; i + 9 < s.length(); i++) {
                if (!seen.add(s.substring(i, i + 10))) {
                    repeated.add(s.substring(i, i + 10));
                }
            }
            return new ArrayList<>(repeated);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}