class Solution {
    public long pickGifts(int[] g, int k) {
        int n = g.length - 1;
        for (int i = 0; i < k; i++) {
            Arrays.sort(g);
            g[n] = (int) Math.sqrt(g[n]);
        }
        long sum = 0;
        for (int i = 0; i < g.length; i++) {
            sum += g[i];
        }
        return sum;
    }
}