package leetcode.editor.cn;
//设计一个支持以下两种操作的数据结构： 
//
// void addWord(word)
//bool search(word)
// 
//
// search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。 
//
// 示例: 
//
// addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true
// 
//
// 说明: 
//
// 你可以假设所有单词都是由小写字母 a-z 组成的。 
// Related Topics 设计 字典树 回溯算法

class AddAndSearchWordDataStructureDesign {
    public static void main(String[] args) {
        WordDictionary solution = new AddAndSearchWordDataStructureDesign().new WordDictionary();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {
        class TrieNode {
            public String item = "";
            public TrieNode[] children = new TrieNode[26];
        }

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TrieNode currNode = root;
            for (char c : word.toCharArray()) {
                if (currNode.children[c - 'a'] == null) {
                    currNode.children[c - 'a'] = new TrieNode();
                }
                currNode = currNode.children[c - 'a'];
            }
            currNode.item = word;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return match(word.toCharArray(), 0, root);
        }

        private boolean match(char[] chs, int K, TrieNode node) {
            if (K == chs.length) {
                return !node.item.equals("");
            }
            if (chs[K] != '.') {
                return node.children[chs[K] - 'a'] != null && match(chs, K + 1, node.children[chs[K] - 'a']);
            }
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, K + 1, node.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}