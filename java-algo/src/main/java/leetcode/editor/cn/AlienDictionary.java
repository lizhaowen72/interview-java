package leetcode.editor.cn;
//现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。
//
// 假设，您并不知道其中字母之间的先后顺序。但是，会收到词典中获得一个 不为空的 单词列表。因为是从词典中获得的，所以该单词列表内的单词已经 按这门新语言的字母顺序进行了排序。 
//
// 您需要根据这个输入的列表，还原出此语言中已知的字母顺序。 
//
// 示例 1： 
//
// 输入:
//[
//  "wrt",
//  "wrf",
//  "er",
//  "ett",
//  "rftt"
//]
//
//输出: "wertf"
// 
//
// 示例 2： 
//
// 输入:
//[
//  "z",
//  "x"
//]
//
//输出: "zx"
// 
//
// 示例 3： 
//
// 输入:
//[
//  "z",
//  "x",
//  "z"
//] 
//
//输出: "" 
//
//解释: 此顺序是非法的，因此返回 ""。
// 
//
// 注意： 
//
// 
// 你可以默认输入的全部都是小写字母 
// 假如，a 的字母排列顺序优先于 b，那么在给定的词典当中 a 定先出现在 b 前面 
// 若给定的顺序是不合法的，则返回空字符串即可 
// 若存在多种可能的合法字母顺序，请返回其中任意一种顺序即可 
// 
// Related Topics 图 拓扑排序


import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        Solution solution = new AlienDictionary().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String alienOrder(String[] words) {
            // 构建图
            Map<Character, Set<Character>> map = new HashMap<>();
            for (int i = 0; i < words.length - 1; i++) {
                for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
                    // 如果字符相同，比较下一个
                    if (words[i].charAt(j) == words[i + 1].charAt(j)) {
                        continue;
                    }
                    // 保存第一个不同的字符顺序
                    Set<Character> set = map.getOrDefault(words[i].charAt(j), new HashSet<>());
                    set.add(words[i + 1].charAt(j));
                    map.put(words[i].charAt(j), set);
                    break;
                }
            }
            //2.拓扑排序
            // 创建保存入度的数组
            int[] degrees = new int[26];
            Arrays.fill(degrees,-1);
            // 注意，不是26字母都在words中出现，所以出度分为两种情况：没有出现的字母的出度为-1，出现了的字母的出度为负数
            for (String str : words) {
                
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}