class Solution {
    public int[] decrypt(int[] c, int k) {
        if (k == 0) {
            return new int[c.length];
        }
        int[] c2 = new int[c.length * 2];
        System.arraycopy(c, 0, c2, 0, c.length);
        System.arraycopy(c, 0, c2, c.length, c.length);
        int[] p = new int[c.length * 2 + 1];
        for (int i = 1; i < p.length; ++i) {
            p[i] = c2[i - 1] + p[i - 1];
        }
        for (int i = 0; i < c.length; ++i) {
            int l = k > 0 ? i + 1 : c.length + i + k;
            int r = k > 0 ? i + 1 + k : c.length + i;
            c[i] = p[r] - p[l];
        }
        return c;
    }
}