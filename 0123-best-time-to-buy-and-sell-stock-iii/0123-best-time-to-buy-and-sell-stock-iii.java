class Solution {
    public int maxProfit(int[] pri) {
        if(pri == null || pri.length < 1) return 0;
        int b1 = -pri[0], s1 = 0, b2 = -pri[0], s2 = 0;
        for(int i = 1; i < pri.length; i++) {
            b1 = Math.max(b1, -pri[i]);
            s1 = Math.max(s1, b1 + pri[i]);
            b2 = Math.max(b2, s1 - pri[i]);
            s2 = Math.max(s2, b2 + pri[i]);
        }
        return s2;
    }
}