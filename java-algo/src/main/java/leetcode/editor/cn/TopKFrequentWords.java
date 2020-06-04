package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//给一非空的单词列表，返回前 k 个出现次数最多的单词。
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 堆 字典树 哈希表
public class TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentWords().new Solution();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        solution.topKFrequent(words, 2);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            TrieNode[] bucket = new TrieNode[words.length];
            Map<String, Integer> freqMap = new HashMap<>();
            for (String word : words) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
            for (String key : freqMap.keySet()) {
                Integer freq = freqMap.get(key);
                if (bucket[freq] == null) {
                    bucket[freq] = new TrieNode();
                }
                addWord(bucket[freq], key);
            }
            List<String> res = new LinkedList<>();
            for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
                if (bucket[pos] != null) {
                    getWord(bucket[pos], res, k);
                }
            }
            return res;
        }

        private void getWord(TrieNode trieNode, List<String> res, int k) {
            if (res.size() == k) return;
            if (trieNode == null) return;
            if (trieNode.word != null) {
                res.add(trieNode.word);
            }
            for (int i = 0; i < 26; i++) {
                if (trieNode.next[i] != null) {
                    getWord(trieNode.next[i], res, k);
                }
            }
        }

        private void addWord(TrieNode trieNode, String key) {
            TrieNode curr = trieNode;
            for (char c : key.toCharArray()) {
                if (curr.next[c - 'a'] == null) {
                    curr.next[c - 'a'] = new TrieNode();
                }
                curr = curr.next[c - 'a'];
            }
            curr.word = key;
        }


    }

    class TrieNode {
        TrieNode[] next;
        String word;

        public TrieNode() {
            this.next = new TrieNode[26];
            this.word = null;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}