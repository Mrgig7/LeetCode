class TrieNode {
    public int freq = 0;
    TrieNode[] node = null;
    public TrieNode() {
        node = new TrieNode[26];
    }
}
class Solution {
public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            helper(w, root);
        }
        int res[] = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int s = 0;
            TrieNode curr = root;
            for (char c : words[i].toCharArray()) {
                curr = curr.node[c - 'a'];
                s = s + curr.freq;
            }
            res[i] = s;
        }
        return res;
    }

    private void helper(String w, TrieNode root) {
        char[] arr = w.toCharArray();
        TrieNode curr = root;
        for (char c : arr) {
            if (curr.node[c - 'a'] == null) {
                curr.node[c - 'a'] = new TrieNode();
            }
            curr.node[c - 'a'].freq++;
            curr = curr.node[c - 'a'];
        }
    }
    
}