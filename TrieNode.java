public class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode(){}
    // Initialize your data structure here.
    public TrieNode(char c) {
        this.val = c;
    }
}
