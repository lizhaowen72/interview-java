package leetcode.editor.cn;

/**
 * @Auther: Administrator
 * @Date: 2019/12/29 21:09
 * @Description: TODO
 */
public class TrieNode {
    TrieNode[] next;
    String word;

    TrieNode() {
        this.next = new TrieNode[26];
        this.word = null;
    }
}
