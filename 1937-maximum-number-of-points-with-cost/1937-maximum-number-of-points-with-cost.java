class Solution {
    public long maxPoints(int[][] grid) {
        int w = grid[0].length;
        long[] cur = new long[w], prev = new long[w];
        long mas = 0;
        
        for (int[] lev : grid) {
            long p = 0;
            for (int i = 0; i < w; ++i) {
                p = Math.max(p - 1, prev[i]);
                cur[i] = p;
            }
            p = 0;
            for (int i = w - 1; i >= 0; --i) {
                p = Math.max(p - 1, prev[i]);
                cur[i] = Math.max(cur[i], p) + lev[i];
            }
            prev = cur;
        }
        for (int i = 0; i < w; ++i) {
            mas = Math.max(mas, prev[i]);
        }
        return mas;
    }
}
