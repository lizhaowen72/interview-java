package leetcode.editor.cn;
//给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可
//以持续进行 “移位” 操作，从而生成如下移位序列： 
//
// "abc" -> "bcd" -> ... -> "xyz" 
//
// 给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。 
//
// 示例： 
//
// 输入: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
//输出: 
//[
//  ["abc","bcd","xyz"],
//  ["az","ba"],
//  ["acef"],
//  ["a","z"]
//]
// 
// Related Topics 哈希表 字符串

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupShiftedStrings {
    public static void main(String[] args) {
        Solution solution = new GroupShiftedStrings().new Solution();
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        solution.groupStrings(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            List<List<String>> res = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strings) {
                StringBuilder sb = new StringBuilder();
                char[] chars = str.toCharArray();
                for (int i = 1; i < chars.length; i++) {
                    int diff = chars[i] - chars[i - 1] < 0 ? chars[i] - chars[i - 1] + 26 : chars[i] - chars[i - 1];
                    sb.append(diff).append(",");
                }
                String key = sb.toString().equals("") ? "*" : sb.substring(0, sb.length() - 1);
                List<String> list = map.get(key);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(str);
                map.put(key, list);
            }
            for (List<String> value : map.values()) {
                res.add(value);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}