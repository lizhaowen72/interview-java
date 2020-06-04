package leetcode.editor.cn;
//请设计一个类，使该类的构造函数能够接收一个单词列表。然后再实现一个方法，该方法能够分别接收两个单词 word1 和 word2，并返回列表中这两个单词之间的最短距离。您的方法将被以不同的参数调用 多次。
//
// 示例: 
//假设 words = ["practice", "makes", "perfect", "coding", "makes"] 
//
// 输入: word1 = “coding”, word2 = “practice”
//输出: 3
// 
//
// 输入: word1 = "makes", word2 = "coding"
//输出: 1 
//
// 注意: 
//你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。 
// Related Topics 设计 哈希表


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceIi {
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        WordDistance solution = new ShortestWordDistanceIi().new WordDistance(words);
        solution.shortest("makes", "coding");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDistance {
        Map<String, List<Integer>> map;

        public WordDistance(String[] words) {
            map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                if (!map.containsKey(words[i])) {
                    map.put(words[i], new ArrayList<>());
                }
                List<Integer> list = map.get(words[i]);
                list.add(i);
                map.put(words[i], list);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> word1List = map.get(word1);
            List<Integer> word2List = map.get(word2);
            int res = Integer.MAX_VALUE;
            for (Integer i : word1List) {
                for (Integer j : word2List) {
                    res = Math.min(res, Math.abs(i - j));
                }
            }
            return res;
        }
    }

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}