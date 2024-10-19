class Solution {
    private int m;  
    private int c;  
    
    public int countMaxOrSubsets(int[] n) {
        m = 0;
        for (int x : n) {
            m |= x;
        }
        c = 0;
        backtrack(n, 0, 0);
        return c;
    }
    
    private void backtrack(int[] n, int idx, int cur) {
        if (cur == m) {
            c += (1 << (n.length - idx));
            return;
        }
        for (int i = idx; i < n.length; i++) {
            backtrack(n, i + 1, cur | n[i]);
        }
    }
}