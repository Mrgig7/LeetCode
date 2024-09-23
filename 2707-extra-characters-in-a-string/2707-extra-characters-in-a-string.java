class TrieNode {
    TrieNode[] node;
    boolean isEnd;
    TrieNode() {
        this.node = new TrieNode[26];
        this.isEnd = false;
    }
}

class Solution {
    TrieNode root;

    private void add(String word) {
        TrieNode temp = root;
        for(char c : word.toCharArray()) {
            int idx = c -'a';
            if(temp.node[idx] == null) {
                temp.node[idx] = new TrieNode();
            }
            temp = temp.node[idx];
        }
        temp.isEnd = true;
    }

    private int helper(int i, String s, Integer[] dp) {
        if(i == s.length()) return 0;
        if(dp[i] != null) return dp[i];
    
        int min = helper(i+1, s, dp)+1;
        TrieNode temp = root;
        int j = i;

        while(j < s.length()) {
            int idx = s.charAt(j)-'a';
            temp = temp.node[idx];
            
            if(temp == null) break;
            if(temp.isEnd) min = Math.min(min, helper(j+1, s, dp));
    
            j++;
        }
        return dp[i] = min;
    }
    public int minExtraChar(String s, String[] dictionary) {
        root = new TrieNode();
        for(String word : dictionary) {
            add(word);
        }
        return helper(0, s, new Integer[s.length()]);
    }
}